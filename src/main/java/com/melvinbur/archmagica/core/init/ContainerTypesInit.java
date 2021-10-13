package com.melvinbur.archmagica.core.init;

import com.melvinbur.archmagica.ArchMagica;
import com.melvinbur.archmagica.common.container.BlacksmithAnvilContainer;
import com.melvinbur.archmagica.common.container.WitchOvenContainer;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ContainerTypesInit {
	
	public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = DeferredRegister
			.create(ForgeRegistries.CONTAINERS, ArchMagica.MOD_ID);
	
	public static final RegistryObject<ContainerType<WitchOvenContainer>> WITCH_OVEN = CONTAINER_TYPES.register("witch_oven", 
			() -> IForgeContainerType.create(WitchOvenContainer::new));

	public static final RegistryObject<ContainerType<BlacksmithAnvilContainer>> BLACKSMITH_ANVIL
			= CONTAINER_TYPES.register("blacksmith_anvil",
			() -> IForgeContainerType.create(((windowId, inv, data) -> new BlacksmithAnvilContainer(windowId, inv))));





}
	

	
	
