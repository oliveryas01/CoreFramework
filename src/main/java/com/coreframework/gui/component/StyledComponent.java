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
	 * The component's font color.
	 */
	protected Color color = Color.black;

	/**
	 * The component's background color.
	 */
	protected Color backgroundColor = Color.transparent;

	/**
	 * The component's border properties.
	 */
	//protected Border border;

	/**
	 * The component's padding properties.
	 */
	//protected Padding padding;

	/**
	 * The component content's horizontal alignment.
	 */
	//protected HorizontalAlignment horizontalAlignment; // text-align.

	/**
	 * The component content's vertical alignment.
	 */
	//protected VerticalAlignment verticalAlignment; // vertical-align.

	/**
	 * The component's letter spacing.
	 */
	//protected LetterSpacing letterSpacing;

	/**
	 * The component's line height.
	 */
	protected int lineHeight = mc.fontRendererObj.FONT_HEIGHT;

	/**
	 * The component's tab side.
	 */
	protected int tabSize = 4;

	//protected TextDecoration textDecoration;

	/**
	 * Whether or not a shadow is rendered.
	 */
	protected boolean shadow;

	protected boolean readFromLeft = true;

	protected boolean canResize = true;

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
}
