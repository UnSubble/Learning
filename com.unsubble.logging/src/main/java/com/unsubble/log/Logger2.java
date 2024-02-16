package com.unsubble.log;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logger2 {
	public void log() {
		Logger logger = LogManager.getLogger();
		logger.log(Level.INFO, "Log2 completed.");
	}
}
