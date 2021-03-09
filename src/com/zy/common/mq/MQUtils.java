package com.zy.common.mq;

import com.zy.common.message.ZyMessage;
import com.zy.common.message.generate.RequestMessageProtoBuf.GameRequestMsg;

public class MQUtils {
	private ZyMQ playerMQ = new ZyMQ();
	private ZyMQ loginMQ = new ZyMQ();

	public void handleClientMQ(String cmd, String channelId, long userId, GameRequestMsg gameRequestMsg) {
		if (LoginHandlerCenter.isLoginCmd(cmd)) {
			putLoginMQ(cmd, channelId, gameRequestMsg);
		} else {
			putPlayerMQ(cmd, userId, gameRequestMsg);
		}
	}

	public void init() {
		new Thread(new MQPlayerRunnable(playerMQ), "Thread-MQ-player").start();
		new Thread(new MQLoginRunnable(loginMQ), "Thread-MQ-login").start();
	}

	public void putPlayerMQ(String cmd, long userUid, GameRequestMsg parms) {
		this.playerMQ.put(new ZyMessage(cmd, userUid, parms));
	}

	public void putLoginMQ(String cmd, String channelId, GameRequestMsg parms) {
		this.loginMQ.put(new ZyMessage(cmd, channelId, parms));
	}

	private static class LazyHolder {
		private static final MQUtils INSTANCE = new MQUtils();
	}

	public static MQUtils getInstance() {
		return LazyHolder.INSTANCE;
	}
}
