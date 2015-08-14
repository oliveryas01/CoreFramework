package com.coreframework.gui.panel;

import java.util.List;
import java.util.ArrayList;

import net.minecraft.client.gui.GuiScreen;

import com.coreframework.gui.component.Component;

/**
 * TODO: Javadoc.
 */
public final class Panel extends GuiScreen
{
	public Panel(final int x, final int y, final int width, final int height)
	{
		setX(x);
		setY(y);
		setWidth(width);
		setHeight(height);

		this.components = new ArrayList<Component>();
	}

	@Override
	public void initGui()
	{
		for(final Component component : components)
		{
			component.initialize();
		}
	}

	@Override
	public void updateScreen()
	{
		for(final Component component : components)
		{
			component.update();
		}
	}

	@Override
	public void drawScreen(final int mouseX, final int mouseY, final float partialTicks)
	{
		for(final Component component : components)
		{
			component.render(mouseX, mouseY);
		}
	}

	private int x;
	private int y;

	private int guiWidth;
	private int guiHeight;

	private final List<Component> components;

	public void addComponent(final Component component)
	{
		if(components.contains(component))
		{
			return;
		}

		component.setParent(this);

		components.add(component);
	}

	public void removeComponent(final Component component)
	{
		if(components.contains(component)) throw new IllegalArgumentException("Panel does not contain that component.");

		components.remove(component);

		component.setParent(null);
	}

	public void removeComponent(final String componentName)
	{
		removeComponent(Component.getByName(componentName));
	}

	public int getX()
	{
		return x;
	}

	public void setX(final int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(final int y)
	{
		this.y = y;
	}

	public int getWidth()
	{
		return guiWidth;
	}

	public void setWidth(final int guiWidth)
	{
		this.guiWidth = guiWidth;
	}

	public int getHeight()
	{
		return guiHeight;
	}

	public void setHeight(final int guiHeight)
	{
		this.guiHeight = guiHeight;
	}

	public ArrayList<Component> getComponents()
	{
		return (ArrayList<Component>)components;
	}
}
