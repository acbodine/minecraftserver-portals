package com.boder.portal.block;

import com.boder.portal.Portals;
import com.boder.portal.tileentity.PortalTileEntity;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class PortalBlock extends BlockContainer {

	String name = "portal_block";

	public static final PropertyInteger next = PropertyInteger.create("number", 0, 9);

	public PortalBlock() {
		super(Material.ROCK);

		setUnlocalizedName(Portals.MODID + "_" + name);
		setRegistryName(Portals.MODID, name);

		// setDefaultState(blockState.getBaseState().withProperty(next, Integer.valueOf(0)));

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

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(next, Integer.valueOf(0));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return (Integer) state.getValue(next);
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, next);
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}

	// createNewTileEntity returns the created tile entity.
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new PortalTileEntity();
	}

}
