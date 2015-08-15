package com.coreframework.util;

import java.io.IOException;

import java.net.URL;

import org.apache.commons.io.IOUtils;

/**
 * Utility class for file handling.
 */
public final class FileUtils
{
    private FileUtils() {}

	public static String readURLToString(final URL url) throws IOException
	{
		return readURLToStringArray(url)[0];
	}

	public static String[] readURLToStringArray(final URL url) throws IOException
	{
		return ArrayListMapUtils.listToArray(IOUtils.readLines(url.openStream()));
	}
}
