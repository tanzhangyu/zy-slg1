package com.zy.game.utils;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class PropertiesReader {

	public static final String REDIS_PRO = "redis";
	public static final String SERVER_PRO = "server";
	private static ConcurrentHashMap<String, Properties> pros = new ConcurrentHashMap<String, Properties>();

	private static String getItem(String paramString0, String paramString1, String paramString2) {
		Properties pro = pros.get(paramString0);
		if (pro == null) {
			return paramString2;
		}
		String configValue = pro.getProperty(paramString1);
		if (configValue == null || "null".equals(configValue) || "".equals(configValue)) {
			return paramString2;
		}
		return configValue;
	}

	public static int getIntItem(String name, String key, int defaultValue) {
		return Integer.parseInt(getItem(name, key, String.valueOf(defaultValue)));
	}

	public static String getStringItem(String name, String key, String defaultValue) {
		return getItem(name, key, defaultValue);
	}

	public static boolean getBoolItem(String name, String key, boolean defaultValue) {
		return Boolean.parseBoolean(getItem(name, key, String.valueOf(defaultValue)));
	}

	static {
		Map<String, String> proMap = new HashMap<String, String>();
		proMap.put(REDIS_PRO, "gameConfig/redis.properties");
		proMap.put(SERVER_PRO, "gameConfig/server.properties");
		Iterator<Entry<String, String>> it = proMap.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, String> entry = it.next();
			String key = entry.getKey();
			String value = entry.getValue();
			Properties pro = new Properties();
			try {
				FileInputStream in = new FileInputStream(value);
				pro.load(in);
				in.close();
				pros.put(key, pro);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
