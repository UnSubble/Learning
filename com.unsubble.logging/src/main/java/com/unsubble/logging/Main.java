package com.unsubble.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.unsubble.Loglama;
import com.unsubble.log.Logger2;

public class Main {
	public void log1() {
		Logger logger = LogManager.getLogger();
		logger.fatal("log1 calisti");
	}
	
	public static void main(String[] args) {
		new Main().log1();
		new Logger2().log();
		new Loglama().log();		
	}
}
