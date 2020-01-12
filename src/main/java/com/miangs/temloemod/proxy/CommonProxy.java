package com.miangs.temloemod.proxy;

import com.miangs.temloemod.entity.FakePlayerLoader;
import com.miangs.temloemod.init.MODBlocks;
import com.miangs.temloemod.init.MODItems;


import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CommonProxy
{
	
	@SubscribeEvent	//RegistryEvent.
	public void registerItems(Register<Item> event)
	{
		event.getRegistry().register(MODItems.nexg);
		event.getRegistry().register(new ItemBlock(MODBlocks.block_folg).setRegistryName(MODBlocks.block_folg.getRegistryName()));
		
		event.getRegistry().register(new ItemBlock(MODBlocks.block_wkgagg).setRegistryName(MODBlocks.block_wkgagg.getRegistryName()));
	}
	
	
	
	
	@SubscribeEvent
	public void registerBlocks(Register<Block> event)
	{
		// 注册方块
		event.getRegistry().register(MODBlocks.block_folg);
		
		event.getRegistry().register(MODBlocks.block_wkgagg);
	}
	
	
	
	
	public void registerItemBlock(Block block, RegistryEvent.Register<Item> event)
	{
		event.getRegistry().register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}
	
	
	
	
	public void init(FMLInitializationEvent event)
    {
      //  new FakePlayerLoader();
        System.out.println("FakePlayerLoader ! ! !");
    }
	
	
	
	
	
	
	
	
	
	
	
}
