package com.zy.common.mq;

import com.zy.common.message.ZyMessage;

public class MQLoginRunnable implements Runnable {
	private ZyMQ channel;

	public MQLoginRunnable(ZyMQ mq) {
		this.channel = mq;
	}

	@Override
	public void run() {
		while (true) {
			ZyMessage zyMessage = channel.take();
			LoginHandlerCenter.handleMQ(zyMessage);
		}
	}

}
