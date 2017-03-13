package com.boder.portal.blocks;

import com.boder.portal.Portal;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockPortal extends Block {

	String name = "portal";

	public BlockPortal() {
		super(Material.ROCK);

		setUnlocalizedName(Portal.MODID + "_" + name);
		setRegistryName(Portal.MODID, name);
		
		GameRegistry.register(this);
		
		ItemBlock itemBlock = new ItemBlock(this);
    	itemBlock.setRegistryName(name);
    	GameRegistry.register(itemBlock);
		
		this.setCreativeTab(CreativeTabs.TRANSPORTATION);
		
		setHardness(2F);
		setResistance(5F);
		setHarvestLevel("pickaxe", 2);
	}
	
	public String getName() {
		return name;
	}
}
