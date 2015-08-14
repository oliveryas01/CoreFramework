package com.coreframework.gui.component;

import com.coreframework.gui.event.Event;
import net.minecraft.client.gui.FontRenderer;

import net.minecraft.client.renderer.GlStateManager;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;

import com.coreframework.gui.color.Color;

import java.io.InputStream;

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
public final class Label extends StyledComponent
{
	/**
	 * Constructs a Label with a specific style.
	 *
	 * @param name The name of the component.
	 * @param text The label's text.
	 */
	public Label(final String name, final String text, final InputStream css)
	{
		super(name, css);

		if(text == null) throw new IllegalArgumentException("The text cannot be null.");

		setText(text);
	}

	/**
	 * Constructs a Label with a specific style.
	 *
	 * @param name The name of the component.
	 * @param text The label's text.
	 */
	public Label(final String name, final String text)
	{
		this(name, text, null);
	}

	/**
	 * Constructs a Label with a specific style.
	 *
	 * The label's name will be equal to its text.
	 *
	 * @param text The label's text.
	 */
	public Label(final String text, final InputStream css)
	{
		this(text, text, css);
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
		this(text, text, null);
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
			//GlStateManager.pushMatrix();
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
			//GlStateManager.popMatrix();
		}
	}

	/**
	 * The label's text.
	 */
	private String text;

	/**
	 * The font renderer used for rendering and measuring the text.
	 */
	private FontRenderer fontRenderer;

	@Event
	protected void onTextChanged(final String oldText, final String newText) {};

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
		final String oldText = this.text;

		this.text = text;

		onTextChanged(oldText, text);
	}
}
