package com.coreframework.client.gui.css.property;

import org.w3c.css.sac.CSSException;

import org.w3c.dom.css.CSSPrimitiveValue;

/**
 * A CSS property.
 */
public abstract class Property
{
	/**
	 * Default constructor.
	 */
    public Property() {}

	/**
	 * The list of properties to parse.
	 *
	 * @return The list of properties to parse.
	 */
	protected abstract String[] properties();

	/**
	 * The list of value types to parse.
	 */
	protected abstract Object[] values();

	/**
	 * Parse the declaration.
	 *
	 * @param declaration The declaration.
	 * @return An array of the parsed values.
	 */
	public Object[] parse(final com.steadystate.css.dom.Property declaration)
	{
		boolean validProperty = false;

		for(final String property : properties())
		{
			if(declaration.getName().equals(property))
			{
				validProperty = true;

				break;
			}
		}

		if(!validProperty) throw new IllegalArgumentException("The declaration's property is not a valid for this parser.");

		final CSSPrimitiveValue value = (CSSPrimitiveValue)declaration.getValue();

		if(value.getPrimitiveType() == CSSPrimitiveValue.CSS_UNKNOWN)
		{
			throw new CSSException("Cannot parse unknown type.");
		}

		if(value.getPrimitiveType() == CSSPrimitiveValue.CSS_IDENT && value.getStringValue().equals("initial"))
		{
			throw new CSSException("Cannot parse initial.");
		}

		return null;
	}

	/**
	 * Get the CSS properties.
	 *
	 * @return The CSS properties.
	 */
	public final String[] getProperties()
	{
		return properties();
	}
}
