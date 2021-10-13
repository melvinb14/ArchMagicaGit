package com.melvinbur.archmagica.world.gen;



import com.google.common.collect.ImmutableList;
import com.melvinbur.archmagica.core.init.BlockInit;


import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;



public class ModConfiguredFeatures {

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CORRUPTED =
            register("corrupted", Feature.TREE.withConfiguration((
                    new BaseTreeFeatureConfig.Builder(
                            new SimpleBlockStateProvider(BlockInit.CORRUPTED_LOG.get().getDefaultState()),
                            new SimpleBlockStateProvider(BlockInit.CORRUPTED_LEAVES.get().getDefaultState()),
                            new BlobFoliagePlacer(FeatureSpread.create(4), FeatureSpread.create(6), 4),
                            new StraightTrunkPlacer(5, 4, 3),
                            new TwoLayerFeature(3, 8, 6))).setIgnoreVines().build()));

    public static final ConfiguredFeature<?, ?> AAPHUSH_FLOWER_CONFIG = Feature.FLOWER.withConfiguration((
                    new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BlockInit.AAPHUSH_FLOWER.get().getDefaultState()),
                            SimpleBlockPlacer.PLACER)).tries(2).build())
            .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).count(1);



    public static final ConfiguredFeature<?, ?> MAGIC_CRYSTAL_CONFIG = register("magic_crystal", Feature.SIMPLE_BLOCK.withConfiguration
            (new BlockWithContextConfig(BlockInit.MAGIC_CRYSTAL.get().getDefaultState(),
                    ImmutableList.of(Blocks.STONE.getDefaultState()), ImmutableList.of(), ImmutableList.of())).range(50).square().count(10));













    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, key, configuredFeature);
    }
}
