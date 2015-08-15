package com.coreframework.client.gui.css;

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

import com.steadystate.css.dom.Property;
import com.steadystate.css.dom.CSSValueImpl;

import com.coreframework.common.CoreFramework;

/**
 * A class that parses a CSS file.
 */
public final class CSSParser implements DocumentHandlerExt
{
	/**
	 * StringBuilder for debug messages.
	 */
	private final StringBuilder debug = new StringBuilder();

	/**
	 * Main.
	 *
	 * @param args Program arguments.
	 * @throws Exception
	 *
	 * @deprecated Was only for testing, will remove.
	 */
	@Deprecated
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
	 * @throws java.io.IOException
	 */
	public CSSParser() throws IllegalAccessException, InstantiationException, ClassNotFoundException, IOException
	{
		System.setProperty("org.w3c.css.sac.parser", "com.steadystate.css.parser.SACParserCSS3");

		final InputStream stream = CoreFramework.class.getClassLoader().getResourceAsStream("css/Gravel.css");
		final String content = new Scanner(stream).useDelimiter("\\Z").next();

		final InputSource source = new InputSource(new StringReader(content));
		final Parser parser = new ParserFactory().makeParser();

		parser.setErrorHandler(new CSSParserErrorHandler());
		parser.setDocumentHandler(this);

		parser.parseStyleSheet(source);

		stream.close();

		debug.append("CSS Parser ->").append("\n");

		final Selector[] selectors = rules.keySet().toArray(new Selector[rules.size()]);
		for(int i = 0; i < selectors.length; i++)
		{
			final Selector selector = selectors[i];

			debug.append(selector);

			for(final Property declaration : rules.get(selector))
			{
				debug.append("\n").append("\t").append(declaration.getName()).append("=").append(declaration.getValue());
			}

			debug.append("\n");
		}

		CoreFramework.println(debug.toString(), CoreFramework.Level.DEBUG);

		// TODO: Remove code below this comment because it is test code.

		final com.coreframework.client.gui.css.property.Color color = new com.coreframework.client.gui.css.property.Color();
		color.parse(getDeclaration("#label", "color"));
		if((Boolean)color.getValues().get(1))
		{
			System.out.println("transparent");
		} else {
			final com.coreframework.client.gui.color.Color color0 = (com.coreframework.client.gui.color.Color)color.getValues().get(0);
			System.out.println("Red: " + color0.getRed() + ", Green: " + color0.getGreen() + ", Blue: " + color0.getBlue());
		}

		final com.coreframework.client.gui.css.property.Opacity opacity = new com.coreframework.client.gui.css.property.Opacity();
		opacity.parse(getDeclaration("#label", "opacity"));
		System.out.println("Opacity: " + opacity.getValues().get(0));

		final com.coreframework.client.gui.css.property.Background backgroundColor = new com.coreframework.client.gui.css.property.Background();
		backgroundColor.parse(getDeclaration("#label", "background-color"));
		if((Boolean)backgroundColor.getValues().get(1))
		{
			System.out.println("transparent");
		} else {
			final com.coreframework.client.gui.color.Color backgroundColor0 = (com.coreframework.client.gui.color.Color)backgroundColor.getValues().get(0);
			System.out.println("Red: " + backgroundColor0.getRed() + ", Green: " + backgroundColor0.getGreen() + ", Blue: " + backgroundColor0.getBlue());
		}
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

		for(final Selector selector : currentSelectors)
		{
			rules.put(selector, new ArrayList<Property>());
		}
	}

	@Override
	public void property(final String name, final LexicalUnit value, final boolean important, final Locator locator)
	{
		final Property currentDeclaration = new Property(name, new CSSValueImpl(value, true), important);

		for(final Selector selector : currentSelectors)
		{
			for(final Property property : rules.get(selector))
			{
				if(currentDeclaration.getName().equals(property.getName())) throw new CSSParseException("Rule contains multiple of the same property.", locator);
			}

			rules.get(selector).add(currentDeclaration);
		}
	}

	/**
	 * The map for all the rules and their declarations.
	 */
	private static final Map<Selector, List<Property>> rules = new HashMap<Selector, List<Property>>();

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

	/**
	 * Get a declaration by it's parent selector and the property of the declaration.
	 *
	 * @param selector Parent selector.
	 * @param declarationProperty Declaration property.
	 * @return The declaration.
	 */
	public Property getDeclaration(final String selector, final String declarationProperty)
	{
		// TODO: Either simplify this method or split into two separate methods.

		List<Property> declarations = null;

		for(final Selector selector0 : rules.keySet())
		{
			if(selector0.toString().substring(1).equals(selector))
			{
				declarations = rules.get(selector0);

				break;
			}
		}

		if(declarations == null) throw new NullPointerException("That selector does not exist.");

		Property declaration = null;

		for(final Property declaration0 : declarations)
		{
			if(declaration0.getName().equals(declarationProperty))
			{
				declaration = declaration0;

				break;
			}
		}

		if(declaration == null) throw new NullPointerException("That declaration does not exist.");

		return declaration;
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
