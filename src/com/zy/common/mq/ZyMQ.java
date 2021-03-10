package com.zy.common.mq;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import com.zy.common.core.ZyLogger;
import com.zy.common.message.ZyMessage;

public class ZyMQ {
	private BlockingQueue<ZyMessage> queue = new LinkedBlockingDeque<ZyMessage>(10000);

	public void put(ZyMessage message) {
		try {
			queue.put(message);
		} catch (InterruptedException e) {
			ZyLogger.handleException(e);
		}
	}

	public ZyMessage take() {
		try {
			return queue.take();
		} catch (InterruptedException e) {
			ZyLogger.handleException(e);
		}
		return null;
	}
}
