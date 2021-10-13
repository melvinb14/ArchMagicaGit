package com.melvinbur.archmagica.core.util;

import com.melvinbur.archmagica.ArchMagica;
import com.melvinbur.archmagica.client.gui.BlacksmithAnvilScreen;
import com.melvinbur.archmagica.client.gui.WitchOvenScreen;
import com.melvinbur.archmagica.core.init.ContainerTypesInit;

import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = ArchMagica.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		ScreenManager.registerFactory(ContainerTypesInit.WITCH_OVEN.get(), WitchOvenScreen::new);


			ScreenManager.registerFactory(ContainerTypesInit.BLACKSMITH_ANVIL.get(), BlacksmithAnvilScreen::new);


		
	}
}