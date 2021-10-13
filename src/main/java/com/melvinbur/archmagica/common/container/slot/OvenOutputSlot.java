package com.melvinbur.archmagica.common.container.slot;

import com.melvinbur.archmagica.common.te.WitchOvenTileEntity;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

public class OvenOutputSlot extends Slot
{
	private PlayerEntity player;
	private int amount;

	public OvenOutputSlot(PlayerEntity player, IInventory inventoryIn, int index, int xPosition, int yPosition) 
	{
		super(inventoryIn, index, xPosition, yPosition);
		this.player = player;
	}	
	
	@Override
	public boolean isItemValid(ItemStack stack) 
	{
		return false;
	}
	
	@Override
	public ItemStack decrStackSize(int amount)
	{
		if (this.getHasStack()) 
		{
			this.amount += Math.min(amount, this.getStack().getCount());
		}

		return super.decrStackSize(amount);
	}
	
	@Override
	public ItemStack onTake(PlayerEntity thePlayer, ItemStack stack) 
	{
		this.onCrafting(stack);
		super.onTake(player, stack);
		return stack;
	}
	
	@Override
	protected void onCrafting(ItemStack stack, int amount) 
	{
		this.amount += amount;
		this.onCrafting(stack);
	}
	
	@Override
	protected void onCrafting(ItemStack stack) 
	{
		stack.onCrafting(this.player.world, this.player, this.amount);
		if (!this.player.world.isRemote && this.inventory instanceof WitchOvenTileEntity) 
		{
			((WitchOvenTileEntity) this.inventory).dropExperience(player);
		}
		this.amount = 0;
	}
}