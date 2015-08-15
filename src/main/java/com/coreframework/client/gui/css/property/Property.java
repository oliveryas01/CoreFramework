package com.coreframework.client.gui.css.property;

import org.w3c.css.sac.CSSException;

import org.w3c.dom.css.CSSPrimitiveValue;

import java.util.ArrayList;
import java.util.List;

/**
 * A CSS property.
 */
public abstract class Property
{
	/**
	 * Default constructor.
	 */
    public Property()
	{
		values = new ArrayList<Object>();
	}

	/**
	 * The list of parsed values.
	 */
	protected final List<Object> values;

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
	 */
	public void parse(final com.steadystate.css.dom.Property declaration)
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

		values.clear();
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

	/**
	 * Get the list of parsed values.
	 *
	 * @return The list of parsed values.
	 */
	public final List<Object> getValues()
	{
		return values;
	}
}
