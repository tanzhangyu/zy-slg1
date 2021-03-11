package com.zy.common.utils;

import java.io.File;

import com.alibaba.fastjson.JSONObject;

public class DataReader {

	private static final String RESOURCE_PATH = "resource/";

	private static JSONObject allJson = new JSONObject();

	public static void loadAllData() {
		File file = new File(RESOURCE_PATH);
		if (file.isDirectory()) {
			loadDirectory(file);
		}
		init();
	}

	public static void loadDirectory(File file) {

	}

	public static void init() {

	}

}
