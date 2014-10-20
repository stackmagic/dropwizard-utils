package net.swisstech.dropwizard.util;

import io.dropwizard.Bundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import com.codahale.metrics.health.HealthCheck;

/** no-op health check where you don't have/need any, like when you're just starting out or create a template project for others */
public class DummyHealthCheckBundle extends HealthCheck implements Bundle {

	@Override
	public void initialize(Bootstrap<?> bootstrap) {}

	@Override
	public void run(Environment environment) {
		environment.healthChecks().register(this.getClass().getName(), this);
	}

	@Override
	protected Result check() throws Exception {
		return Result.healthy("you should really add some real health checks to your app!");
	}
}
