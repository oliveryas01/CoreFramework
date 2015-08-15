package com.coreframework.client.gui;

import java.util.List;
import java.util.ArrayList;

/**
 * The base class for all nodes that have children.
 */
public abstract class Parent extends Node
{
	/**
	 * Construct a Parent.
	 *
	 * @param name The name of the Parent.
	 */
	protected Parent(final String name)
	{
		super(name);
	}

	/**
	 * The list of the parent's children.
	 */
	protected final List<Node> children = new ArrayList<Node>();

	/**
	 * Get the list of the parent's children.
	 *
	 * @return The list of the parent's children.
	 */
	public final List<Node> getChildren()
	{
		return children;
	}
}
