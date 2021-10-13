package com.melvinbur.archmagica.core.init;

import com.melvinbur.archmagica.ArchMagica;
import com.melvinbur.archmagica.world.surface.ArchMagicaSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SurfaceBuilderInit {
    public static final DeferredRegister<SurfaceBuilder<?>> SURFACE_BUILDERS = DeferredRegister
            .create(ForgeRegistries.SURFACE_BUILDERS, ArchMagica.MOD_ID);

    public static final RegistryObject<ArchMagicaSurfaceBuilder> ARCHMAGICASURFACEBUILDER = SURFACE_BUILDERS.register("corrupted_forest",
            () -> new ArchMagicaSurfaceBuilder(SurfaceBuilderConfig.CODEC));
}