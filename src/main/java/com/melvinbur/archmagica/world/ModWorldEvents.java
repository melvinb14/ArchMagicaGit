package com.melvinbur.archmagica.world;

import com.melvinbur.archmagica.ArchMagica;
import com.melvinbur.archmagica.world.gen.ModCaveGeneration;
import com.melvinbur.archmagica.world.gen.ModFlowerGeneration;
import com.melvinbur.archmagica.world.gen.ModOreGeneration;
import com.melvinbur.archmagica.world.gen.ModTreeGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ArchMagica.MOD_ID)
    public class ModWorldEvents {

        @SubscribeEvent
        public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
            ModOreGeneration.generateOres(event);
            ModCaveGeneration.generateCrystal(event);


            ModFlowerGeneration.generateFlowers(event);
            ModTreeGeneration.generateTrees(event);
        }
    }
