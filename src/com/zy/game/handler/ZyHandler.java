package com.zy.game.handler;

import com.zy.common.message.generate.RequestMessageProtoBuf.GameRequestMsg;
import com.zy.common.mq.MQUtils;

import io.netty.channel.ChannelHandlerContext;

public class ZyHandler extends AbstractZyHandler {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		GameRequestMsg gameRequestMsg = (GameRequestMsg) msg;
		gameRequestMsg.toBuilder().clearCmd();
		gameRequestMsg.toBuilder().clearUserUid();
		MQUtils.getInstance().handleClientMQ(gameRequestMsg.getCmd(), ctx.channel().id().asLongText(),
				gameRequestMsg.getUserUid(), gameRequestMsg);
	}

}
