package com.coreframework.css;

import java.io.InputStream;
import java.io.StringReader;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

import org.w3c.css.sac.*;

import org.w3c.css.sac.helpers.ParserFactory;

import com.steadystate.css.sac.DocumentHandlerExt;

import com.steadystate.css.parser.LexicalUnitImpl;

import com.coreframework.CoreFramework;

/**
 * A class that parses a CSS file.
 */
public final class CSSParser implements DocumentHandlerExt
{
	public static void main(final String[] args) throws Exception
	{
		new CSSParser();
	}

	/**
	 * Default constructor.
	 *
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public CSSParser() throws IllegalAccessException, InstantiationException, ClassNotFoundException, IOException
	{
		System.setProperty("org.w3c.css.sac.parser", "com.steadystate.css.parser.SACParserCSS3");

		rules = new HashMap<Selector[], List<CSSDeclaration>>();

		final InputStream stream = CoreFramework.class.getClassLoader().getResourceAsStream("css/Gravel.css");
		final String content = new Scanner(stream).useDelimiter("\\Z").next();

		final InputSource source = new InputSource(new StringReader(content));
		final Parser parser = new ParserFactory().makeParser();

		parser.setErrorHandler(new CSSParserErrorHandler());
		parser.setDocumentHandler(this);

		parser.parseStyleSheet(source);

		CoreFramework.println("->\n" + debug.toString(), CoreFramework.Level.DEBUG);

		stream.close();
	}

	@Override
	public void charset(final String characterEncoding, final Locator locator) throws CSSException
	{
		throw new CSSParseException("Cannot parse @charset.", locator);
	}

	@Override
	public void importStyle(final String uri, final SACMediaList media, final String defaultNamespaceURI, final Locator locator) throws CSSException
	{
		throw new CSSParseException("Cannot parse @import.", locator);
	}

	@Override
	public void ignorableAtRule(final String atRule, final Locator locator) throws CSSException
	{
	}

	@Override
	public void startFontFace(final Locator locator) throws CSSException
	{
		throw new CSSParseException("Cannot parse @font-face.", locator);
	}

	@Override
	public void startPage(final String name, final String pseudoPage, final Locator locator) throws CSSException
	{
		throw new CSSParseException("Cannot parse @page.", locator);
	}

	@Override
	public void startMedia(final SACMediaList media, final Locator locator) throws CSSException
	{
		throw new CSSParseException("Cannot parse @media.", locator);
	}

	@Override
	public void startSelector(final SelectorList selectorList, final Locator locator) throws CSSException
	{
		currentSelectors = selectorListToArray(selectorList);

		rules.put(currentSelectors, new ArrayList<CSSDeclaration>());

		String selectors = java.util.Arrays.toString(currentSelectors);
		selectors = selectors.substring(1, selectors.indexOf("]"));

		debug.append(selectors).append("\n");
	}

	@Override
	public void property(final String name, final LexicalUnit value, final boolean important, final Locator locator)
	{
		final CSSDeclaration declaration = new CSSDeclaration(name, value);

		if(!rules.get(currentSelectors).add(declaration)) throw new CSSParseException("Rule contains a multiple of the same property.", locator);

		debug.append("\t").append(name).append("=");

		LexicalUnitImpl lexicalUnit = (LexicalUnitImpl)value;
		while(true)
		{
			debug.append(lexicalUnit.toString());

			lexicalUnit = (LexicalUnitImpl)lexicalUnit.getNextLexicalUnit();

			if(lexicalUnit == null)
			{
				break;
			}

			debug.append(" ");
		}

		debug.append("\n");
	}

	/**
	 * StringBuilder for debug messages.
	 */
	private final StringBuilder debug = new StringBuilder();

	/**
	 * The map for all the rules and their declarations.
	 */
	private final Map<Selector[], List<CSSDeclaration>> rules;

	/**
	 * The current selectors being parsed.
	 * Also the key for the selectors map.
	 */
	private Selector[] currentSelectors;

	/**
	 * Converts a selectorList to a List of Selectors.
	 *
	 * @param selectorList The SelectorList to convert.
	 * @return The List of Selectors.
	 */
	private Selector[] selectorListToArray(final SelectorList selectorList)
	{
		final Selector[] selectors = new Selector[selectorList.getLength()];

		for(int i = 0; i < selectorList.getLength(); i++)
		{
			selectors[i] = selectorList.item(i);
		}

		return selectors;
	}

	// DO NOT TOUCH ANYTHING BELOW THIS LINE!!!

	@Override
	public void startDocument(final InputSource source) throws CSSException {}

	@Override
	public void endDocument(final InputSource source) throws CSSException {}

	@Override
	public void comment(final String text) throws CSSException {}

	@Override
	public void ignorableAtRule(final String atRule) throws CSSException {}

	@Override
	public void namespaceDeclaration(final String prefix, final String uri) throws CSSException {}

	@Override
	public void importStyle(final String uri, final SACMediaList media, final String defaultNamespaceURI) throws CSSException {}

	@Override
	public void startMedia(final SACMediaList media) throws CSSException {}

	@Override
	public void endMedia(final SACMediaList media) throws CSSException {}

	@Override
	public void startPage(final String name, final String pseudo_page) throws CSSException {}

	@Override
	public void endPage(final String name, final String pseudo_page) throws CSSException {}

	@Override
	public void startFontFace() throws CSSException {}

	@Override
	public void endFontFace() throws CSSException {}

	@Override
	public void startSelector(final SelectorList selectors) throws CSSException {}

	@Override
	public void endSelector(final SelectorList selectors) throws CSSException {}

	@Override
	public void property(final String name, final LexicalUnit value, final boolean important) throws CSSException {}
}
