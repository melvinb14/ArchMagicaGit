package com.melvinbur.archmagica.common.te;

import com.melvinbur.archmagica.core.init.TileEntityTypesInit;
import net.minecraft.tileentity.SignTileEntity;
import net.minecraft.tileentity.TileEntityType;

public class ModSignTileEntity extends SignTileEntity {
    public ModSignTileEntity() {

        super();
    }

    @Override
    public TileEntityType<?> getType() {

        return TileEntityTypesInit.SIGN_TILE_ENTITIES.get();
    }
}
