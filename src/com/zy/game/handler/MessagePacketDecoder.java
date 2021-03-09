package com.zy.game.handler;

import java.util.List;

import com.zy.common.message.ProtoBufUtils;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

/**
 * ½âÂëÆ÷
 * 
 * @author tanzhangyu
 *
 */
public class MessagePacketDecoder extends MessageToMessageDecoder<ByteBuf> {

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
		out.add(ProtoBufUtils.parseMessage(msg));
	}

}
