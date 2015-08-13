package com.coreframework;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.FMLCommonHandler;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import net.minecraftforge.fml.client.event.ConfigChangedEvent;

import net.minecraftforge.common.config.Configuration;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Main mod file.
 *
 * @author oliveryas01
 */
@Mod(modid = CoreFramework.MODID, name = CoreFramework.NAME, version = CoreFramework.VERSION, guiFactory = "com." + CoreFramework.MODID + "." + CoreFramework.NAME + "GuiFactory")
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

		syncConfig();
	}

	/**
	 * Initialize CoreFramework.
	 *
	 * @param event Mod initialization event data.
	 */
	@Mod.EventHandler
	public void init(final FMLInitializationEvent event)
	{
		FMLCommonHandler.instance().bus().register(this);
	}

	public static Configuration configuration;

	public String mySettings1;
	public String mySettings2;

	private void syncConfig()
	{
		mySettings1 = configuration.getString("mySetting1", Configuration.CATEGORY_GENERAL, "How are you?", "");
		mySettings2 = configuration.getString("mySetting2", Configuration.CATEGORY_GENERAL, "I'm great, how about you?", "");

		if(configuration.hasChanged())
		{
			configuration.save();
		}
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onConfigurationChanged(final ConfigChangedEvent.OnConfigChangedEvent event)
	{
		if(event.modID.equals(MODID))
		{
			syncConfig();
		}
	}
}