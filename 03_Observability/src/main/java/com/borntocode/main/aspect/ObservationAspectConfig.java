package com.borntocode.main.aspect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.aop.ObservedAspect;

@Configuration
public class ObservationAspectConfig {

	@Bean
	public ObservedAspect observedAspect(ObservationRegistry observationRegistry) {
		observationRegistry.observationConfig().observationHandler(new PerformaceTrakerHandler());
		return new ObservedAspect(observationRegistry);
	}
}
