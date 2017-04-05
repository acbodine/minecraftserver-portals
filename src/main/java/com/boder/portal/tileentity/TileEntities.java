package com.boder.portal.tileentity;

import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class TileEntities {

	public static TileEntity PortalBlock;

	public static void preInit(FMLPreInitializationEvent event) {

		// TODO: Figure out if we should be instantiating game objects
		// here in order to handle registration to GameRegistry. There
		// might be a better way to handle this, it may involve moving
		// away from this TileEntities class.

		TileEntities.PortalBlock = new PortalTileEntity();
	}

}
