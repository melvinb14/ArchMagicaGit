package com.melvinbur.archmagica;






import com.google.common.collect.ImmutableMap;
import com.melvinbur.archmagica.common.blocks.ModWoodTypes;
import com.melvinbur.archmagica.common.fluids.ModFluids;
import com.melvinbur.archmagica.core.init.*;
import net.minecraft.block.Block;
import net.minecraft.block.WoodType;
import net.minecraft.client.renderer.Atlases;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.tileentity.SignTileEntityRenderer;
import net.minecraft.item.AxeItem;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(ArchMagica.MOD_ID)
public class ArchMagica {
    public static final String MOD_ID = "archmagica";

    private static final Logger LOGGER = LogManager.getLogger();



    public ArchMagica() {

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();


        bus.addListener(this::setup);
        // Register the enqueueIMC method for modloading
        bus.addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        bus.addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        bus.addListener(this::doClientStuff);


        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
        TileEntityTypesInit.TILE_ENTITY_TYPE.register(bus);
        ContainerTypesInit.CONTAINER_TYPES.register(bus);
        RecipeSerializers.RECIPE_SERIALIZERS.register(bus);
        ModFluids.register(bus);
        BiomeInit.BIOMES.register(bus);
        BiomeInit.registerBiomes();


        MinecraftForge.EVENT_BUS.register(this);


    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            AxeItem.BLOCK_STRIPPING_MAP = new ImmutableMap.Builder<Block, Block>().putAll(AxeItem.BLOCK_STRIPPING_MAP)
                    .put(BlockInit.CORRUPTED_LOG.get(), BlockInit.STRIPPED_CORRUPTED_LOG.get())
                    .put(BlockInit.CORRUPTED_WOOD.get(), BlockInit.STRIPPED_CORRUPTED_WOOD.get()).build();


            WoodType.register(ModWoodTypes.CORRUPTED);
        });
    }



    private void doClientStuff(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(BlockInit.CORRUPTED_DOOR.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(BlockInit.CORRUPTED_TRAPDOOR.get(), RenderType.getCutout());

            RenderTypeLookup.setRenderLayer(BlockInit.CORRUPTED_LEAVES.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(BlockInit.CORRUPTED_SAPLING.get(), RenderType.getCutout());

            RenderTypeLookup.setRenderLayer(BlockInit.AAPHUSH_FLOWER.get(), RenderType.getCutout());

            ClientRegistry.bindTileEntityRenderer(TileEntityTypesInit.SIGN_TILE_ENTITIES.get(),
                    SignTileEntityRenderer::new);
            Atlases.addWoodType(ModWoodTypes.CORRUPTED);

            RenderTypeLookup.setRenderLayer(ModFluids.OMINOUS_FLUID.get(), RenderType.getTranslucent());
            RenderTypeLookup.setRenderLayer(ModFluids.OMINOUS_BLOCK.get(), RenderType.getTranslucent());
            RenderTypeLookup.setRenderLayer(ModFluids.OMINOUS_FLOWING.get(), RenderType.getTranslucent());
        });
    }




    private void enqueueIMC(final InterModEnqueueEvent event) {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("examplemod", "helloworld", () -> {
            LOGGER.info("Hello world from the MDK");
            return "Hello world";
        });
    }

    private void processIMC(final InterModProcessEvent event) {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

// You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
// Event bus for receiving Registry Events)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public static class RegistryEvents {
    @SubscribeEvent
    public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
        // register a new block here
        LOGGER.info("HELLO from Register Block");
    }
}
}
