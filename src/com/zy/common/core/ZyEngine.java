package com.zy.common.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zy.common.constant.ServerConstants;
import com.zy.common.db.MyBatisUtils;
import com.zy.common.mq.MQUtils;
import com.zy.common.utils.DataReader;
import com.zy.common.utils.PropertiesReader;
import com.zy.game.handler.ServerChannelInitializer;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class ZyEngine {
	private static final Logger logger = LoggerFactory.getLogger(ZyEngine.class);
	private volatile int serverState;
	private volatile int gameNodeId;// 区服id
	private volatile int port;
	private EventLoopGroup boosGroup;
	private EventLoopGroup workGroup;

	public static void main(String[] args) {
		ZyEngine.getInstance().init();
	}

	private static class LazyHolder {
		private static final ZyEngine INSTANCE = new ZyEngine();
	}

	public static ZyEngine getInstance() {
		return LazyHolder.INSTANCE;
	}

	private void init() {
		logger.info("ZyEngine is init");
		try {
			this.loadServerInfo();
			DataReader.loadAllData();
			MyBatisUtils.init();
			MQUtils.getInstance().init();
			ZyEngine.getInstance().start();
		} catch (Exception e) {
			ZyLogger.handleException(e);
		}
	}

	private void loadServerInfo() {
		this.port = PropertiesReader.getIntItem(PropertiesReader.SERVER_PRO, "port", 8888);
		this.gameNodeId = PropertiesReader.getIntItem(PropertiesReader.SERVER_PRO, "gameNodeId", 1);
	}

	private void start() {
		this.serverState = ServerConstants.INIT;
		this.boosGroup = new NioEventLoopGroup();
		this.workGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap bootstrap = new ServerBootstrap();
			bootstrap.group(boosGroup, workGroup);
			bootstrap.channel(NioServerSocketChannel.class);
			bootstrap.childHandler(new ServerChannelInitializer());
			// 标识当服务器请求处理线程全满时，用于临时存放已完成三次握手的请求的队列的最大长度
			bootstrap.option(ChannelOption.SO_BACKLOG, 1024);
			// 启用心跳保活机机制
			bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);
			ChannelFuture future = bootstrap.bind(this.port).sync();
			if (future.isSuccess()) {
				this.serverState = ServerConstants.RUNNING;
				logger.info("netty server loading success");
			}
		} catch (InterruptedException e) {
			ZyLogger.handleException(e);
			stopServer();
		}
	}

	public void setServerState(int serverState) {
		this.serverState = serverState;
	}

	public boolean isIniting() {
		return this.serverState == ServerConstants.INIT;
	}

	public boolean isRunning() {
		return this.serverState == ServerConstants.RUNNING;
	}

	public boolean isShutdown() {
		return this.serverState == ServerConstants.SHUTDOWN;
	}

	public boolean isError() {
		return this.serverState == ServerConstants.ERROR;
	}

	private void stopServer() {
		if (isRunning()) {
			this.boosGroup.shutdownGracefully();
			this.workGroup.shutdownGracefully();
		}
	}
}
