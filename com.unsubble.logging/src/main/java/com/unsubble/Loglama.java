package com.unsubble;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Loglama {
	public void log() {
		Logger logger = LogManager.getLogger();
		logger.warn("log3 yazdi.");
	}
}
