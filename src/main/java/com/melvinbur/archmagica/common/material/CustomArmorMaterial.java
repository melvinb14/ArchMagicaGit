package com.melvinbur.archmagica.common.material;

import java.util.function.Supplier;

import com.melvinbur.archmagica.core.init.ItemInit;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public enum CustomArmorMaterial implements IArmorMaterial {
	CELESTINE_ARMOR("celestine", 10, new int[] { 9, 12, 11, 8 }, 25, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 6f, 0.0f,
			() -> Ingredient.fromItems(ItemInit.CELESTINE_INGOT.get())),
	EDAPHINE_ARMOR("edaphine", 10, new int[] { 9, 12, 11, 8 }, 25, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 6f, 0.0f,
			() -> Ingredient.fromItems(ItemInit.EDAPHINE_INGOT.get())),
	ORICHALGUM_ARMOR("orichalgum", 7, new int[] { 7, 10, 9, 6 }, 35, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 4f, 0.0f,
			() -> Ingredient.fromItems(ItemInit.ORICHALGUM_INGOT.get())),
	ETHRIL_ARMOR("ethril", 8, new int[] { 7, 10, 9, 6 }, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 4f, 0.0f,
			() -> Ingredient.fromItems(ItemInit.ETHRIL_INGOT.get())),
	CRIMSONSTEEL_ARMOR("crimsonsteel", 3, new int[] { 5, 8, 7, 4 }, 14, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2f, 0.0f,
			() -> Ingredient.fromItems(ItemInit.CRIMSONSTEEL_INGOT.get())),
	SOULSTEEL_ARMOR("soulsteel", 3, new int[] { 6, 8, 7, 4 }, 16, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2f, 0.0f,
			() -> Ingredient.fromItems(ItemInit.SOULSTEEL_INGOT.get())),
	STYGIUM_ARMOR("stygium", 3, new int[] { 5, 8, 7, 4 }, 8, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0f, 0.0f,
			() -> Ingredient.fromItems(ItemInit.STYGIUM_INGOT.get())),
	ORASINE_ARMOR("orasine", 2, new int[] { 4, 6, 5, 3 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0f, 0.0f,
			() -> Ingredient.fromItems(ItemInit.ORASINE_INGOT.get())),
	MYTHRIL_ARMOR("mythril", 2, new int[] { 3, 7, 5, 3 }, 13, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0f, 0.0f,
			() -> Ingredient.fromItems(ItemInit.MYTHRIL_INGOT.get())),
	JADE_ARMOR("jade", 1, new int[] { 3, 6, 5, 2 }, 17, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0f, 0.0f,
			() -> Ingredient.fromItems(ItemInit.JADE.get())),
	STEEL_ARMOR("steel", 1, new int[] { 3, 6, 5, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 1f, 0.0f,
			() -> Ingredient.fromItems(ItemInit.STEEL_INGOT.get()));

	private static final int[] baseDurability = { 128, 144, 160, 112 };
	private final String name;
	private final int durabilityMultiplier;
	private final int[] armorVal;
	private final int enchantability;
	private final SoundEvent equipSound;
	private final float toughness;
	private final float knockbackResistance;
	private final Ingredient repairIngredient;

	CustomArmorMaterial(String name, int durabilityMultiplier, int[] armorVal, int enchantability,
			SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
		this.name = name;
		this.durabilityMultiplier = durabilityMultiplier;
		this.armorVal = armorVal;
		this.enchantability = enchantability;
		this.equipSound = equipSound;
		this.toughness = toughness;
		this.knockbackResistance = knockbackResistance;
		this.repairIngredient = repairIngredient.get();

	}

	@Override
	public int getDurability(EquipmentSlotType slot) {
		return baseDurability[slot.getIndex()] * this.durabilityMultiplier;
	}

	@Override
	public int getDamageReductionAmount(EquipmentSlotType slot) {
		return this.armorVal[slot.getIndex()];
	}

	@Override
	public int getEnchantability() {
		return this.enchantability;
	}

	@Override
	public SoundEvent getSoundEvent() {
		return this.equipSound;
	}

	@Override
	public Ingredient getRepairMaterial() {
		return this.repairIngredient;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public float getToughness() {
		return this.toughness;
	}

	@Override
	public float getKnockbackResistance() {
		return this.knockbackResistance;
	}

}