package com.coreframework.gui.component;

import java.util.List;
import java.util.ArrayList;

import net.minecraft.client.Minecraft;

import net.minecraft.client.gui.Gui;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.coreframework.gui.panel.Panel;

/**
 * The root class that all graphical objects are derived.
 */
@SideOnly(Side.CLIENT)
public abstract class Component extends Gui
{
	/**
	 * Constructs a Component.
	 *
	 * @param name The name of the component.
	 * @param x The X position of the component.
	 * @param y The Y position of the component.
	 * @param width The width of the component.
	 * @param height The height of the component.
	 */
	public Component(final String name, final int x, final int y, final int width, final int height)
	{
		for(final Component component : components)
		{
			if(component.getName().equals(name))
			{
				throw new IllegalArgumentException("A component named \"" + name + "\" already exists.");
			}
		}

		setName(name);
		setX(x);
		setY(y);
		setWidth(width);
		setHeight(height);
	}

	/**
	 * Constructs a Component.
	 *
	 * @param name The name of the component.
	 */
	public Component(final String name)
	{
		this(name, 0, 0, 0, 0);
	}

	/**
	 * Reference to the Minecraft class.
	 */
	protected Minecraft mc = Minecraft.getMinecraft();

	/**
	 * The component's parent.
	 */
	protected Object parent;

	/**
	 * The name of the component.
	 *
	 * Every component must have a unique name. This name is case sensitive.
	 */
	protected String name;

	/**
	 * The X position of the component.
	 */
	protected int x;

	/**
	 * The Y position of the component.
	 */
	protected int y;

	/**
	 * The width of the component.
	 */
	protected int width;

	/**
	 * The height of the component.
	 */
	protected int height;

	/**
	 * Whether or not the component is enabled.
	 *
	 * When a component is disabled it's events are disabled and no updates can be made to the it.
	 */
	protected boolean enabled = true;

	/**
	 * The visibility of the component.
	 */
	protected boolean visible = true;

	/**
	 * A list of all the component names used.
	 */
	private static final List<Component> components = new ArrayList<Component>();

	/**
	 * The initialization method.
	 *
	 * This is where a component is initialized.
	 */
	public void initialize() {};

	/**
	 * The update method.
	 *
	 * This is where a component is updated.
	 * Called every tick.
	 */
	public void update() {};

	/**
	 * The render method.
	 *
	 * This is where a component is rendered.
	 * Put all OpenGL and other drawing code in here.
	 */
	public abstract void render();

	/**
	 * Calculate the X position relative to its parent's X position.
	 *
	 * @return X position relative to its parent's X position.
	 */
	protected int xRelative()
	{
		if(parent instanceof Component)
		{
			return ((Component)parent).x + x;
		} else if(parent instanceof Panel) {
			return ((Panel)parent).getX() + x;
		} else {
			// TODO: Handle this.
		}

		return 0;
	}

	/**
	 * Calculate the Y position relative to its parent's Y position.
	 *
	 * @return Y position relative to its parent's Y position.
	 */
	protected int yRelative()
	{
		if(parent instanceof Component)
		{
			return ((Component)parent).y + y;
		} else if(parent instanceof Panel) {
			return ((Panel)parent).getY() + y;
		} else {
			// TODO: Handle this.
		}

		return 0;
	}

	/**
	 * Get a Component object by its name field.
	 *
	 * @param name The name of the component.
	 * @return The Component object.
	 */
	public static Component getByName(final String name)
	{
		Component component = null;

		for(final Component component0 : components)
		{
			if(component0.getName().equals(name))
			{
				component = component0;

				break;
			}
		}

		if(component == null) throw new IllegalArgumentException("Panel does not contain that component.");

		return component;
	}

	/**
	 * Get the component's parent.
	 *
	 * @return The component's parent.
	 */
	public Object getParent()
	{
		return parent;
	}

	/**
	 * Set the component's parent.
	 *
	 * @param parent The component's parent.
	 */
	public void setParent(final Object parent)
	{
		this.parent = parent;
	}

	/**
	 * Get the name of the component.
	 *
	 * @return The name of the component.
	 */
	public final String getName()
	{
		return name;
	}

	/**
	 * Set the name of the component.
	 *
	 * @param name The name of the component.
	 */
	public final void setName(final String name)
	{
		this.name = name;
	}

	/**
	 * Get the X position of the component.
	 *
	 * @return The X position of the component.
	 */
	public final int getX()
	{
		return x;
	}

	/**
	 * Set the X position of the component.
	 *
	 * @param x The X position of the component.
	 */
	public final void setX(final int x)
	{
		this.x = x;
	}

	/**
	 * Get the Y position of the component.
	 *
	 * @return The Y position of the component.
	 */
	public final int getY()
	{
		return y;
	}

	/**
	 * Set the Y position of the component.
	 *
	 * @param y The Y position of the component.
	 */
	public final void setY(final int y)
	{
		this.y = y;
	}

	/**
	 * Get the width of the component.
	 *
	 * @return The width of the component.
	 */
	public final int getWidth()
	{
		return width;
	}

	/**
	 * Set the width of the component.
	 *
	 * @param width The width of the component.
	 */
	public final void setWidth(final int width)
	{
		this.width = width;
	}

	/**
	 * Get the height of the component.
	 *
	 * @return The height of the component.
	 */
	public final int getHeight()
	{
		return height;
	}

	/**
	 * Set the height of the component.
	 *
	 * @param height The height of the component.
	 */
	public final void setHeight(final int height)
	{
		this.height = height;
	}

	/**
	 * Get whether or not the component is enabled.
	 *
	 * @return Whether or not the component is enabled.
	 */
	public final boolean isEnabled()
	{
		return enabled;
	}

	/**
	 * Set whether or not the component is enabled.
	 *
	 * @param enabled Whether or not the component is enabled.
	 */
	public final void setEnabled(final boolean enabled)
	{
		this.enabled = enabled;
	}

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
		this.visible = visible;
	}
}
