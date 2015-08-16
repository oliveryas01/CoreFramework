package com.coreframework.client.gui;

import java.util.List;

import com.coreframework.client.gui.css.Styleable;

/**
 * The base class for all GUI elements.
 */
abstract class Node implements Styleable
{
	/**
	 * Construct a Node.
	 *
	 * @param name The name of the Node.
	 */
    protected Node(final String name)
	{
		this.name = name;
	}

	/**
	 * The name of the Node.
	 */
	protected String name;

	/**
	 * Initialize the Node.
	 *
	 * Parse your CSS properties here.
	 */
	public void initialize() {}

	/**
	 * Get the list of CSS classes.
	 *
	 * @return The list of CSS classes.
	 */
	public final List<String> getClasses()
	{
		return classes;
	}

	/**
	 * Add a CSS class.
	 *
	 * @param class0 A CSS class.
	 */
	public final void addClass(final String class0)
	{
		if(!classes.add(class0)) throw new IllegalArgumentException("Node already contains that class.");
	}

	/**
	 * Remove a CSS class.
	 *
	 * @param class0 A CSS class.
	 */
	public final void removeClass(final String class0)
	{
		if(!classes.remove(class0)) throw new IllegalArgumentException("Node does not contain that class.");
	}
}
