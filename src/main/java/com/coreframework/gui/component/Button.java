package com.coreframework.gui.component;

import java.io.InputStream;

import net.minecraft.client.renderer.GlStateManager;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;

/**
 * A button component object.
 *
 * TODO: Javadoc.
 */
@SideOnly(Side.CLIENT)
public final class Button extends StyledComponent
{
	public Button(final String name, final Label label, final int x, final int y, final int width, final int height, final InputStream css)
	{
		super(name, x, y, width, height, css);

		if(label == null) throw new IllegalArgumentException("The label cannot be null.");

		this.label = label;

		autoSize = (width == -1 || height == -1);
	}

	public Button(final String name, final Label label, final int x, final int y, final InputStream css)
	{
		this(name, label, x, y, -1, -1, css);
	}

	public Button(final String name, final Label label, final int x, final int y, final int width, final int height)
	{
		this(name, label, x, y, width, height, null);
	}

	public Button(final String name, final Label label, final int x, final int y)
	{
		this(name, label, x, y, -1, -1, null);
	}

	public Button(final Label label, final int x, final int y, final int width, final int height)
	{
		this(label.getText(), label, x, y, width, height, null); // TODO: Could cause exception.
	}

	public Button(final Label label, final int x, final int y)
	{
		this(label.getText(), label, x, y, -1, -1, null); // TODO: Could cause exception.
	}

	@Override
	public void initialize()
	{
		label.initialize();
		label.setParent(this);
	}

	@Override
	public void render(final int mouseX, final int mouseY)
	{
		if(visible)
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.enableBlend();
				GlStateManager.tryBlendFuncSeparate(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, 1, 0);
				GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

				if(autoSize)
				{
					final int labelWidth = label.getFontRenderer().getStringWidth(label.getText());
					final int labelHeight = label.getFontRenderer().FONT_HEIGHT;

					drawRect(xRelative(), yRelative(), xRelative() + labelWidth, yRelative() + labelHeight, java.awt.Color.white.getRGB());
					drawRect(xRelative() + 1, yRelative() + 1, xRelative() + labelWidth - 1, yRelative() + labelHeight - 1, java.awt.Color.black.getRGB());
				} else
				{
					drawRect(xRelative(), yRelative(), xRelative() + width, yRelative() + height, java.awt.Color.white.getRGB());
					drawRect(xRelative() + 1, yRelative() + 1, xRelative() + width - 1, yRelative() + height - 1, java.awt.Color.black.getRGB());
				}

				label.render(mouseX, mouseY);
			}
			GlStateManager.popMatrix();
		}
	}

	private final Label label;

	private final boolean autoSize;

	public void setText(final String text)
	{
		label.setText(text);
	}

	public Label getLabel()
	{
		return label;
	}
}
