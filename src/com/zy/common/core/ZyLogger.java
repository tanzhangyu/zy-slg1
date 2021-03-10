package com.zy.common.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZyLogger {
	private static final Logger SystemErrorEcxception = LoggerFactory.getLogger("SystemErrorEcxception");

	public static void handleException(Throwable t) {
		SystemErrorEcxception.error("", t);
	}
}
