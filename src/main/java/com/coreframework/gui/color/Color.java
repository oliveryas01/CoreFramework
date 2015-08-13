package com.coreframework.gui.color;

/**
 * TODO: Javadoc.
 */
public final class Color
{
	// Minecraft colors.
	public static final Color black = new Color(0, 0, 0); // §0
	public static final Color darkBlue = new Color(0, 0, 170); // §1
	public static final Color darkGreen = new Color(0, 170, 0); // §2
	public static final Color darkAqua = new Color(0, 170, 170); // §3
	public static final Color darkRed = new Color(170, 0, 0); // §4
	public static final Color darkPurple = new Color(170, 0, 170); // §5
	public static final Color gold = new Color(255, 170, 0); // §6
	public static final Color gray = new Color(170, 170, 170); // §7
	public static final Color darkGray = new Color(85, 85, 85); // §8
	public static final Color BLUE = new Color(85, 85, 255); // §9
	public static final Color GREEN = new Color(85, 255, 85); // §a
	public static final Color aqua = new Color(85, 255, 255); // §b
	public static final Color RED = new Color(255, 85, 85); // §c
	public static final Color lightPurple = new Color(255, 85, 255); // §d
	public static final Color yellow = new Color(255, 255, 85); // §e
	public static final Color white = new Color(255, 255, 255); // §f

	public Color(final int red, final int green, final int blue, final int alpha)
	{
		if(red < 0 || red > 255) throw new IllegalArgumentException("The red value is out of bounds (0-255).");
		if(green < 0 || green > 255) throw new IllegalArgumentException("The green value is out of bounds (0-255).");
		if(blue < 0 || blue > 255) throw new IllegalArgumentException("The blue value is out of bounds (0-255).");
		if(alpha < 0 || alpha > 255) throw new IllegalArgumentException("The alpha value is out of bounds (0-255).");

		this.red = red;
		this.green = green;
		this.blue = blue;
		this.alpha = alpha;
	}

	public Color(final int red, final int green, final int blue)
	{
		this(red, green, blue, 255);
	}

	private int red;

	private int green;

	private int blue;

	private int alpha;

	public int getRGB()
	{
		return
				((alpha & 0xff) << 24) |
				((red & 0xff) << 16) |
				((green & 0xff) << 8) |
				((blue & 0xff) << 0);
	}

	public void setColor(final java.awt.Color color)
	{
		red = color.getRed();
		green = color.getGreen();
		blue = color.getBlue();
		alpha = color.getAlpha();
	}

	public void setColor(final org.lwjgl.util.Color color)
	{
		red = color.getRed();
		green = color.getGreen();
		blue = color.getBlue();
		alpha = color.getAlpha();
	}

	public int getRed()
	{
		return red;
	}

	public void setRed(int red)
	{
		this.red = red;
	}

	public int getGreen()
	{
		return green;
	}

	public void setGreen(int green)
	{
		this.green = green;
	}

	public int getBlue()
	{
		return blue;
	}

	public void setBlue(int blue)
	{
		this.blue = blue;
	}

	public int getAlpha()
	{
		return alpha;
	}

	public void setAlpha(int alpha)
	{
		this.alpha = alpha;
	}
}
