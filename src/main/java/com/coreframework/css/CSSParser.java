package com.coreframework.css;

import java.io.InputStream;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import com.coreframework.CoreFramework;

/**
 * A class that parses a CSS file.
 *
 * TODO: Javadoc.
 */
public final class CSSParser
{
	public static void main(final String[] args)
	{
		final CSSParser parser = new CSSParser();

		parser.parse(CoreFramework.class.getClassLoader().getResourceAsStream("css/Gravel.css"));
	}

    public CSSParser()
    {
		selectors = new ArrayList<CSSSelector>();
    }

	private final List<CSSSelector> selectors;

	public void parse(final InputStream file)
	{
		final String[] lines = new Scanner(file).useDelimiter("\\Z").next().replaceAll(";", "").split("\n");

		for(int i = 0; i < lines.length; i++)
		{
			lines[i] = lines[i].replaceAll("\\s+", "");
		}

		CSSSelector selector = null;

		for(final String line : lines)
		{
			if(line.startsWith(".") && line.endsWith("{"))
			{
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
				selector = null;
			} else

			if(selector != null && !line.equals(""))
			{
				final String[] declaration = line.split(":");

				// TODO: if(isValidProperty(declaration[0]))
				//{
				selector.addDeclaration(new CSSDeclaration(declaration[0], declaration[1], ""/* TODO: getDefaultValueForProperty(declaration[0]) */));
				//}
			}
		}
	}
}
