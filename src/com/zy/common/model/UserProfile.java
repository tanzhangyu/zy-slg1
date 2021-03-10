package com.zy.common.model;

import io.netty.channel.Channel;

public class UserProfile {
	private long uid;
	private Channel channel;

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

}
