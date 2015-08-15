package com.coreframework.client.gui.color;

/**
 * A color.
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
	public static final Color blue = new Color(85, 85, 255); // §9
	public static final Color green = new Color(85, 255, 85); // §a
	public static final Color aqua = new Color(85, 255, 255); // §b
	public static final Color red = new Color(255, 85, 85); // §c
	public static final Color lightPurple = new Color(255, 85, 255); // §d
	public static final Color yellow = new Color(255, 255, 85); // §e
	public static final Color white = new Color(255, 255, 255); // §f

	// Main colors.
	public static final Color RED = new Color(255, 0, 0);
	public static final Color GREEN = new Color(0, 255, 0);
	public static final Color BLUE = new Color(0, 0, 255);
	public static final Color YELLOW = new Color(255, 255, 0);
	public static final Color AQUA = new Color(0, 255, 255);
	public static final Color PURPLE = new Color(255, 0, 255);
	public static final Color GRAY = new Color(192, 192, 192);

	// Styling colors.
	public static final Color transparent = new Color(0, 0, 0, 0);

	/**
	 * Construct a Color.
	 *
	 * @param red The red amount (0-255).
	 * @param green The rreen amount (0-255).
	 * @param blue The blue amount (0-255).
	 * @param alpha The alpha amount (0-255).
	 */
	public Color(final int red, final int green, final int blue, final int alpha)
	{
		if(red < 0 || red > 255) throw new IllegalArgumentException("The red value is out of bounds (0-255).");
		if(green < 0 || green > 255) throw new IllegalArgumentException("The green value is out of bounds (0-255).");
		if(blue < 0 || blue > 255) throw new IllegalArgumentException("The blue value is out of bounds (0-255).");
		if(alpha < 0 || alpha > 255) throw new IllegalArgumentException("The alpha value is out of bounds (0-255).");

		r = red;
		g = green;
		b = blue;
		this.alpha = alpha;
	}

	/**
	 * Construct a Color.
	 *
	 * @param red The ted amount (0-255).
	 * @param green The green amount (0-255).
	 * @param blue The blue amount (0-255).
	 */
	public Color(final int red, final int green, final int blue)
	{
		this(red, green, blue, 255);
	}

	/**
	 * The red amount.
	 */
	private int r;

	/**
	 * The green amount.
	 */
	private int g;

	/**
	 * The blue amount.
	 */
	private int b;

	/**
	 * The alpha amount.
	 */
	private int alpha;

	/**
	 * Get the RGB value of the color.
	 *
	 * @return The RGB value of the color.
	 */
	public int getRGB()
	{
		return
				((alpha & 0xff) << 24) |
						((r & 0xff) << 16) |
						((g & 0xff) << 8) |
						((b & 0xff) << 0);
	}

	/**
	 * Set the color from an AWT color.
	 *
	 * @param color An AWT color.
	 */
	public void setColor(final java.awt.Color color)
	{
		r = color.getRed();
		g = color.getGreen();
		b = color.getBlue();
		alpha = color.getAlpha();
	}

	/**
	 * Set the color from a LWJGL color.
	 *
	 * @param color A LWJGL color.
	 */
	public void setColor(final org.lwjgl.util.Color color)
	{
		r = color.getRed();
		g = color.getGreen();
		b = color.getBlue();
		alpha = color.getAlpha();
	}

	/**
	 * Get the red amount.
	 *
	 * @return The red amount.
	 */
	public int getRed()
	{
		return r;
	}

	/**
	 * Set the red amount.
	 *
	 * @param red The red amount.
	 */
	public void setRed(int red)
	{
		this.r = red;
	}

	/**
	 * Get the green amount.
	 *
	 * @return The green amount.
	 */
	public int getGreen()
	{
		return g;
	}

	/**
	 * Set the green amount.
	 *
	 * @param green The green amount.
	 */
	public void setGreen(int green)
	{
		this.g = green;
	}

	/**
	 * Get the blue amount.
	 *
	 * @return The blue amount.
	 */
	public int getBlue()
	{
		return b;
	}

	/**
	 * Set the  amount.
	 *
	 * @param blue The blue amount.
	 */
	public void setBlue(int blue)
	{
		this.b = blue;
	}

	/**
	 * Get the alpha amount.
	 *
	 * @return The alpha amount.
	 */
	public int getAlpha()
	{
		return alpha;
	}

	/**
	 * Set the alpha amount.
	 *
	 * @param alpha  he alpha amount.
	 */
	public void setAlpha(int alpha)
	{
		this.alpha = alpha;
	}
}
