package com.melvinbur.archmagica.common.blocks.basic;


import com.melvinbur.archmagica.common.te.ModSignTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.StandingSignBlock;

import net.minecraft.block.WoodType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class ModStandingSignBlock extends StandingSignBlock {
    public ModStandingSignBlock
            (Properties properties, WoodType type) {
        super(properties, type);
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {

        return new ModSignTileEntity();
    }
}
