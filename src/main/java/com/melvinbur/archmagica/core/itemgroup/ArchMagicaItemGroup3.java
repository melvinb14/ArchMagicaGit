package com.melvinbur.archmagica.core.itemgroup;

import com.melvinbur.archmagica.core.init.ItemInit;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ArchMagicaItemGroup3 extends ItemGroup {
	
	
	

	public static final ArchMagicaItemGroup3 ARCHMAGICA = new ArchMagicaItemGroup3(ItemGroup.GROUPS.length, "archmagicatab3");
	
		
		public ArchMagicaItemGroup3(int index, String label) {
		super(index, label);
	
	}

		@Override
		public ItemStack createIcon() {
			return new ItemStack(ItemInit.CELESTINE_CHESTPLATE.get());
		}

		
	}


