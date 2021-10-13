package com.melvinbur.archmagica.common.fluids;

import com.melvinbur.archmagica.ArchMagica;
import com.melvinbur.archmagica.core.init.BlockInit;
import com.melvinbur.archmagica.core.init.ItemInit;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.ResourceLocation;

import net.minecraft.util.SoundEvents;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFluids {
    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation( "archmagica:blocks/fluid/corrupted_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation( "archmagica:blocks/fluid/corrupted_flow");
    public static final ResourceLocation WATER_OVERLAY_RL = new ResourceLocation("block/water_overlay");

    public static final DeferredRegister<Fluid> FLUIDS
            = DeferredRegister.create(ForgeRegistries.FLUIDS, ArchMagica.MOD_ID);


    public static final RegistryObject<FlowingFluid> OMINOUS_FLUID
            = FLUIDS.register("ominous_fluid", () -> new ForgeFlowingFluid.Source(ModFluids.OMINOUS_PROPERTIES));

    public static final RegistryObject<FlowingFluid> OMINOUS_FLOWING
            = FLUIDS.register("ominous_flowing", () -> new ForgeFlowingFluid.Flowing(ModFluids.OMINOUS_PROPERTIES));


    public static final ForgeFlowingFluid.Properties OMINOUS_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> OMINOUS_FLUID.get(), () -> OMINOUS_FLOWING.get(), FluidAttributes.builder(WATER_STILL_RL, WATER_FLOWING_RL)
            .density(1000).luminosity(2).viscosity(2250).sound(SoundEvents.ITEM_BUCKET_FILL).overlay(WATER_OVERLAY_RL)).slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(() -> ModFluids.OMINOUS_BLOCK.get()).bucket(() -> ItemInit.OMINOUS_FLUID_BUCKET.get());

    public static final RegistryObject<FlowingFluidBlock> OMINOUS_BLOCK = BlockInit.BLOCKS.register("ominous",
            () -> new FlowingFluidBlock(() -> ModFluids.OMINOUS_FLUID.get(), AbstractBlock.Properties.create(Material.WATER)
                    .doesNotBlockMovement().hardnessAndResistance(100f).noDrops()));

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}