package com.coreframework.client.gui.css.property;

import org.w3c.css.sac.CSSException;

/**
 * A CSS "background" object.
 */
public final class Background extends Property
{
	/** {@inheritDoc} */
	@Override
	protected String[] properties() { return new String[] {"background", "background-color"}; }

	/** {@inheritDoc} */
	@Override
	protected Object[] values()
	{
		return new Object[] {com.coreframework.client.gui.color.Color.class};
	}

	/** {@inheritDoc} */
	@Override
	public Object[] parse(final com.steadystate.css.dom.Property declaration)
	{
		super.parse(declaration);

		final Object[] values = new Object[values().length];

		// TODO: Parse.

		for(int i = 0; i < values.length; i++)
		{
			try
			{
				if(!(values[i].getClass().equals(values()[i]))) throw new CSSException("Incorrect value type.");
			} catch(NullPointerException e) {
				e = new NullPointerException("Value cannot be null.");

				e.printStackTrace();
			}
		}

		return values;
	}
}