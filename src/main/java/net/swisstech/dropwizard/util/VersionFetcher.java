package net.swisstech.dropwizard.util;

import static net.swisstech.swissarmyknife.lang.Strings.notBlank;

import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

/** util to get the version banner, use this from your dummy tests */
public class VersionFetcher {

	/**
	 * fetches and enforces non-null/non-empty-ness of the version banner
	 * @param admUrl one of the env vars passed to your tests (one of DROPWIZARD_ADM_HTTP, DROPWIZARD_ADM_HTTPS, DROPWIZARD_ADM_SPDY3)
	 * @return the version banner
	 * @throws IOException for malformed urls or io problems
	 * @throws IllegalArgumentException if the banner is null/empty
	 * @see the docs on writing integration/acceptance tests at https://github.com/stackmagic/gradle-dropwizard
	 */
	public static String getVersion(String admUrl) throws IOException {
		URL url = new URL(admUrl + "/version");
		String version = IOUtils.toString(url);
		return notBlank(version);
	}
}
