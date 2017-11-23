package com.boder.portal.enchantment;

import com.boder.portal.Portals;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class PortalEnchantment extends Enchantment {

	private String name = "portal_enchantment";
	
	protected PortalEnchantment(Rarity rarityIn, EnumEnchantmentType typeIn, EntityEquipmentSlot[] slots) {
		super(rarityIn, typeIn, slots);
		this.setName("Space Render");
		setRegistryName(Portals.MODID, name);
		GameRegistry.register(this);
	}

	@Override
	public int getMinEnchantability(int enchantmentLevel) {
		return 1 + (enchantmentLevel - 1) * 10;
	}

	@Override
	public int getMaxEnchantability(int enchantmentLevel) {
		return getMinEnchantability(enchantmentLevel) + 20;
	}

	@Override
	public int getMaxLevel() {

		// We only want this enchantment to have one level, mastery.
		return 1;
	}

	@Override
	public void onEntityDamaged(EntityLivingBase user, Entity target, int level) {
		teleportPlayer(user);
	}
	
	public void teleportPlayer(EntityLivingBase user) {
		System.out.println("Teleporting player:");
		System.out.println(user);

		int skip = 150;

		BlockPos position = user.getPosition();
		user.setPositionAndUpdate(position.getX() + skip * 10, position.getY() + skip, position.getZ());
	}

}
