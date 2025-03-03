package com.borntocode.main.aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.micrometer.observation.Observation;
import io.micrometer.observation.Observation.Context;
import io.micrometer.observation.ObservationHandler;

public class PerformaceTrakerHandler implements ObservationHandler<Observation.Context> {

	private static final Logger log = LoggerFactory.getLogger(PerformaceTrakerHandler.class);

	@Override
	public void onStart(Context context) {
		log.info("execution started {}", context.getName());
		context.put("time", System.currentTimeMillis());
	}

	@Override
	public void onError(Context context) {
		log.info("Error occurred {}", context.getError().getMessage());
	}

	@Override
	public void onStop(Context context) {
		log.info("execution stoped " + context.getName() + " duration "
				+ (System.currentTimeMillis() - context.getOrDefault("time", 0L)));
	}

	@Override
	public boolean supportsContext(Context context) {
		return true;
	}

}
