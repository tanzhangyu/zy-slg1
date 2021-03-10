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
import com.zy.game.manager.ChannelManager;
import com.zy.game.requestHandlers.LoginNet;

import io.netty.channel.Channel;

public class LoginHandlerCenter {
	private static Logger logger = LoggerFactory.getLogger(LoginHandlerCenter.class);
	private static ConcurrentHashMap<String, LoginHandler<GameResponeMsg, Channel, GameRequestMsg>> handleMap = new ConcurrentHashMap<String, LoginHandler<GameResponeMsg, Channel, GameRequestMsg>>();

	static {
		handleMap.put(CMDConstants.USER_LOGIN, LoginNet::userLogin);
	}

	public static void handleMQ(ZyMessage message) {
		System.out.println(message.getParms().toString());
		long t1 = System.currentTimeMillis();
		String cmd = message.getCmd();
		String channelId = message.getChannelId();
		Channel channel = null;
		if (channelId != null && !channelId.equals("")) {
			channel = ChannelManager.getInstance().getChannelByLongText(channelId);
			if (channel == null) {
				return;
			}
		}
		try {
			GameResponeMsg responeMsg = _handleMQ(cmd, channel, message.getParms());
			if (responeMsg != null && channel != null) {
				MessageUtils.sendMessage(cmd, responeMsg, channel);
			}
		} catch (ZyException e) {
			if (channel != null) {
				GameResponeMsg.Builder responeMsgBuilder = GameResponeMsg.newBuilder();
				responeMsgBuilder.setError(e.getExceptionCode());
				MessageUtils.sendMessage(cmd, responeMsgBuilder.build(), channel);
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

	private static GameResponeMsg _handleMQ(String cmd, Channel channel, GameRequestMsg gameRequestMsg)
			throws ZyException {
		LoginHandler<GameResponeMsg, Channel, GameRequestMsg> handle = handleMap.get(cmd);
		if (handle == null) {
			logger.error("not find cmd--->" + cmd);
			return null;
		}
		return handle._handler(channel, gameRequestMsg);
	}

	public static boolean isLoginCmd(String cmd) {
		return handleMap.containsKey(cmd);
	}
}
