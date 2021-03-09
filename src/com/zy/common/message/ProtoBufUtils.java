package com.zy.common.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.protobuf.InvalidProtocolBufferException;
import com.zy.common.core.ZyLogger;
import com.zy.common.message.generate.RequestMessageProtoBuf.GameRequestMsg;
import com.zy.common.message.generate.ResponeMessageProtoBuf.GameResponeMsg;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class ProtoBufUtils {
	private static final Logger logger = LoggerFactory.getLogger(ProtoBufUtils.class);

	public static GameRequestMsg parseMessage(ByteBuf msg) {
		GameRequestMsg gameRequestMsg = null;
		try {
			int lenght = msg.readableBytes();
			byte[] bs = new byte[lenght];
			msg.readBytes(bs);
			gameRequestMsg = GameRequestMsg.parseFrom(bs);
			return gameRequestMsg;
		} catch (InvalidProtocolBufferException e) {
			ZyLogger.handleException(e);
		}
		return gameRequestMsg;
	}

	public static ByteBuf createByteBuf(GameResponeMsg msg) {
		ByteBuf buf = Unpooled.buffer();
		buf.writeBytes(msg.toByteArray());
		return buf;
	}
}
