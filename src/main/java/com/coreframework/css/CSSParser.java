package com.coreframework.css;

import java.io.InputStream;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import com.coreframework.CoreFramework;

/**
 * A class that parses a CSS file.
 */
public final class CSSParser
{
	/**
	 * TODO: Remove this method.
	 *
	 * Main method for testing the parser.
	 *
	 * @param args Program arguments.
	 */
	public static void main(final String[] args)
	{
		final CSSParser parser = new CSSParser();

		parser.parse(CoreFramework.class.getClassLoader().getResourceAsStream("css/Gravel.css"));
	}
	
	public static final String[] validProperties = {
			"color",
			"background-color",
			"border",
			"border-color",
			"border-style",
			"border-width",
			"border-top-color",
			"border-top-style",
			"border-top-width",
			"border-bottom-color",
			"border-bottom-style",
			"border-bottom-width",
			"border-left-color",
			"border-left-style",
			"border-left-width",
			"border-right-color",
			"border-right-style",
			"border-right-width",
			"padding",
			"padding-top",
			"padding-bottom",
			"padding-left",
			"padding-right",
			"visibility",
			"vertical-align",
			"letter-spacing",
			"line-height",
			"tab-size",
			"text-align",
			"text-decoration",
			"text-decoration-color",
			"text-decoration-line",
			"text-decoration-style",
			"text-shadow",
			"direction",
			"resize"
	};

	/**
	 * Constructs a CSSParser.
	 */
    public CSSParser()
    {
		selectors = new ArrayList<CSSSelector>();
    }

	/**
	 * The list of selectors in the CSS file.
	 */
	private final List<CSSSelector> selectors;

	/**
	 * Parse a CSS file.
	 *
	 * @param file The stream to open the CSS file from.
	 */
	public void parse(final InputStream file)
	{
		final String fileContent = new Scanner(file).useDelimiter("\\Z").next();

		final Pattern patternSelector = Pattern.compile("[\\.](.*)[\\s]?[\\n]?[\\{]", Pattern.MULTILINE);
		final Pattern patternSelectorContent = Pattern.compile("[\\.](.*?)[\\s]?[\\n]?\\{(\\s.*?)\\}", Pattern.DOTALL);

		final Matcher matcherSelector = patternSelector.matcher(fileContent);
		final Matcher matcherSelectorContent = patternSelectorContent.matcher(fileContent);

		while(matcherSelector.find())
		{
			if(matcherSelectorContent.find())
			{
				String element = matcherSelector.group(matcherSelector.groupCount());
				String content = matcherSelectorContent.group(matcherSelectorContent.groupCount());

				element = element.replaceAll("\\s+", "");
				content = content.replaceAll("\\s\\s", "");

				final String[] elementSplit = element.split(":");
				final String pseudoClass;

				element = elementSplit[0];

				switch(elementSplit.length)
				{
					case 1:
						pseudoClass = null;
						break;
					case 2:
						pseudoClass = elementSplit[1];
						break;
					default:
						throw new CSSParserException("Error parsing CSS.");
				}

				if(CoreFramework.debugMode)
				{
					System.out.println("SELECTOR=[element=" + element + ((pseudoClass == null) ? "" : ",pseudoClass=" + pseudoClass) + "]");
				}

				final String[] declarations = content.split(";");

				for(final String declaration : declarations)
				{
					final String[] declarationSplit = declaration.split(":[\\s]?");
					final String property = declarationSplit[0];
					final String value = declarationSplit[1];

					if(CoreFramework.debugMode)
					{
						System.out.println("\tDECLARATION=[property=" + property + ",value=" + value + "]");
					}
				}
			} else {
				throw new CSSParserException("Invalid CSS file.");
			}
		}
	}

	/**
	 * Check if the read property is valid.
	 *
	 * @param property The read property.
	 * @return If the read property is valid.
	 */
	private boolean isValidProperty(final String property)
	{
		return Arrays.asList(validProperties).contains(property);
	}
}
