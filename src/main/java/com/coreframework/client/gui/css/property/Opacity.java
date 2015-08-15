package com.coreframework.client.gui.css.property;

import org.w3c.css.sac.CSSException;

import com.steadystate.css.dom.CSSValueImpl;
import org.w3c.dom.css.CSSPrimitiveValue;

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

		final CSSValueImpl value = (CSSValueImpl)declaration.getValue();

		if(value.getPrimitiveType() != CSSPrimitiveValue.CSS_NUMBER) throw new CSSException("Opacity must be a float value.");

		final float parsedValue = value.getFloatValue(CSSPrimitiveValue.CSS_NUMBER);

		if(parsedValue < 0 || parsedValue > 1) throw new CSSException("Opacity must be between 0-1 inclusive.");

		values[0] = value.getFloatValue(CSSPrimitiveValue.CSS_NUMBER);

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
