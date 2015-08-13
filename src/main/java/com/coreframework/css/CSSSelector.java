package com.coreframework.css;

import java.util.List;
import java.util.ArrayList;

/**
 * A CSS selector object.
 */
public final class CSSSelector
{
	/**
	 * Constructs a CSSSelector with a pseudo-class.
	 *
	 * @param element The selector's element.
	 * @param pseudoClass The selector's pseudo-class, if any.
	 */
	public CSSSelector(final String element, final String pseudoClass)
	{
		this.element = element;
		this.pseudoClass = pseudoClass;

		declarations = new ArrayList<CSSDeclaration>();
	}

	/**
	 * Constructs a CSS selector without a pseudo-class.
	 *
	 * @param element The selector's element.
	 */
    public CSSSelector(final String element)
    {
		this(element, null);
    }

	/**
	 * The selector's element.
	 */
	private final String element;

	/**
	 * The selector's pseudo-class, if any.
	 */
	private final String pseudoClass;

	/**
	 * A list of all the declarations the selector contains.
	 */
	private final List<CSSDeclaration> declarations;
}
