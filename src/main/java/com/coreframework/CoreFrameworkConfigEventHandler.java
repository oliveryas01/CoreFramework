package com.coreframework;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;

import net.minecraftforge.fml.client.event.ConfigChangedEvent;

/**
 * The event handler for CoreFramework's built in configuration.
 */
final class CoreFrameworkConfigEventHandler
{
	/**
	 * Constructs a CoreFrameworkConfigEventHandler.
	 */
	public CoreFrameworkConfigEventHandler() {}

	/**
	 * When a configuration value is changed.
	 *
	 * @param event Configuration changed event.
	 */
	@SideOnly(Side.CLIENT)
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onConfigurationChanged(final ConfigChangedEvent.OnConfigChangedEvent event)
	{
		if(event.modID.equals(CoreFramework.MODID))
		{
			CoreFramework.syncConfig();
		}
	}
}
