package com.coreframework.client.gui.css.property;

import org.w3c.css.sac.CSSException;

import com.coreframework.client.gui.color.Color;

/**
 * A CSS "border" object.
 */
public final class Border extends Property
{
	/** {@inheritDoc} */
	@Override
	protected String[] properties()
	{
		return new String[] {
			"border", "border-width", "border-style", "border-width",
			"border-top", "border-top-width", "border-top-style", "border-top-width",
			"border-bottom", "border-bottom-width", "border-bottom-style", "border-bottom-width",
			"border-left", "border-left-width", "border-left-style", "border-left-width",
			"border-right", "border-right-width", "border-right-style", "border-right-width"
		};
	}

	/** {@inheritDoc} */
	@Override
	protected Object[] values()
	{
		return new Object[] {
				// border-top
				/* 0 */ Float.class,
				/* 1 */ STYLE.class,
				/* 2 */ Color.class,

				// border-bottom
				/* 3 */ Float.class,
				/* 4 */ STYLE.class,
				/* 5 */ Color.class,

				// border-left
				/* 6 */ Float.class,
				/* 7 */ STYLE.class,
				/* 8 */ Color.class,

				// border-right
				/* 9 */ Float.class,
				/* 10 */ STYLE.class,
				/* 11 */ Color.class
		};
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

	public enum STYLE
	{
		none,
		hidden,
		dotted,
		dashed,
		solid,
		double0,
		groove,
		ridge,
		inset,
		outset
	}
}
