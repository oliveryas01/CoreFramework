package com.coreframework;

import java.util.Set;

import net.minecraft.client.Minecraft;

import net.minecraft.client.gui.GuiScreen;

import net.minecraftforge.fml.client.IModGuiFactory;

/**
 * TODO: Javadoc.
 */
public final class CoreFrameworkGuiFactory implements IModGuiFactory
{
	@Override
	public void initialize(final Minecraft minecraftInstance)
	{
	}

	@Override
	public Class<? extends GuiScreen> mainConfigGuiClass()
	{
		return CoreFrameworkGuiConfig.class;
	}

	@Override
	public Set<RuntimeOptionCategoryElement> runtimeGuiCategories()
	{
		return null;
	}

	@Override
	public RuntimeOptionGuiHandler getHandlerFor(final RuntimeOptionCategoryElement element)
	{
		return null;
	}
}
