package com.coreframework.util;

import java.lang.reflect.Array;

import java.util.List;
import java.util.Arrays;

/**
 * Utility class for array, list, and map handling.
 */
public final class ArrayListMapUtils
{
    private ArrayListMapUtils() {}

	public static <T> T[] listToArray(final List<T> list)
	{
		final T[] genericArray = (T[])Array.newInstance(list.get(0).getClass(), list.size());

		for(int i = 0; i < list.size(); i++)
		{
			genericArray[i] = list.get(i);
		}

		return genericArray;
	}

	public static <T> List<T> arrayToList(final T[] array)
	{
		return Arrays.asList(array);
	}
}
