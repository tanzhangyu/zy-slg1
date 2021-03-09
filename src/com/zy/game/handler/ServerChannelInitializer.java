package com.zy.game.handler;

import java.util.concurrent.TimeUnit;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

public class ServerChannelInitializer extends ChannelInitializer<NioSocketChannel> {

	@Override
	protected void initChannel(NioSocketChannel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();
		pipeline.addLast("encoder", new MessagePacketEncoder());
		pipeline.addLast("decoder", new MessagePacketDecoder());
		pipeline.addLast("idleStateHandler", new IdleStateHandler(60, 60, 60, TimeUnit.MINUTES));
		pipeline.addLast("handler", new ZyHandler());
	}

}
