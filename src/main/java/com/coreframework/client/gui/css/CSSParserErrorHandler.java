package com.coreframework.client.gui.css;

import org.w3c.css.sac.ErrorHandler;
import org.w3c.css.sac.CSSException;
import org.w3c.css.sac.CSSParseException;

import com.coreframework.common.CoreFramework;

/**
 * Handles errors when parsing a stylesheet.
 */
public final class CSSParserErrorHandler implements ErrorHandler
{
	/**
	 * Default constructor.
	 */
	public CSSParserErrorHandler() {}

	/**
	 * Handle parser warnings.
	 *
	 * @param exception The caught exception.
	 * @throws CSSException
	 */
	@Override
	public void warning(final CSSParseException exception) throws CSSException
	{
		CoreFramework.println(exception.getMessage(), CoreFramework.Level.WARNING);
	}

	/**
	 * Handle parser errors.
	 *
	 * @param exception The caught exception.
	 * @throws CSSException
	 */
	@Override
	public void error(final CSSParseException exception) throws CSSException
	{
		CoreFramework.println(exception.getMessage(), CoreFramework.Level.ERROR);
	}

	/**
	 * Handle parser fatal errors.
	 *
	 * @param exception The caught exception.
	 * @throws CSSException
	 */
	@Override
	public void fatalError(final CSSParseException exception) throws CSSException
	{
		CoreFramework.println(exception.getMessage(), CoreFramework.Level.ERROR);
	}
}
