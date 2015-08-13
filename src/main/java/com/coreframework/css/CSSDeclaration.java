package com.coreframework.css;

/**
 * A CSS declaration object.
 */
public final class CSSDeclaration
{
	/**
	 * Constructs a CSSDeclartation.
	 *
	 * @param property The declaration's property.
	 * @param value The declaration's value.
	 * @param defaultValue The fallback declaration's value if the declaration's value is invalid.
	 */
    public CSSDeclaration(final String property, final String value, final String defaultValue)
    {
		this.property = property;
		this.value = value;
		this.defaultValue = defaultValue;
    }

	/**
	 * The declaration's property.
	 */
	private final String property;

	/**
	 * The declaration's value.
	 */
	private final String value;

	/**
	 * The fallback declaration's value if the declaration's value is invalid.
	 */
	private final String defaultValue;
}
