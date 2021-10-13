package com.melvinbur.archmagica.core.init;

import com.melvinbur.archmagica.ArchMagica;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeMaker;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class BiomeInit {

    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES,
            ArchMagica.MOD_ID);

    // Add more biomes here!
    static {
        createBiome("corrupted_forest", BiomeMaker::makeVoidBiome);
    }

    // (and also here!)
    public static RegistryKey<Biome> CORRUPTED_FOREST = registerBiome("corrupted_forest");

    public static RegistryKey<Biome> registerBiome(String biomeName) {
        return RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation(ArchMagica.MOD_ID, biomeName));
    }

    public static RegistryObject<Biome> createBiome(String biomeName, Supplier<Biome> biome) {
        return BIOMES.register(biomeName, biome);
    }

    public static void registerBiomes() {
    BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(CORRUPTED_FOREST, 10));
    }
}