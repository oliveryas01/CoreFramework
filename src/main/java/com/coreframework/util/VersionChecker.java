package com.coreframework.util;

import java.io.IOException;

import java.net.URL;

import com.coreframework.common.CoreFramework;

/**
 * A class that checks if CoreFramework is up to date.
 */
public final class VersionChecker
{
    private VersionChecker() {}

	public static boolean isLatestVersion() throws IOException
	{
		final String localVersion = CoreFramework.VERSION;
		final String latestVersion = FileUtils.readURLToString(new URL("https://raw.githubusercontent.com/oliveryas01/CoreFramework/master/version_file2"));

		return localVersion.equals(latestVersion);
	}
}
