package com.ngnl.hotAgent;

import java.lang.instrument.Instrumentation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Prject: hotAgent
 * @author: 47
 * @date: 2019年6月20日 下午7:45:59
 */
public class AgentMain {
	private static final Logger logger = LoggerFactory.getLogger(AgentMain.class);

	private static Instrumentation instrumentation;
	private static Object lockObject = new Object();

	public static void agentmain(String args, Instrumentation inst) {
		synchronized (lockObject) {
			if (instrumentation == null) {
				logger.info("agentmain called, init instrumentation inst");
				instrumentation = inst;
			} else {
				logger.info("agentmain called, already init");
			}
		}
	}

	public static Instrumentation getInstrumentation() {
		return instrumentation;
	}
}
