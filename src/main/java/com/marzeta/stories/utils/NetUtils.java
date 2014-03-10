package com.marzeta.stories.utils;

import java.net.URI;
import java.net.URISyntaxException;

public class NetUtils {
	public static String assembleUrl(String... parts) throws URISyntaxException {
		if (parts != null && parts.length > 0) {
			String prefix = "";
			StringBuilder builder = new StringBuilder();
			for (String part : parts) {
				if (!isBlank(part)) {
					builder.append(prefix);
					builder.append(URI.create(part.trim()));
					prefix = "/";
				}
			}
			if (!prefix.isEmpty()) {
				return new URI(builder.toString()).normalize().toString();
			}
		}
		return null;
	}

	public static boolean isBlank(String part) {
		if (part == null || part.length() == 0) {
			return true;
		}
		return false;
	}
}
