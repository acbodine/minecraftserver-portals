package com.boder.portal.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantment.Rarity;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class Enchantments {

	public static Enchantment Portal;

	public static void preInit(FMLPreInitializationEvent event) {
		Portal = new PortalEnchantment(Rarity.COMMON, EnumEnchantmentType.ALL, EntityEquipmentSlot.values());
	}
}
