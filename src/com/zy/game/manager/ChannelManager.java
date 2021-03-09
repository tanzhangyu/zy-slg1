package com.zy.game.manager;

import java.util.concurrent.ConcurrentHashMap;

import io.netty.channel.Channel;

public class ChannelManager {

	private ConcurrentHashMap<String, Channel> channelMap = new ConcurrentHashMap<String, Channel>(2000);

	public Channel getChannelByLongText(String id) {
		return channelMap.get(id);
	}

	public void put(Channel channel) {
		channelMap.put(channel.id().asLongText(), channel);
	}

	public void remove(String id) {

	}

	private static class LazyHolder {
		private static final ChannelManager INSTANCE = new ChannelManager();
	}

	public static ChannelManager getInstance() {
		return LazyHolder.INSTANCE;
	}
}
