package com.coreframework;

import net.minecraft.client.settings.KeyBinding;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.FMLCommonHandler;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import net.minecraftforge.fml.client.registry.ClientRegistry;

import net.minecraftforge.common.config.Configuration;

import org.lwjgl.input.Keyboard;

import com.coreframework.eventhandlers.KeyboardEventHandler;

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
		/* Initialize fields */

		// Initialize configuration.
		configuration = new Configuration(event.getSuggestedConfigurationFile());

		// Initialize event handlers.
		coreFrameworkConfigEventHandler = new CoreFrameworkConfigEventHandler();

		// Initialize key bindings.
		keyBindings = new KeyBinding[3];

		keyBindings[0] = new KeyBinding("key.test0.desc", Keyboard.KEY_NUMPAD1, "key.coreframework.category");
		keyBindings[1] = new KeyBinding("key.test1.desc", Keyboard.KEY_NUMPAD2, "key.coreframework.category");
		keyBindings[2] = new KeyBinding("key.test2.desc", Keyboard.KEY_NUMPAD3, "key.coreframework.category");

		/* Register event handlers */

		FMLCommonHandler.instance().bus().register(coreFrameworkConfigEventHandler);
		FMLCommonHandler.instance().bus().register(new KeyboardEventHandler());

		/* Setup configuration */

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
		// Register key bindings.
		for(final KeyBinding keyBinding : keyBindings)
		{
			ClientRegistry.registerKeyBinding(keyBinding);
		}
	}

	/**
	 * CoreFramework's configuration.
	 */
	public static Configuration configuration;

	/**
	 * Event handler for the configuration.
	 */
	private CoreFrameworkConfigEventHandler coreFrameworkConfigEventHandler;

	// Test settings
	public String mySettings1;
	public String mySettings2;

	// Test key bindings.
	public static KeyBinding[] keyBindings;

	/**
	 * Update the configuration fields and save if any have changed.
	 */
	public void syncConfig()
	{
		mySettings1 = configuration.getString("mySetting1", Configuration.CATEGORY_GENERAL, "How are you?", "");
		mySettings2 = configuration.getString("mySetting2", Configuration.CATEGORY_GENERAL, "I'm great, how about you?", "");

		if(configuration.hasChanged())
		{
			configuration.save();
		}
	}
}
