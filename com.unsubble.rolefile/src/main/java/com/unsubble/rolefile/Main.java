package com.unsubble.rolefile;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
	public static void main(String[] args) {
		Logger logger = LogManager.getLogger();
		
		logger.log(Level.WARN, "Logger yazdi");
		for(int i = 0; i < 100; i++) {
			logger.warn("Logger");
		}
	}
}
