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

	public static Block Portal;
	
	public static void preInit(FMLPreInitializationEvent event) {

		// TODO: Figure out if we should be instantiating game objects
		// here in order to handle registration to GameRegistry. There
		// might be a better way to handle this, it may involve moving
		// away from this Blocks class.

		Blocks.Portal = new PortalBlock();
	}
	
	public static void postInit(FMLPostInitializationEvent event) {

		if (event.getSide() == Side.CLIENT) {
			((PortalBlock) Blocks.Portal).registerModelMesher();
		}

	}
}
