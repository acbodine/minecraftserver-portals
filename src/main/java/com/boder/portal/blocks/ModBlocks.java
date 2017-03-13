package com.boder.portal.blocks;

import com.boder.portal.Portal;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

public class ModBlocks {
	public static Block portal;
	
	public static void preInit(FMLPreInitializationEvent event) {
		portal = new BlockPortal();
	}
	
	public static void postInit(FMLPostInitializationEvent event) {
		if (event.getSide() == Side.CLIENT) {
			RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
			
			Item item = Item.getItemFromBlock(portal);
			ModelResourceLocation location = new ModelResourceLocation(Portal.MODID + ":" + ((BlockPortal) portal).getName(), "inventory");
			
			renderItem.getItemModelMesher().register(item, 0, location);
		}
	}
}
