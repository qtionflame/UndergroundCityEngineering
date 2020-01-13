package com.miangs.temloemod;

import com.miangs.temloemod.entity.FakePlayerLoader;

// Ctrl + F11 启动

import com.miangs.temloemod.proxy.CommonProxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = TemloeMod.MODID, name = TemloeMod.NAME, version = TemloeMod.VERSION)
public class TemloeMod
{
	@SidedProxy(clientSide = "com.miangs.temloemod.proxy.ClientProxy", serverSide = "com.miangs.temloemod.proxy.CommonProxy")
	public static CommonProxy proxy;




	public static final String MODID = "temloe";
	public static final String NAME = "Temloe NET";
	public static final String VERSION = "1.0";
	
	@Instance(TemloeMod.MODID)
	public static TemloeMod instance;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(proxy);
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		instance = this;
		 new FakePlayerLoader();
		 System.out.println("FakePlayerLoader ! ! !");
	}
}
