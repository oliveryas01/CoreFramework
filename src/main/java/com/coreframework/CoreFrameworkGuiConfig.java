package com.coreframework;

import net.minecraft.client.gui.GuiScreen;

import net.minecraftforge.fml.client.config.GuiConfig;

import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

/**
 * TODO: Javadoc.
 */
public final class CoreFrameworkGuiConfig extends GuiConfig
{
	public CoreFrameworkGuiConfig(final GuiScreen parentScreen)
	{
		super(
				parentScreen,
				new ConfigElement(CoreFramework.configuration.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
				CoreFramework.MODID,
				false,
				false,
				CoreFramework.NAME + " Configuration",
				GuiConfig.getAbridgedConfigPath(CoreFramework.configuration.toString())
		);
	}

	@Override
	public void initGui()
	{
		super.initGui();
	}

	@Override
	public void updateScreen()
	{
		super.updateScreen();
	}

	@Override
	public void drawScreen(final int mouseX, final int mouseY, final float partialTicks)
	{
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
}
