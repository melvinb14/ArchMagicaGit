package com.melvinbur.archmagica.core.init;



import com.melvinbur.archmagica.ArchMagica;
import com.melvinbur.archmagica.common.blocks.*;

import com.melvinbur.archmagica.common.blocks.basic.ModStandingSignBlock;
import com.melvinbur.archmagica.common.blocks.basic.ModWallSignBlock;
import com.melvinbur.archmagica.core.init.trees.CorruptedTree;
import com.melvinbur.archmagica.core.itemgroup.ArchMagicaItemGroup2;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.trees.OakTree;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.potion.Effects;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class BlockInit {
	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ArchMagica.MOD_ID);

	public static final RegistryObject<Block> BRECCIA_STONE = registerBlock("breccia_stone",
			() -> new Block(AbstractBlock.Properties.from(Blocks.STONE)));
	
	public static final RegistryObject<Block> PURGATORY_STONE = registerBlock("purgatory_stone",
			() -> new Block(AbstractBlock.Properties.from(Blocks.STONE)));
	
	public static final RegistryObject<Block> RUNIC_STONE = registerBlock("runic_stone",
			() -> new Block(AbstractBlock.Properties.from(Blocks.STONE))); 
	
	public static final RegistryObject<Block> CORRUPTED_GRASS = registerBlock("corrupted_grass",
			() -> new Block(AbstractBlock.Properties.from(Blocks.GRASS_BLOCK)));
	
	public static final RegistryObject<Block> CELESTINE_BLOCK = registerBlock("celestine_block",
			() -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.GRAY)
					.hardnessAndResistance(7f, 7f).harvestTool(ToolType.PICKAXE).setRequiresTool().harvestLevel(4)
					.sound(SoundType.METAL)));
	
	public static final RegistryObject<Block> EDAPHINE_BLOCK = registerBlock("edaphine_block",
			() -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.GRAY)
					.hardnessAndResistance(7f, 7f).harvestTool(ToolType.PICKAXE).setRequiresTool().harvestLevel(4)
					.sound(SoundType.METAL)));
	
	public static final RegistryObject<Block> ORICHALGUM_BLOCK = registerBlock("orichalgum_block",
			() -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.GRAY)
					.hardnessAndResistance(7f, 7f).harvestTool(ToolType.PICKAXE).setRequiresTool().harvestLevel(4)
					.sound(SoundType.METAL)));
	
	public static final RegistryObject<Block> ETHRIL_BLOCK = registerBlock("ethril_block",
			() -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.GRAY)
					.hardnessAndResistance(7f, 7f).harvestTool(ToolType.PICKAXE).setRequiresTool().harvestLevel(4)
					.sound(SoundType.METAL)));
	
	public static final RegistryObject<Block> CRIMSONSTEEL_BLOCK = registerBlock("crimsonsteel_block",
			() -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.GRAY)
					.hardnessAndResistance(6f, 7f).harvestTool(ToolType.PICKAXE).setRequiresTool().harvestLevel(3)
					.sound(SoundType.METAL)));
	
	public static final RegistryObject<Block> SOULSTEEL_BLOCK = registerBlock("soulsteel_block",
			() -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.GRAY)
					.hardnessAndResistance(6f, 7f).harvestTool(ToolType.PICKAXE).setRequiresTool().harvestLevel(3)
					.sound(SoundType.METAL)));
	
	public static final RegistryObject<Block> STYGIUM_BLOCK = registerBlock("stygium_block",
			() -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.GRAY)
					.hardnessAndResistance(6f, 6f).harvestTool(ToolType.PICKAXE).setRequiresTool().harvestLevel(3)
					.sound(SoundType.METAL)));
	
	public static final RegistryObject<Block> ORASINE_BLOCK = registerBlock("orasine_block",
			() -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.GRAY)
					.hardnessAndResistance(5f, 6f).harvestTool(ToolType.PICKAXE).setRequiresTool().harvestLevel(2)
					.sound(SoundType.METAL)));
	
	public static final RegistryObject<Block> MYTHRIL_BLOCK = registerBlock("mythril_block",
			() -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.GRAY)
					.hardnessAndResistance(5f, 6f).harvestTool(ToolType.PICKAXE).setRequiresTool().harvestLevel(2)
					.sound(SoundType.METAL)));
	
	public static final RegistryObject<Block> JADE_BLOCK = registerBlock("jade_block",
			() -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.GRAY)
					.hardnessAndResistance(5f, 6f).harvestTool(ToolType.PICKAXE).setRequiresTool().harvestLevel(2)
					.sound(SoundType.METAL)));
	
	public static final RegistryObject<Block> STEEL_BLOCK = registerBlock("steel_block",
			() -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.GRAY)
					.hardnessAndResistance(5f, 6f).harvestTool(ToolType.PICKAXE).setRequiresTool().harvestLevel(2)
					.sound(SoundType.METAL)));
	
	public static final RegistryObject<Block> CELESTINE_ORE	= registerBlock("celestine_ore",
			() -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY)
					.hardnessAndResistance(7f, 7f).harvestTool(ToolType.PICKAXE).setRequiresTool().harvestLevel(4)
					.sound(SoundType.STONE)));
	
	public static final RegistryObject<Block> EDAPHINE_ORE	= registerBlock("edaphine_ore",
			() -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY)
					.hardnessAndResistance(7f, 7f).harvestTool(ToolType.PICKAXE).setRequiresTool().harvestLevel(4)
					.sound(SoundType.STONE)));
	
	public static final RegistryObject<Block> STYGIUM_ORE	= registerBlock("stygium_ore",
			() -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY)
					.hardnessAndResistance(6f, 6f).harvestTool(ToolType.PICKAXE).setRequiresTool().harvestLevel(3)
					.sound(SoundType.STONE)));
	
	public static final RegistryObject<Block> ORASINE_ORE	= registerBlock("orasine_ore",
			() -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY)
					.hardnessAndResistance(5f, 6f).harvestTool(ToolType.PICKAXE).setRequiresTool().harvestLevel(2)
					.sound(SoundType.STONE)));
	
	public static final RegistryObject<Block> MYTHRIL_ORE	= registerBlock("mythril_ore",
			() -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY)
					.hardnessAndResistance(5f, 6f).harvestTool(ToolType.PICKAXE).setRequiresTool().harvestLevel(2)
					.sound(SoundType.STONE)));
	
	public static final RegistryObject<Block> JADE_ORE	= registerBlock("jade_ore",
			() -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY)
					.hardnessAndResistance(5f, 6f).harvestTool(ToolType.PICKAXE).setRequiresTool().harvestLevel(2)
					.sound(SoundType.STONE)));

	public static final RegistryObject<Block> CORRUPTED_LOG	= registerBlock("corrupted_log",
			() -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.OAK_LOG)));

	public static final RegistryObject<Block> CORRUPTED_WOOD	= registerBlock("corrupted_wood",
			() -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.OAK_WOOD)));

	public static final RegistryObject<Block> STRIPPED_CORRUPTED_LOG	= registerBlock("stripped_corrupted_log",
			() -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.STRIPPED_OAK_LOG)));


	public static final RegistryObject<Block> STRIPPED_CORRUPTED_WOOD = registerBlock("stripped_corrupted_wood",
			() -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.STRIPPED_OAK_WOOD)));

	public static final RegistryObject<Block> CORRUPTED_PLANKS	= registerBlock("corrupted_planks",
			() -> new Block(AbstractBlock.Properties.from(Blocks.OAK_PLANKS)));

	public static final RegistryObject<Block> CORRUPTED_LEAVES = registerBlock("corrupted_leaves", () ->
			new LeavesBlock(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2f).tickRandomly().sound(SoundType.PLANT).notSolid()));

	public static final RegistryObject<Block> CORRUPTED_SAPLING	= registerBlock("corrupted_sapling",
			() -> new SaplingBlock(new CorruptedTree(),AbstractBlock.Properties.from(Blocks.OAK_SAPLING)));

	public static final RegistryObject<Block> AAPHUSH_FLOWER = registerBlock("aaphush_flower",
			() -> new FlowerBlock(Effects.LUCK, 15,AbstractBlock.Properties.from(Blocks.DANDELION).setLightLevel((value) -> {return 5;})));

	public static final RegistryObject<Block> CORRUPTED_SIGN = BLOCKS.register("corrupted_sign",
			() -> new ModStandingSignBlock(AbstractBlock.Properties.create(Material.WOOD), ModWoodTypes.CORRUPTED));

	public static final RegistryObject<Block> CORRUPTED_WALL_SIGN = BLOCKS.register("corrupted_wall_sign",
			() -> new ModWallSignBlock(AbstractBlock.Properties.create(Material.WOOD), ModWoodTypes.CORRUPTED));

	public static final RegistryObject<Block> CORRUPTED_STAIRS = registerBlock("corrupted_stairs",
			() -> new StairsBlock(() -> CORRUPTED_PLANKS.get().getDefaultState(),
					(AbstractBlock.Properties.from(Blocks.OAK_STAIRS))));

	public static final RegistryObject<Block> CORRUPTED_FENCE = registerBlock("corrupted_fence",
			() -> new FenceBlock(AbstractBlock.Properties.from(Blocks.OAK_FENCE)));

	public static final RegistryObject<Block> CORRUPTED_FENCE_GATE = registerBlock("corrupted_fence_gate",
			() -> new FenceGateBlock(AbstractBlock.Properties.from(Blocks.OAK_FENCE_GATE)));

	public static final RegistryObject<Block> CORRUPTED_SLAB = registerBlock("corrupted_slab",
			() -> new SlabBlock(AbstractBlock.Properties.from(Blocks.OAK_SLAB)));


	public static final RegistryObject<Block> CORRUPTED_BUTTON = registerBlock("corrupted_button",
	() -> new WoodButtonBlock(AbstractBlock.Properties.from(Blocks.OAK_BUTTON)));

	public static final RegistryObject<Block> CORRUPTED_PRESSURE_PLATE = registerBlock("corrupted_pressure_plate",
			() -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, (AbstractBlock.Properties.from(Blocks.OAK_PRESSURE_PLATE))));

	public static final RegistryObject<Block> CORRUPTED_DOOR = registerBlock("corrupted_door",
			() -> new DoorBlock(AbstractBlock.Properties.from(Blocks.OAK_DOOR)));

	public static final RegistryObject<Block> CORRUPTED_TRAPDOOR = registerBlock("corrupted_trapdoor",
			() -> new TrapDoorBlock(AbstractBlock.Properties.from(Blocks.OAK_TRAPDOOR)));
	
	
	
    
	
	
	
	// BlockBench Blocks
	

	public static final RegistryObject<Block> WITCH_OVEN = registerBlock("witch_oven",
			() -> new WitchOven(AbstractBlock.Properties.create(Material.ANVIL, MaterialColor.GRAY).
					                                           hardnessAndResistance(5F, 6F).
					                                           setRequiresTool().
					                                           harvestLevel(2).
					                                           sound(SoundType.ANVIL).
					                                           setLightLevel((state) -> {
					                                        	   return state.get(BlockStateProperties.LIT) ? 13 : 0;}
					                                           )));

	public static final RegistryObject<Block> FALLEN_ADVENTURER = registerBlock("fallen_adventurer",
			() -> new FallenAdventurer(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).
					hardnessAndResistance(1F, 1F).
					setRequiresTool().
					harvestLevel(0).
					sound(SoundType.BONE)));

	public static final RegistryObject<Block> OVERGROWN_FALLEN_ADVENTURER = registerBlock("overgrown_fallen_adventurer",
			() -> new OvergrownFallenAdventurer(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).
					hardnessAndResistance(1F, 1F).
					setRequiresTool().
					harvestLevel(0).
					sound(SoundType.BONE)));
	
	
	
	
	
	public static final RegistryObject<Block> BLACKSMITH_ANVIL = registerBlock("blacksmith_anvil",
			() -> new BlacksmithAnvil(AbstractBlock.Properties.create(Material.ANVIL, MaterialColor.GRAY).
					                                           hardnessAndResistance(5F, 6F).
					                                           setRequiresTool().
					                                           sound(SoundType.ANVIL)));
	
	public static final RegistryObject<Block> MAGIC_CRYSTAL	= registerBlock("magic_crystal",
			() -> new MagicCrystal(AbstractBlock.Properties.create(Material.GLASS, MaterialColor.ICE)
	.hardnessAndResistance(0.3F, 0F)
	.sound(SoundType.GLASS)
	.setLightLevel(b -> 11)
	.harvestTool(ToolType.PICKAXE)
	.setRequiresTool()
	.harvestLevel(0)
	.notSolid()));
	
	


	
	
	
	public static final RegistryObject<Block> MAGIC_CRYSTAL2 = registerBlock("magic_crystal2",
			() -> new MagicCrystal2(AbstractBlock.Properties.create(Material.GLASS, MaterialColor.ICE)
					.hardnessAndResistance(0.3F, 0F)
					.sound(SoundType.GLASS)
					.setLightLevel(b -> 11)
					.harvestTool(ToolType.PICKAXE)
					.setRequiresTool()
					.harvestLevel(0)
					.notSolid()));
	      
			
	
	
	
	


	private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
		RegistryObject<T> toReturn = BLOCKS.register(name, block);
		registerBlockItem(name, toReturn);
		return toReturn;
	}

	private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
		ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(),
				new Item.Properties().group(ArchMagicaItemGroup2.ARCHMAGICA)));
	}

	public static void register(IEventBus eventBus) {
		BLOCKS.register(eventBus);
	}
}
	

