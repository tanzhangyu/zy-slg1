package com.zy.common.message;

import com.zy.common.message.generate.ResponeMessageProtoBuf.GameResponeMsg;

import io.netty.channel.Channel;

public class MessageUtils {

	public static void sendMessage(String cmd, GameResponeMsg gameResponeMsg, Channel channel) {
		gameResponeMsg.toBuilder().setCmd(cmd);
		channel.writeAndFlush(gameResponeMsg);
	}

}
