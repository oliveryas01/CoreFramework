package com.coreframework.css;

import org.w3c.css.sac.LexicalUnit;

/**
 * A CSS declaration object.
 */
public final class CSSDeclaration
{
	/**
	 * Construct CSSDeclaration.
	 *
	 * @param property The declaration's property.
	 * @param value The declaration's value.
	 */
    public CSSDeclaration(final String property, final LexicalUnit value)
    {
		this.property = property;
		this.value = value;
    }

	/**
	 * The declaration's property.
	 */
	private final String property;

	/**
	 * The declaration's value;
	 */
	private final LexicalUnit value;

	/**
	 * Get the declaration's property.
	 *
	 * @return The declaration's property.
	 */
	public String getProperty()
	{
		return property;
	}

	/**
	 * Get the declaration's value.
	 *
	 * @return The declaration's value.
	 */
	public LexicalUnit getValue()
	{
		return value;
	}
}
