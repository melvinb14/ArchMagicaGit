package com.melvinbur.archmagica.common.blocks;

import com.melvinbur.archmagica.ArchMagica;
import net.minecraft.block.WoodType;
import net.minecraft.util.ResourceLocation;

public class ModWoodTypes {

    public static final WoodType CORRUPTED =
            WoodType.create(new ResourceLocation(ArchMagica.MOD_ID, "corrupted").toString());
}
