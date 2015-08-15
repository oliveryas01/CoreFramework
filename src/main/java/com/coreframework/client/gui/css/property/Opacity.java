package com.coreframework.client.gui.css.property;

import org.w3c.css.sac.CSSException;

/**
 * A CSS "opacity" object.
 */
public final class Opacity extends Property
{
	/** {@inheritDoc} */
	@Override
	protected String[] properties() { return new String[] {"opacity"}; }

	/** {@inheritDoc} */
	@Override
	protected Object[] values()
	{
		return new Object[] {Float.class};
	}

	/** {@inheritDoc} */
	@Override
	public void parse(final com.steadystate.css.dom.Property declaration)
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

		for(final Object value0 : values)
		{
			this.values.add(value0);
		}
	}
}
