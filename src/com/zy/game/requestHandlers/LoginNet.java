package com.zy.game.requestHandlers;

import com.zy.common.core.ZyException;
import com.zy.common.message.generate.RequestMessageProtoBuf.C2G_LoginParms;
import com.zy.common.message.generate.RequestMessageProtoBuf.GameRequestMsg;
import com.zy.common.message.generate.ResponeMessageProtoBuf.GameResponeMsg;
import com.zy.common.model.UserProfile;

import io.netty.channel.Channel;

public class LoginNet {

	public static GameResponeMsg userLogin(Channel channel, GameRequestMsg requestMsg) throws ZyException {
		if (!requestMsg.hasC2GLoginParms()) {
		}
		C2G_LoginParms loginParms = requestMsg.getC2GLoginParms();
//		loginParms.getAccount();
//		loginParms.getPassword();

//		MQUtils.getInstance().putPlayerMQ(CMDConstants.GAME_LOGIN, 0, parms);
		return null;
	}

	public static GameResponeMsg gameLogin(UserProfile userProfile, GameRequestMsg requestMsg) throws ZyException {
		return null;
	}
}
