package net.swisstech.dropwizard.utils;

import io.dropwizard.Bundle;
import io.dropwizard.setup.AdminEnvironment;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** http-servlet that is also a dropwizard bundle and registers itself with the admin context */
public final class VersionBundle extends HttpServlet implements Bundle {

	private static final long serialVersionUID = 6724652387278196650L;

	private static final String VERSION = System.getProperty("SERVER_VERSION");

	@Override
	public void initialize(Bootstrap<?> bootstrap) {}

	@Override
	public void run(Environment environment) {
		AdminEnvironment admin = environment.admin();
		admin.addServlet("version", this).addMapping("/version");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		writer.write(VERSION);
		writer.flush();
	}
}
