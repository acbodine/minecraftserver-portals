package com.boder.portal.block;

import com.boder.portal.Portals;
import com.boder.portal.tileentity.PortalTileEntity;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

public class Blocks {
	public static Block portal;
	
	public static void preInit(FMLPreInitializationEvent event) {
		portal = new PortalBlock();

		// TODO: Move this to PortalTileEntity constructor.
		GameRegistry.registerTileEntity(PortalTileEntity.class, Portals.MODID + "_portal_tileentity");
	}
	
	public static void postInit(FMLPostInitializationEvent event) {
		if (event.getSide() == Side.CLIENT) {
			RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
			
			Item item = Item.getItemFromBlock(portal);
			ModelResourceLocation location = new ModelResourceLocation(Portals.MODID + ":" + ((PortalBlock) portal).getName(), "inventory");
			
			renderItem.getItemModelMesher().register(item, 0, location);
		}
	}
}
