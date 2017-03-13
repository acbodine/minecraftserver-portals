package com.boder.portal;

import com.boder.portal.blocks.ModBlocks;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Portal.MODID, version = Portal.VERSION)
public class Portal {
    public static final String MODID = "portalmod";
    public static final String VERSION = "0.1";
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
        System.out.println(MODID + " initialized.");
    }
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	ModBlocks.preInit(event);
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	ModBlocks.postInit(event);
    }
}
