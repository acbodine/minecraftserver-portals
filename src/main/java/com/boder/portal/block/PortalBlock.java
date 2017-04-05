package com.boder.portal.block;

import com.boder.portal.Portals;
import com.boder.portal.tileentity.PortalTileEntity;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

// PortalBlock is the key block in any portal construction with this mod.
// The layout of the portal around a PortalBlock will change the portals
// behavior.

public class PortalBlock extends BlockContainer {

	private String name = "portal_block";

	public static final PropertyInteger next = PropertyInteger.create("number", 0, 9);

	public PortalBlock() {

		// TODO: Not sure what the best material to start from is?
		super(Material.PORTAL);

		// TODO: Eventually we will have actual state to save when we implement portal block FSM.
		setDefaultState(blockState.getBaseState().withProperty(next, Integer.valueOf(0)));
		
		setHardness(2F);
		setResistance(5F);
		setHarvestLevel("pickaxe", 2);

		this.registerSelf();
		this.registerItem();
	}

	private void registerSelf() {
		setUnlocalizedName(Portals.MODID + "_" + name);
		setRegistryName(Portals.MODID, name);
		
		GameRegistry.register(this);
	}

	private void registerItem() {

		ItemBlock item = new ItemBlock(this);

		item.setRegistryName(name);
		GameRegistry.register(item);
		
		this.setCreativeTab(CreativeTabs.TRANSPORTATION);
	}
	
	public void registerModelMesher() {

		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
		
		Item item = Item.getItemFromBlock(this);
		ModelResourceLocation location = new ModelResourceLocation(Portals.MODID + ":" + ((PortalBlock) this).getName(), "inventory");
		
		renderItem.getItemModelMesher().register(item, 0, location);
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

//	@Override
//	public EnumBlockRenderType getRenderType(IBlockState state) {
//		return EnumBlockRenderType.MODEL;
//	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new PortalTileEntity();
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		TileEntity te = worldIn.getTileEntity(pos);
		
		if (te == null) return false;
		
		if (!(te instanceof PortalTileEntity)) return false;

		PortalTileEntity pte = (PortalTileEntity) te;

		if (!worldIn.isRemote) pte.teleportPlayer(playerIn);

		return true;
	}

}
