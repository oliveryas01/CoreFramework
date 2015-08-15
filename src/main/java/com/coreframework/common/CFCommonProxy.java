package com.coreframework.common;

import java.io.IOException;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

import com.coreframework.util.VersionChecker;

/**
 * The common proxy for both the client and server.
 */
public class CFCommonProxy
{
    public CFCommonProxy() {}

	/**
	 * Setup CoreFramework for it's initialization.
	 *
	 * @param event Mod pre-initialization event data.
	 */
	public void preInit(final FMLPreInitializationEvent event)
	{
	}

	/**
	 * Initialize CoreFramework.
	 *
	 * @param event Mod initialization event data.
	 */
	public void init(final FMLInitializationEvent event) {}

	/**
	 * Cleanup after initializing CoreFramework.
	 *
	 * @param event Mod post-initialization event data.
	 */
	public void postInit(final FMLPostInitializationEvent event)
	{
		try
		{
			if(!VersionChecker.isLatestVersion())
			{
				CoreFramework.instance.println("Update available!");
			}
		} catch(final IOException e) {
			CoreFramework.instance.println("Version check was cancelled.", CoreFramework.Level.WARNING);
		}
	}
}
