package com.coreframework.eventhandlers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;

import net.minecraftforge.fml.common.gameevent.InputEvent;

import com.coreframework.CoreFramework;

import com.coreframework.gui.panel.Panel;

import com.coreframework.gui.component.Label;
import com.coreframework.gui.component.Button;

/**
 * TODO: Javadoc.
 */
public final class KeyboardEventHandler
{
    public KeyboardEventHandler() {}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onKeyInput(final InputEvent.KeyInputEvent event)
	{
		final KeyBinding[] keyBindings = CoreFramework.keyBindings;

		if(keyBindings[0].isPressed())
		{
			final Panel testPanel = new Panel(10, 10, 100, 100);

			final Label label1 = new Label("Hello World!");
			final Button button1 = new Button("button1", label1, 0, 0, -1, -1);

			testPanel.addComponent(button1);

			Minecraft.getMinecraft().displayGuiScreen(testPanel);
		} else if(keyBindings[1].isPressed()) {
		} else if(keyBindings[2].isPressed()) {
		}
	}
}
