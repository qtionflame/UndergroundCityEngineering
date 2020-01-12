package com.miangs.temloemod.proxy;

import com.miangs.temloemod.init.MODBlocks;
import com.miangs.temloemod.init.MODItems;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ClientProxy extends CommonProxy
{
	@SubscribeEvent
	public void registerItemModels(ModelRegistryEvent event) {
		// registerItemModel(Item.getItemFromBlock(ModBlocks.FIRST_BLOCK)); 这个太长了，可以缩短一些。
		// 注册方块的物品的模型
		//registerItemModel(MODBlocks.block_folg);
		
		
		
		registerItemModel(Item.getItemFromBlock(MODBlocks.block_folg));
		registerItemModel(Item.getItemFromBlock(MODBlocks.block_wkgagg));
		
		
		// 注册普通的物品的模型
		registerItemModel(MODItems.nexg);
	}
	
	// 注册方块的物品的模型
	
	/*
	public void registerItemModel(Block block) {
		registerItemModel(Item.getItemFromBlock(block));
	}
	*/
	
	// 注册普通的物品的模型
	public void registerItemModel(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}

	
	
}
