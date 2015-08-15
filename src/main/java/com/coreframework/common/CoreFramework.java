package com.coreframework.common;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

/**
 * Main mod file.
 *
 * @author oliveryas01
 */
@Mod(modid = CoreFramework.MODID, name = CoreFramework.NAME, version = CoreFramework.VERSION)
public final class CoreFramework
{
	/**
	 * For debugging.
	 */
	public static boolean debugMode = true;

	/**
	 * Mod ID.
	 */
	public static final String MODID = "coreframework";

	/**
	 * Mod name.
	 */
	public static final String NAME = "CoreFramework";

	/**
	 * Mod version.
	 */
	public static final String VERSION = "1.0.0";

	/**
	 * An instance of the mod.
	 */
	@Mod.Instance(MODID)
	public static CoreFramework instance;

	/**
	 * The mod's proxy.
	 */
	@SidedProxy(modId = MODID, clientSide = "com.coreframework.client.CFClientProxy", serverSide = "com.coreframework.server.CFServerProxy")
	public static CFCommonProxy proxy;

	/**
	 * Setup CoreFramework for it's initialization.
	 *
	 * @param event Mod pre-initialization event data.
	 */
	@Mod.EventHandler
	public void preInit(final FMLPreInitializationEvent event)
	{
		proxy.preInit(event);
	}

	/**
	 * Initialize CoreFramework.
	 *
	 * @param event Mod initialization event data.
	 */
	@Mod.EventHandler
	public void init(final FMLInitializationEvent event)
	{
		proxy.init(event);
	}

	/**
	 * Cleanup after initializing CoreFramework.
	 *
	 * @param event Mod post-initialization event data.
	 */
	@Mod.EventHandler
	public void postInit(final FMLPostInitializationEvent event)
	{
		proxy.postInit(event);
	}

	/**
	 * The levels of importance for a printout.
	 */
	public enum Level
	{
		/**
		 * General output.
		 */
		INFO,

		/**
		 * Debug output.
		 *
		 * Will out output if debugMode is true.
		 */
		DEBUG,

		/**
		 * A warning output.
		 *
		 * Something that could cause problems.
		 */
		WARNING,

		/**
		 * An error output.
		 *
		 * Something that did cause problems.
		 */
		ERROR
	}

	/**
	 * Print out a formatted message.
	 *
	 * @param object The output.
	 * @param level The level of importance.
	 */
	public static void println(final Object object, final Level level)
	{
		if(level.name().equals("DEBUG"))
		{
			if(debugMode)
			{
				System.out.println("[" + NAME + "][" + level.name() + "] " + object);
			}
		} else {
			System.out.println("[" + NAME + "][" + level.name() + "] " + object);
		}
	}

	/**
	 * Print out a formatted message.
	 *
	 * @param object The output.
	 */
	public static void println(final Object object)
	{
		println(object, Level.INFO);
	}
}
