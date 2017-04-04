package com.boder.portal.tileentity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.boder.portal.block.PortalBlock;

import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.Chunk;

public class PortalTileEntity extends TileEntity implements ITickable {

	// A Named Binary Tag (NBT) is one way of storing additional
	// information about items, blocks, entities, or tile entities
	// in Minecraft.

	private int counter = 0;

	private int next = 0;

	public PortalTileEntity() {}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);

		// TODO: Get more things you need for the portal here.
		// next = compound.getInteger("next")
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);

		// TODO: Add things that you need to store about the portal.
		// compound.setInteger("next", 0);

		return compound;
	}

	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
		super.onDataPacket(net, pkt);

		this.readFromNBT(pkt.getNbtCompound());
	}

	@Override
	public void update() {
		if (!world.isRemote) return;

		counter++;

		// By executing every 20 ticks, we are executing roughly once a second.
		if (counter < 20) return;

		counter = 0;

		BlockPos position = this.getPos();
		Block block = world.getBlockState(position).getBlock();

		List<BlockPos> positions = new ArrayList<BlockPos>();
		positions.add(position.up());
		positions.add(position.down());
		positions.add(position.north());
		positions.add(position.east());
		positions.add(position.south());
		positions.add(position.west());
		
		// Compare with blocks around it based on block.getRegistryName()
		System.out.println("Checking positions around " + block.getRegistryName()  + " at " + position.toString());

		for (Iterator<BlockPos> i = positions.iterator(); i.hasNext(); ) {
			BlockPos p = i.next();
			Block b = world.getBlockState(p).getBlock();
			
			if (!b.getRegistryName().equals(block.getRegistryName())) continue;
			
			System.out.println("An adjacent block of the same type at " + p.toString());
		}
	}
	
}
