package com.zy.game.manager;

import java.util.concurrent.ConcurrentHashMap;

import com.zy.common.model.UserProfile;

public class UserManager {

	private ConcurrentHashMap<Long, UserProfile> users = new ConcurrentHashMap<Long, UserProfile>();

	private static class LazyHolder {
		private static final UserManager INSTANCE = new UserManager();
	}

	public static UserManager getInstance() {
		return LazyHolder.INSTANCE;
	}

	public UserProfile getUserProfile(long uid) {
		if (uid <= 0) {
			return null;
		}
		UserProfile userProfile = users.get(uid);
		if (userProfile == null) {
			// 去数据库查找
			return userProfile;
		}
		return null;
	}

	public void addUserProfile(UserProfile userProfile) {
		users.put(userProfile.getUid(), userProfile);
	}

}
