package com.coreframework.client.gui.layout;

import com.coreframework.client.gui.Parent;

/**
 * The base class for all layouts and controls.
 */
public abstract class Region extends Parent
{
	/**
	 * Construct a Region.
	 *
	 * @param name The name of the Region.
	 */
	protected Region(final String name)
	{
		super(name);
	}

	/** {@inheritDoc} */
	@Override
	public String id()
	{
		return "region";
	}

	/**
	 * The X position of the region.
	 */
	protected int x;

	/**
	 * The Y position of the region.
	 */
	protected int y;

	/**
	 * The width of the region.
	 */
	protected int width;

	/**
	 * The height of the region.
	 */
	protected int height;
}
