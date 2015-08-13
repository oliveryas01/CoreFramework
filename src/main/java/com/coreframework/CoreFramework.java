package com.coreframework;

import net.minecraftforge.fml.common.Mod;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import net.minecraftforge.common.config.Configuration;

/**
 * Main mod file.
 *
 * @author oliveryas01
 */
@Mod(modid = CoreFramework.MODID, name = CoreFramework.NAME, version = CoreFramework.VERSION)
public final class CoreFramework
{
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
	@Mod.Instance(NAME)
	public static CoreFramework instance;

	public Configuration configuration;

	/**
	 * Setup CoreFramework for it's initialization.
	 *
	 * @param event Mod pre-initialization event data.
	 */
	@Mod.EventHandler
	public void preInit(final FMLPreInitializationEvent event)
	{
		configuration = new Configuration(event.getSuggestedConfigurationFile());

		configuration.load();

		// TODO: Configuration.

		configuration.save();
	}

	/**
	 * Initialize CoreFramework.
	 *
	 * @param event Mod initialization event data.
	 */
	@Mod.EventHandler
	public void init(final FMLInitializationEvent event)
	{
	}
}
