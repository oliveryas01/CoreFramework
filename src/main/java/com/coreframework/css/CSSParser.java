package com.coreframework.css;

import java.io.InputStream;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

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
		final String[] lines = new Scanner(file).useDelimiter("\\Z").next().replaceAll(";", "").split("\n");

		for(int i = 0; i < lines.length; i++)
		{
			lines[i] = lines[i].replaceAll("\\s+", "");
		}

		CSSSelector selector = null;

		for(int i = 0; i < lines.length; i++)
		{
			final String line = lines[i];

			if(CoreFramework.debugMode)
			{
				System.out.println("Parsing line #" + i + ":");
				System.out.println("\tContent=" + line);
				System.out.print("\tType=");
			}

			if(line.startsWith(".") && line.endsWith("{"))
			{
				if(CoreFramework.debugMode)
				{
					System.out.println("Start Selector");
				}

				final String selectorLine = line.substring(1, line.length() - 1);
				final String selectorLineWithPseudoClass[] = selectorLine.split(":");

				switch(selectorLineWithPseudoClass.length)
				{
					case 1:
						selector = new CSSSelector(selectorLine);
						break;
					case 2:
						selector = new CSSSelector(selectorLine, selectorLineWithPseudoClass[1]);
				}
			} else if(line.equals("}")) {
				if(CoreFramework.debugMode)
				{
					System.out.println("End Selector");
				}

				selector = null;
			} else

			if(selector != null && !line.equals(""))
			{
				if(CoreFramework.debugMode)
				{
					System.out.println("Declaration");
					System.out.println("\tDeclaration:");
				}

				final String[] declaration = line.split(":");

				if(CoreFramework.debugMode)
				{
					System.out.println("\t\tProperty=" + declaration[0]);
					System.out.println("\t\tValue=" + declaration[1]);
				}

				// TODO: if(isValidProperty(declaration[0]))
				//{
				selector.addDeclaration(new CSSDeclaration(declaration[0], declaration[1], ""/* TODO: getDefaultValueForProperty(declaration[0]) */));
				//}
			}
		}
	}
}
