package com.boder.portal;

import com.boder.portal.block.Blocks;
import com.boder.portal.enchantment.Enchantments;
// import com.boder.portal.item.Items;
import com.boder.portal.tileentity.TileEntities;

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
    public void preInit(FMLPreInitializationEvent event) {

    	/*
    	 * Give packages in this mod a chance to respond to the preInit event,
    	 * this way the individual components can register their respective
    	 * game objects. 
    	 */

    	Enchantments.preInit(event);

    	Blocks.preInit(event);
    	TileEntities.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

    	/*
    	 * If there is any mod specific config or parameters this mod requires,
    	 * here is a good place to do such a thing. Ideally this is empty.
    	 * 
    	 * No registering of game objects here!
    	 */

        System.out.println(MODID + "-" + VERSION + " initialized.");

    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    	/*
    	 * This is a safe place for any logic that is dependent upon other
    	 * mods. They are guaranteed to be available at this point.
    	 */

    	Blocks.postInit(event);

    }
}
