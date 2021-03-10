package com.zy.game.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zy.common.constant.GameExceptionCode;
import com.zy.common.core.ZyEngine;
import com.zy.common.message.generate.ResponeMessageProtoBuf.GameResponeMsg;
import com.zy.game.manager.ChannelManager;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public abstract class AbstractZyHandler extends ChannelInboundHandlerAdapter {

	private Logger logger = LoggerFactory.getLogger(AbstractZyHandler.class);

	@Override
	public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
		if (!ZyEngine.getInstance().isRunning()) {
			GameResponeMsg.Builder builder = GameResponeMsg.newBuilder();
			builder.setError(GameExceptionCode.SERVER_NOT_RUNNING);
			ctx.channel().writeAndFlush(builder);
			ctx.close();
			return;
		}
		ctx.fireChannelRegistered();
		ChannelManager.getInstance().put(ctx.channel());
	}

	@Override
	public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("¶Ï¿ªÁ¬½Ó ");
		ctx.close();
	}

	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		// TODO Auto-generated method stub
		super.userEventTriggered(ctx, evt);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		// TODO Auto-generated method stub
		ctx.close();
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
	}
}
