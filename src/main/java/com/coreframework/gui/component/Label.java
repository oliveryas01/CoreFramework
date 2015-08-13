package com.coreframework.gui.component;

import net.minecraft.client.gui.FontRenderer;

import net.minecraft.client.renderer.GlStateManager;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;

import com.coreframework.gui.color.Color;

/**
 * A label component object.
 * Renders text on the screen.
 *
 * A label is meant to be a child of
 *    another component. The parent should
 *    set the x, y, width, and height
 *    fields.
 */
@SideOnly(Side.CLIENT)
public final class Label extends Component
{
	/**
	 * Constructs a Label.
	 *
	 * @param name The name of the component.
	 * @param text The label's text.
	 */
	public Label(final String name, final String text)
	{
		super(name);

		if(text == null) throw new IllegalArgumentException("The text cannot be null.");

		setText(text);
	}

	/**
	 * Constructs a Label.
	 *
	 * The label's name will be equal to its text.
	 *
	 * @param text The label's text.
	 */
	public Label(final String text)
	{
		this(text, text);
	}

	/**
	 * Initialize the label.
	 */
	@Override
	public void initialize()
	{
		color = Color.white;

		fontRenderer = mc.fontRendererObj;
	}

	/**
	 * Render the label.
	 */
	@Override
	public void render()
	{
		if(visible)
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.enableBlend();
				GlStateManager.tryBlendFuncSeparate(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, 1, 0);

				if(shadow)
				{
					fontRenderer.drawStringWithShadow(text, (float)xRelative(), (float)yRelative(), color.getRGB());
				} else {
					fontRenderer.drawString(text, xRelative(), yRelative(), color.getRGB());
				}
			}
			GlStateManager.popMatrix();
		}
	}

	/**
	 * The label's text.
	 */
	private String text;

	/**
	 * The label's color.
	 */
	private Color color;

	/**
	 * Whether or not a shadow is rendered.
	 */
	private boolean shadow;

	/**
	 * The font renderer used for rendering and measuring the text.
	 */
	private FontRenderer fontRenderer;

	/**
	 * Get the label's text.
	 *
	 * @return The label's text.
	 */
	public String getText()
	{
		return text;
	}

	/**
	 * Set the label's text.
	 *
	 * @param text The label's text.
	 */
	public void setText(final String text)
	{
		this.text = text;
	}

	/**
	 * Get the label's color.
	 *
	 * @return The label's color.
	 */
	public Color getColor()
	{
		return color;
	}

	/**
	 * Set the label's color.
	 *
	 * @param color The label's color.
	 */
	public void setColor(final Color color)
	{
		this.color = color;
	}

	/**
	 * Get whether or not a shadow is rendered.
	 *
	 * @return Whether or not a shadow is rendered.
	 */
	public boolean isShadow()
	{
		return shadow;
	}

	/**
	 * Set whether or not a shadow is rendered.
	 *
	 * @param shadow Whether or not a shadow is rendered.
	 */
	public void setShadow(final boolean shadow)
	{
		this.shadow = shadow;
	}
}
