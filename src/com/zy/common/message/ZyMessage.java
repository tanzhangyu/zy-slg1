package com.zy.common.message;

import com.zy.common.message.generate.RequestMessageProtoBuf.GameRequestMsg;

public class ZyMessage {
	private String cmd;
	private String channelId;
	private long userUid;
	private GameRequestMsg parms;

	public ZyMessage() {
	}

	public ZyMessage(String cmd, String channelId, GameRequestMsg parms) {
		this.cmd = cmd;
		this.channelId = channelId;
		this.parms = parms;
	}

	public ZyMessage(String cmd, String channelId, long userUid, GameRequestMsg parms) {
		this.cmd = cmd;
		this.channelId = channelId;
		this.userUid = userUid;
		this.parms = parms;
	}

	public ZyMessage(String cmd, long userUid, GameRequestMsg parms) {
		this.cmd = cmd;
		this.userUid = userUid;
		this.parms = parms;
	}

	public String getCmd() {
		return cmd;
	}

	public String getChannelId() {
		return channelId;
	}

	public long getUserUid() {
		return userUid;
	}

	public GameRequestMsg getParms() {
		return parms;
	}

}
