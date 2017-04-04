package com.boder.portal;

import com.boder.portal.block.Blocks;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Portals.MODID, version = Portals.VERSION)
public class Portals {
    public static final String MODID = "portalsmod";
    public static final String VERSION = "0.1";

    @EventHandler
    public void init(FMLInitializationEvent event) {
        System.out.println(MODID + "-" + VERSION + " initialized.");
    }
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	Blocks.preInit(event);
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	Blocks.postInit(event);
    }
}
