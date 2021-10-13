package com.melvinbur.archmagica.common.container.slot;

import com.melvinbur.archmagica.common.container.WitchOvenContainer;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.FurnaceFuelSlot;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

public class OvenFuelSlot extends Slot
{
	private final WitchOvenContainer handler;
	
	public OvenFuelSlot(WitchOvenContainer handler, IInventory inventoryIn, int index, int xPosition, int yPosition)
	{
		super(inventoryIn, index, xPosition, yPosition);
		
		this.handler = handler;
	}

	@Override
	public boolean isItemValid(ItemStack stack)
	{
		return this.handler.isFuel(stack) || FurnaceFuelSlot.isBucket(stack);
	}
	
	@Override
	public int getItemStackLimit(ItemStack stack)
	{
		return FurnaceFuelSlot.isBucket(stack) ? 1 : super.getItemStackLimit(stack);
	}
}