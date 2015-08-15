package com.coreframework.client.gui.css;

import java.util.List;
import java.util.ArrayList;

/**
 * Defines a class that can be styled.
 */
public interface Styleable
{
	/**
	 * The CSS id.
	 *
	 * @return The CSS id.
	 */
	String id();

	/**
	 * The list of CSS classes.
	 */
	List<String> classes = new ArrayList<String>();
}
