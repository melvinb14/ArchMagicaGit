package com.melvinbur.archmagica.world.surface;
import com.melvinbur.archmagica.core.init.BlockInit;
import com.mojang.serialization.Codec;
import java.util.Random;
import net.minecraft.block.BlockState;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class ArchMagicaSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {

    public static final BlockState CORRUPTED_GRASS = BlockInit.CORRUPTED_GRASS.get().getDefaultState();


    public static final SurfaceBuilderConfig CORRUPTED_GRASS_CONFIG = new SurfaceBuilderConfig(CORRUPTED_GRASS,
            CORRUPTED_GRASS, CORRUPTED_GRASS);


    public ArchMagicaSurfaceBuilder(Codec<SurfaceBuilderConfig> codec) {
        super(codec);
    }

    @Override
    public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
                             BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        if (noise > 1.75D) {
            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
                    defaultFluid, seaLevel, seed, CORRUPTED_GRASS_CONFIG);


        }
    }

}