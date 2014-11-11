package net.swisstech.dropwizard.util;

import io.dropwizard.Bundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;

/**
 * just a dummy resource which is also a bundle for easy registration - this is just a placeholder until you've added some real resources to your skeleton
 * projects
 */
@Path("/net_swisstech_dropwizard_util_DummyResourceBundle")
@Produces(MediaType.APPLICATION_JSON)
public class DummyResourceBundle implements Bundle {

	@Override
	public void initialize(Bootstrap<?> bootstrap) {}

	@Override
	public void run(Environment environment) {
		environment.jersey().register(this);
	}

	@Timed
	@GET
	public String uptime() {
		return "you should really add some real resources to your app!";
	}
}
