package com.zy.common.mq;

import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zy.common.constant.CMDConstants;
import com.zy.common.core.ZyException;
import com.zy.common.core.ZyLogger;
import com.zy.common.message.MessageUtils;
import com.zy.common.message.ZyMessage;
import com.zy.common.message.generate.RequestMessageProtoBuf.GameRequestMsg;
import com.zy.common.message.generate.ResponeMessageProtoBuf.GameResponeMsg;
import com.zy.common.model.UserProfile;
import com.zy.game.manager.UserManager;
import com.zy.game.requestHandlers.LoginNet;

public class PlayerHandlerCenter {
	private static Logger logger = LoggerFactory.getLogger(PlayerHandlerCenter.class);
	private static ConcurrentHashMap<String, PlayerHandler<GameResponeMsg, UserProfile, GameRequestMsg>> handleMap = new ConcurrentHashMap<String, PlayerHandler<GameResponeMsg, UserProfile, GameRequestMsg>>();

	static {
		handleMap.put(CMDConstants.GAME_LOGIN, LoginNet::gameLogin);
	}

	public static void handleMQ(ZyMessage message) {
		long t1 = System.currentTimeMillis();
		String cmd = message.getCmd();
		long userUid = message.getUserUid();
		UserProfile userProfile = null;
		if (userUid > 0) {
			userProfile = UserManager.getInstance().getUserProfile(userUid);
			if (userProfile == null) {
				return;
			}
		}
		try {
			GameResponeMsg respMsg = _handleMQ(cmd, userProfile, message.getParms());
			if (respMsg != null && userProfile != null && userProfile.getChannel() != null) {
				MessageUtils.sendMessage(cmd, respMsg, userProfile.getChannel());
			}
		} catch (ZyException e) {
			if (userProfile != null && userProfile.getChannel() != null) {
				GameResponeMsg.Builder responeMsgBuilder = GameResponeMsg.newBuilder();
				responeMsgBuilder.setError(e.getExceptionCode());
				MessageUtils.sendMessage(cmd, responeMsgBuilder.build(), userProfile.getChannel());
			}
		} catch (Throwable e) {
			ZyLogger.handleException(e);
		} finally {

		}
		long t2 = System.currentTimeMillis();
		if (t2 - t1 > 15) {
			logger.info("protocol---cost>" + cmd + "\t" + message.getParms().toString() + "\t" + (t2 - t1));
		}
	}

	private static GameResponeMsg _handleMQ(String cmd, UserProfile userProfile, GameRequestMsg gameRequestMsg)
			throws ZyException {
		PlayerHandler<GameResponeMsg, UserProfile, GameRequestMsg> handle = handleMap.get(cmd);
		return handle._handler(userProfile, gameRequestMsg);
	}

}
