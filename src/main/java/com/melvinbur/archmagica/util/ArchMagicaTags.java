package com.melvinbur.archmagica.util;

import com.melvinbur.archmagica.ArchMagica;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

public class ArchMagicaTags {

    public static class Blocks {

        // Blocks
        public static final Tags.IOptionalNamedTag<Block> BRECCIA_STONE =
                createTag("breccia_stone");

        public static final Tags.IOptionalNamedTag<Block> PURGATORY_STONE =
                createTag("purgatory_stone");


        // Tag Types
        private static Tags.IOptionalNamedTag<Block> createTag(String name) {
            return BlockTags.createOptional(new ResourceLocation(ArchMagica.MOD_ID, name));
        }

        private static Tags.IOptionalNamedTag<Block> createForgeTag(String name) {
            return BlockTags.createOptional(new ResourceLocation("forge", name));
        }
    }

    public static class Items {

        // Items
        public static final Tags.IOptionalNamedTag<Item> STEEL_INGOT =
                createForgeTag("ingots/steel_ingot");

        public static final Tags.IOptionalNamedTag<Item> JADE =
                createForgeTag("gems/jade");
        // Tag Types
        private static Tags.IOptionalNamedTag<Item> createTag(String name) {
            return ItemTags.createOptional(new ResourceLocation(ArchMagica.MOD_ID, name));
        }

        private static Tags.IOptionalNamedTag<Item> createForgeTag(String name) {
            return ItemTags.createOptional(new ResourceLocation("forge", name));
        }
    }
}
