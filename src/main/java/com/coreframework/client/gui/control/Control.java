package com.coreframework.client.gui.control;

import com.coreframework.client.gui.layout.Region;

/**
 * Base class for all controls.
 */
public abstract class Control extends Region
{
	/**
	 * Construct a Control.
	 *
	 * @param name The name of the Control.
	 */
	protected Control(final String name)
	{
		super(name);
	}

	/** {@inheritDoc} */
	@Override
	public String id() { return "control"; }

	/** {@inheritDoc} */
	@Override
	public void initialize()
	{
	}

	/**
	 * Render the control.
	 */
	public abstract void render();
}
