package com.coreframework;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import net.minecraftforge.fml.client.event.ConfigChangedEvent;

/**
 * TODO: Javadoc.
 */
public final class CoreFrameworkConfigEventHandler
{
	public CoreFrameworkConfigEventHandler() {}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onConfigurationChanged(final ConfigChangedEvent.OnConfigChangedEvent event)
	{
		if(event.modID.equals(CoreFramework.MODID))
		{
			CoreFramework.instance.syncConfig();
		}
	}
}
