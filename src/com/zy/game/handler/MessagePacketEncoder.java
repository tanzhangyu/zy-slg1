package com.zy.game.handler;

import java.util.List;

import com.zy.common.message.ProtoBufUtils;
import com.zy.common.message.generate.ResponeMessageProtoBuf.GameResponeMsg;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

/**
 * ±àÂëÆ÷
 * 
 * @author tanzhangyu
 *
 */
public class MessagePacketEncoder extends MessageToMessageEncoder<GameResponeMsg> {

	@Override
	protected void encode(ChannelHandlerContext ctx, GameResponeMsg msg, List<Object> out) throws Exception {
		// TODO Auto-generated method stub
		out.add(ProtoBufUtils.createByteBuf(msg));
	}

}
