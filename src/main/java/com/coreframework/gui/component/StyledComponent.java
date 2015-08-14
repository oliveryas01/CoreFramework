package com.coreframework.gui.component;

import java.io.InputStream;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.coreframework.gui.color.Color;

import com.coreframework.gui.event.Event;

/**
 * A component that is styled with CSS.
 */
@SideOnly(Side.CLIENT)
public abstract class StyledComponent extends Component
{
	public StyledComponent(final String name, final int x, final int y, final int width, final int height, final InputStream css)
	{
		super(name, x, y, width, height);
	}

	public StyledComponent(final String name, final InputStream css)
	{
		this(name, 0, 0, 0, 0, css);
	}

	@Event
	protected void onShown() {}

	@Event
	protected void onHidden() {}

	/**
	 * The visibility of the component.
	 */
	protected boolean visible = true;

	/**
	 * The component's color.
	 */
	protected Color color;

	/**
	 * Whether or not a shadow is rendered.
	 */
	protected boolean shadow;

	/**
	 * Get the visibility of the component.
	 *
	 * @return The visibility of the component.
	 */
	public final boolean isVisible()
	{
		return visible;
	}

	/**
	 * Set the visibility of the component.
	 *
	 * @param visible The visibility of the component.
	 */
	public final void setVisible(final boolean visible)
	{
		final boolean oldVisible = this.visible;

		this.visible = visible;

		if(visible != oldVisible)
		{
			if(visible)
			{
				onShown();
			} else {
				onHidden();
			}
		}
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
