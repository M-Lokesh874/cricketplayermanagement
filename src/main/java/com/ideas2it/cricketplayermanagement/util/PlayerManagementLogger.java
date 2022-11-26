package com.ideas2it.cricketplayermanagement.util;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class PlayerManagementLogger {

	public static Logger logger = LogManager.getLogger(PlayerManagementLogger.class);
	public static void info(String message) {
		logger.info(message);
	}

	public static void info(Exception exception, String message) {
		logger.info(message);
		logger.info(exception);
	}

	public static void error(String message) {
		logger.error(message);
	}

	public static void error(Exception message) {
		logger.error(message);
	}

	public static void playerManagementWarn(String message) {
		logger.warn(message);
	}
}