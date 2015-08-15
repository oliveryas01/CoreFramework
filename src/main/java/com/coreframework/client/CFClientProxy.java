package com.coreframework.client;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.coreframework.common.CFCommonProxy;

/**
 * The proxy for the client.
 */
public final class CFClientProxy extends CFCommonProxy
{
	/**
	 * Default constructor.
	 */
    public CFClientProxy() {}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void preInit(final FMLPreInitializationEvent event)
	{
		// Common.
		super.preInit(event);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void init(final FMLInitializationEvent event)
	{
		// Common.
		super.init(event);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void postInit(final FMLPostInitializationEvent event)
	{
		// Common.
		super.postInit(event);
	}
}
