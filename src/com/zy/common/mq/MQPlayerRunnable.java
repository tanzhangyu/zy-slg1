package com.zy.common.mq;

import com.zy.common.message.ZyMessage;

public class MQPlayerRunnable implements Runnable {
	private ZyMQ channel;

	public MQPlayerRunnable(ZyMQ mq) {
		this.channel = mq;
	}

	@Override
	public void run() {
		while (true) {
			ZyMessage zyMessage = channel.take();
			PlayerHandlerCenter.handleMQ(zyMessage);
		}
	}

}
