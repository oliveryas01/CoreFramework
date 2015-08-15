package com.coreframework.client.gui.layout;

/**
 * Base class for layout panes.
 */
public abstract class Pane extends Region
{
	/**
	 * Constructs a Pane.
	 *
	 * @param name The name of the Pane.
	 */
	protected Pane(final String name)
	{
		super(name);
	}

	/** {@inheritDoc} */
	@Override
	public String id()
	{
		return "pane";
	}
}
