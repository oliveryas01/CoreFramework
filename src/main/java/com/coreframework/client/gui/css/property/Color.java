package com.coreframework.client.gui.css.property;

import org.w3c.css.sac.CSSException;

import org.w3c.dom.css.CSSPrimitiveValue;
import org.w3c.dom.css.RGBColor;

import com.steadystate.css.dom.CSSValueImpl;

import java.util.List;

/**
 * A CSS "color" object.
 */
public final class Color extends Property
{
	/** {@inheritDoc} */
	@Override
	protected String[] properties() { return new String[] {"color"}; }

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

		final CSSValueImpl value = (CSSValueImpl)declaration.getValue();

		if(value.getPrimitiveType() != CSSPrimitiveValue.CSS_RGBCOLOR) throw new CSSException("Colors must be in the rgb format.");

		final RGBColor color = value.getRGBColorValue();

		if(color.getRed().getPrimitiveType() != CSSPrimitiveValue.CSS_NUMBER ||
				color.getGreen().getPrimitiveType() != CSSPrimitiveValue.CSS_NUMBER ||
				color.getBlue().getPrimitiveType() != CSSPrimitiveValue.CSS_NUMBER)
		{
			throw new CSSException("RGB values must be numbers.");
		}

		final int red = (int)color.getRed().getFloatValue(CSSPrimitiveValue.CSS_NUMBER);
		final int green = (int)color.getGreen().getFloatValue(CSSPrimitiveValue.CSS_NUMBER);
		final int blue = (int)color.getBlue().getFloatValue(CSSPrimitiveValue.CSS_NUMBER);

		values[0] = new com.coreframework.client.gui.color.Color(red, green, blue);

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
