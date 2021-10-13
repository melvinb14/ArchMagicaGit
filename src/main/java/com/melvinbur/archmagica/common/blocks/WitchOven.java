package com.melvinbur.archmagica.common.blocks;



import java.util.Random;

import java.util.stream.Stream;



import com.melvinbur.archmagica.common.te.WitchOvenTileEntity;
import com.melvinbur.archmagica.core.init.TileEntityTypesInit;


import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.ITag;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraftforge.api.distmarker.Dist;

import net.minecraftforge.fml.network.NetworkHooks;


public class WitchOven extends Block {


	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	public static final BooleanProperty LIT = BlockStateProperties.LIT;


	private static final VoxelShape SHAPE_N = Stream.of(
			Block.makeCuboidShape(0.8000000000000007, 2, 0.5, 14.8, 2.45, 14.5),
			Block.makeCuboidShape(13.1, 3.2, 0.875, 13.5, 11.2, 1.4000000000000004),
			Block.makeCuboidShape(2.0999999999999996, 3.25, 0.875, 2.5, 11.2, 1.424999999999999),
			Block.makeCuboidShape(11.45, 3.825, 0.875, 11.85, 10.45, 1.299999999999999),
			Block.makeCuboidShape(2.2624999999999993, 10.4375, 0.875, 13.2375, 11.2125, 1.299999999999999),
			Block.makeCuboidShape(2.2624999999999993, 3.2125, 0.875, 13.2375, 3.9875, 1.049999999999999),
			Block.makeCuboidShape(9.6, 3.875, 0.875, 10.3, 10.45, 1.299999999999999),
			Block.makeCuboidShape(8.25, 3.775, 0.875, 8.65, 10.75, 1.299999999999999),
			Block.makeCuboidShape(6.6, 3.925, 0.875, 7.325000000000001, 10.725, 1.299999999999999),
			Block.makeCuboidShape(4.949999999999999, 3.925, 0.875, 5.35, 10.6, 1.299999999999999),
			Block.makeCuboidShape(3.5999999999999996, 3.85, 0.875, 4, 10.525, 1.299999999999999),
			Block.makeCuboidShape(1.9000000000000004, 0.025, 1.9999999999999982, 3, 2.025, 2.9749999999999996),
			Block.makeCuboidShape(13, 0.025, 1.9999999999999982, 14.1, 2.025, 2.9749999999999996),
			Block.makeCuboidShape(13, 0.025, 13.024999999999999, 14.1, 2.025, 14),
			Block.makeCuboidShape(1.9000000000000004, 0.025, 13.024999999999999, 3, 2.025, 14),
			Block.makeCuboidShape(8.8, 13.325, 9.175, 9.1, 23.275, 9.475),
			Block.makeCuboidShape(6.525, 13.325, 9.175, 6.824999999999999, 23.225, 9.475),
			Block.makeCuboidShape(6.25, 23.175, 6.225, 9.425, 23.35, 9.7),
			Block.makeCuboidShape(6.75, 23.375, 6.825000000000001, 8.925, 23.55, 9.2),
			Block.makeCuboidShape(6.525, 13.325, 6.475, 6.824999999999999, 23.225, 6.775),
			Block.makeCuboidShape(6.824999999999999, 13.325, 6.575000000000001, 8.825, 22.55, 6.700000000000001),
			Block.makeCuboidShape(6.824999999999999, 13.325, 9.275, 8.825, 22.575, 9.4),
			Block.makeCuboidShape(6.65, 13.325, 6.775, 6.775, 22.5, 9.175),
			Block.makeCuboidShape(8.95, 13.325, 6.775, 9.075, 22.475, 9.175),
			Block.makeCuboidShape(8.825, 13.325, 6.475, 9.125, 23.3, 6.775),
			Block.makeCuboidShape(0.8000000000000007, 12.5, 0.5, 14.8, 12.95, 14.5),
			Block.makeCuboidShape(1.9000000000000004, 13, 1.5999999999999996, 13.8, 13.35, 13.4),
			Block.makeCuboidShape(1.5999999999999996, 2.5, 1.5, 14, 12.5, 13.825),
			Block.makeCuboidShape(2.125, 3.575, 1.075000000000001, 13.25, 10.975, 1.200000000000001)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

	private static final VoxelShape SHAPE_E = Stream.of(
			Block.makeCuboidShape(1.4875000000000025, 2, 1.2625000000000002, 15.4875, 2.45, 15.262499999999998),
			Block.makeCuboidShape(14.587499999999999, 3.2, 2.562500000000001, 15.1125, 11.2, 2.9624999999999995),
			Block.makeCuboidShape(14.5625, 3.25, 13.562499999999998, 15.1125, 11.2, 13.962499999999997),
			Block.makeCuboidShape(14.6875, 3.825, 4.212499999999999, 15.1125, 10.45, 4.612499999999997),
			Block.makeCuboidShape(14.6875, 10.4375, 2.825, 15.1125, 11.2125, 13.799999999999997),
			Block.makeCuboidShape(14.9375, 3.2125, 2.825, 15.1125, 3.9875, 13.799999999999997),
			Block.makeCuboidShape(14.6875, 3.875, 5.7624999999999975, 15.1125, 10.45, 6.462499999999997),
			Block.makeCuboidShape(14.6875, 3.775, 7.412499999999998, 15.1125, 10.75, 7.812499999999998),
			Block.makeCuboidShape(14.6875, 3.925, 8.737499999999997, 15.1125, 10.725, 9.462499999999997),
			Block.makeCuboidShape(14.6875, 3.925, 10.712499999999997, 15.1125, 10.6, 11.112499999999997),
			Block.makeCuboidShape(14.6875, 3.85, 12.062499999999998, 15.1125, 10.525, 12.462499999999997),
			Block.makeCuboidShape(13.0125, 0.025, 13.062499999999998, 13.987499999999999, 2.025, 14.162499999999998),
			Block.makeCuboidShape(13.0125, 0.025, 1.9624999999999995, 13.987499999999999, 2.025, 3.062500000000001),
			Block.makeCuboidShape(1.9875000000000025, 0.025, 1.9624999999999995, 2.962500000000002, 2.025, 3.062500000000001),
			Block.makeCuboidShape(1.9875000000000025, 0.025, 13.062499999999998, 2.962500000000002, 2.025, 14.162499999999998),
			Block.makeCuboidShape(6.512500000000003, 13.325, 6.962499999999997, 6.812500000000002, 23.275, 7.2624999999999975),
			Block.makeCuboidShape(6.512500000000003, 13.325, 9.237499999999997, 6.812500000000002, 23.225, 9.537499999999998),
			Block.makeCuboidShape(6.287500000000003, 23.175, 6.6374999999999975, 9.762500000000003, 23.35, 9.812499999999998),
			Block.makeCuboidShape(6.787500000000003, 23.375, 7.1374999999999975, 9.162500000000001, 23.55, 9.312499999999998),
			Block.makeCuboidShape(9.212500000000002, 13.325, 9.237499999999997, 9.512500000000003, 23.225, 9.537499999999998),
			Block.makeCuboidShape(9.287500000000001, 13.325, 7.237499999999997, 9.412500000000001, 22.55, 9.237499999999997),
			Block.makeCuboidShape(6.587500000000002, 13.325, 7.237499999999997, 6.712500000000002, 22.575, 9.237499999999997),
			Block.makeCuboidShape(6.812500000000002, 13.325, 9.287499999999998, 9.212500000000002, 22.5, 9.412499999999998),
			Block.makeCuboidShape(6.812500000000002, 13.325, 6.987499999999997, 9.212500000000002, 22.475, 7.112499999999997),
			Block.makeCuboidShape(9.212500000000002, 13.325, 6.937499999999998, 9.512500000000003, 23.3, 7.237499999999997),
			Block.makeCuboidShape(1.4875000000000025, 12.5, 1.2625000000000002, 15.4875, 12.95, 15.262499999999998),
			Block.makeCuboidShape(2.587500000000002, 13, 2.2625, 14.3875, 13.35, 14.162499999999998),
			Block.makeCuboidShape(2.162500000000003, 2.5, 2.062500000000001, 14.487499999999999, 12.5, 14.462499999999997),
			Block.makeCuboidShape(14.787499999999998, 3.575, 2.812500000000001, 14.912499999999998, 10.975, 13.937499999999998)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

	private static final VoxelShape SHAPE_W = Stream.of(
			Block.makeCuboidShape(0.5125000000000004, 2, 1.2625000000000002, 14.512499999999998, 2.45, 15.262499999999998),
			Block.makeCuboidShape(0.8875000000000004, 3.2, 2.562500000000001, 1.412500000000001, 11.2, 2.9624999999999995),
			Block.makeCuboidShape(0.8875000000000004, 3.25, 13.562499999999998, 1.4374999999999996, 11.2, 13.962499999999997),
			Block.makeCuboidShape(0.8875000000000004, 3.825, 4.212499999999999, 1.3124999999999996, 10.45, 4.612499999999997),
			Block.makeCuboidShape(0.8875000000000004, 10.4375, 2.825, 1.3124999999999996, 11.2125, 13.799999999999997),
			Block.makeCuboidShape(0.8875000000000004, 3.2125, 2.825, 1.0624999999999993, 3.9875, 13.799999999999997),
			Block.makeCuboidShape(0.8875000000000004, 3.875, 5.7624999999999975, 1.3124999999999996, 10.45, 6.462499999999997),
			Block.makeCuboidShape(0.8875000000000004, 3.775, 7.412499999999998, 1.3124999999999996, 10.75, 7.812499999999998),
			Block.makeCuboidShape(0.8875000000000004, 3.925, 8.737499999999997, 1.3124999999999996, 10.725, 9.462499999999997),
			Block.makeCuboidShape(0.8875000000000004, 3.925, 10.712499999999997, 1.3124999999999996, 10.6, 11.112499999999997),
			Block.makeCuboidShape(0.8875000000000004, 3.85, 12.062499999999998, 1.3124999999999996, 10.525, 12.462499999999997),
			Block.makeCuboidShape(2.012500000000001, 0.025, 13.062499999999998, 2.9875000000000007, 2.025, 14.162499999999998),
			Block.makeCuboidShape(2.012500000000001, 0.025, 1.9624999999999995, 2.9875000000000007, 2.025, 3.062500000000001),
			Block.makeCuboidShape(13.037499999999998, 0.025, 1.9624999999999995, 14.012499999999998, 2.025, 3.062500000000001),
			Block.makeCuboidShape(13.037499999999998, 0.025, 13.062499999999998, 14.012499999999998, 2.025, 14.162499999999998),
			Block.makeCuboidShape(9.187499999999998, 13.325, 6.962499999999997, 9.487499999999997, 23.275, 7.2624999999999975),
			Block.makeCuboidShape(9.187499999999998, 13.325, 9.237499999999997, 9.487499999999997, 23.225, 9.537499999999998),
			Block.makeCuboidShape(6.237499999999997, 23.175, 6.6374999999999975, 9.712499999999997, 23.35, 9.812499999999998),
			Block.makeCuboidShape(6.837499999999999, 23.375, 7.1374999999999975, 9.212499999999997, 23.55, 9.312499999999998),
			Block.makeCuboidShape(6.487499999999997, 13.325, 9.237499999999997, 6.787499999999998, 23.225, 9.537499999999998),
			Block.makeCuboidShape(6.587499999999999, 13.325, 7.237499999999997, 6.712499999999999, 22.55, 9.237499999999997),
			Block.makeCuboidShape(9.287499999999998, 13.325, 7.237499999999997, 9.412499999999998, 22.575, 9.237499999999997),
			Block.makeCuboidShape(6.787499999999998, 13.325, 9.287499999999998, 9.187499999999998, 22.5, 9.412499999999998),
			Block.makeCuboidShape(6.787499999999998, 13.325, 6.987499999999997, 9.187499999999998, 22.475, 7.112499999999997),
			Block.makeCuboidShape(6.487499999999997, 13.325, 6.937499999999998, 6.787499999999998, 23.3, 7.237499999999997),
			Block.makeCuboidShape(0.5125000000000004, 12.5, 1.2625000000000002, 14.512499999999998, 12.95, 15.262499999999998),
			Block.makeCuboidShape(1.6125000000000003, 13, 2.2625, 13.412499999999998, 13.35, 14.162499999999998),
			Block.makeCuboidShape(1.5125000000000006, 2.5, 2.062500000000001, 13.837499999999997, 12.5, 14.462499999999997),
			Block.makeCuboidShape(1.0875000000000015, 3.575, 2.812500000000001, 1.2125000000000017, 10.975, 13.937499999999998)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

	private static final VoxelShape SHAPE_S = Stream.of(
			Block.makeCuboidShape(0.75, 2, 1.5, 14.75, 2.45, 15.5),
			Block.makeCuboidShape(13.05, 3.2, 14.6, 13.45, 11.2, 15.125),
			Block.makeCuboidShape(2.05, 3.25, 14.575, 2.45, 11.2, 15.125),
			Block.makeCuboidShape(11.4, 3.825, 14.7, 11.8, 10.45, 15.125),
			Block.makeCuboidShape(2.2125, 10.4375, 14.7, 13.1875, 11.2125, 15.125),
			Block.makeCuboidShape(2.2125, 3.2125, 14.95, 13.1875, 3.9875, 15.125),
			Block.makeCuboidShape(9.55, 3.875, 14.7, 10.25, 10.45, 15.125),
			Block.makeCuboidShape(8.2, 3.775, 14.7, 8.6, 10.75, 15.125),
			Block.makeCuboidShape(6.55, 3.925, 14.7, 7.275, 10.725, 15.125),
			Block.makeCuboidShape(4.9, 3.925, 14.7, 5.3, 10.6, 15.125),
			Block.makeCuboidShape(3.55, 3.85, 14.7, 3.95, 10.525, 15.125),
			Block.makeCuboidShape(1.85, 0.025, 13.025, 2.95, 2.025, 14),
			Block.makeCuboidShape(12.95, 0.025, 13.025, 14.05, 2.025, 14),
			Block.makeCuboidShape(12.95, 0.025, 2, 14.05, 2.025, 2.9749999999999996),
			Block.makeCuboidShape(1.85, 0.025, 2, 2.95, 2.025, 2.9749999999999996),
			Block.makeCuboidShape(8.75, 13.325, 6.525, 9.05, 23.275, 6.824999999999999),
			Block.makeCuboidShape(6.475, 13.325, 6.525, 6.775, 23.225, 6.824999999999999),
			Block.makeCuboidShape(6.2, 23.175, 6.300000000000001, 9.375, 23.35, 9.775),
			Block.makeCuboidShape(6.7, 23.375, 6.800000000000001, 8.875, 23.55, 9.175),
			Block.makeCuboidShape(6.475, 13.325, 9.225, 6.775, 23.225, 9.525),
			Block.makeCuboidShape(6.775, 13.325, 9.3, 8.775, 22.55, 9.425),
			Block.makeCuboidShape(6.775, 13.325, 6.6, 8.775, 22.575, 6.725),
			Block.makeCuboidShape(6.6, 13.325, 6.824999999999999, 6.725, 22.5, 9.225),
			Block.makeCuboidShape(8.9, 13.325, 6.824999999999999, 9.025, 22.475, 9.225),
			Block.makeCuboidShape(8.775, 13.325, 9.225, 9.075, 23.3, 9.525),
			Block.makeCuboidShape(0.75, 12.5, 1.5, 14.75, 12.95, 15.5),
			Block.makeCuboidShape(1.85, 13, 2.5999999999999996, 13.75, 13.35, 14.4),
			Block.makeCuboidShape(1.55, 2.5, 2.1750000000000007, 13.95, 12.5, 14.5),
			Block.makeCuboidShape(2.075, 3.575, 14.8, 13.2, 10.975, 14.925)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

	

	public WitchOven(Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(LIT, false));
		
		
	}
	
	@Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }
	@OnlyIn(Dist.CLIENT)
	@Override
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) 
	{
		if (stateIn.get(LIT)) 
		{
			double x = pos.getX() + 0.5D;
			double y = pos.getY();
			double z = pos.getZ() + 0.5D;
			if (rand.nextDouble() < 0.1D) 
			{
			   worldIn.playSound(x, y, z, SoundEvents.BLOCK_BLASTFURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
			}

			Direction direction = (Direction)stateIn.get(FACING);
			Direction.Axis axis = direction.getAxis();
			double defOffset = rand.nextDouble() * 0.6D - 0.3D;
			double offX = axis == Direction.Axis.X ? direction.getXOffset() * 0.52D : defOffset;
			double offY = rand.nextDouble() * 9.0D / 16.0D;
			double offZ = axis == Direction.Axis.Z ? direction.getZOffset() * 0.52D : defOffset;
			worldIn.addParticle(ParticleTypes.SMOKE, x + offX, y + offY, z + offZ, 0.0D, 0.0D, 0.0D);
			
		}
	}
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit)
	{
		if (worldIn.isRemote) 
		{
			return ActionResultType.SUCCESS;
		} 
		else
		{
			this.interactWith(worldIn, pos, player);
			return ActionResultType.CONSUME;
		}
	}
	
	protected void interactWith(World worldIn, BlockPos pos, PlayerEntity player) 
	{
		TileEntity tileEntity = worldIn.getTileEntity(pos);
		if (tileEntity instanceof WitchOvenTileEntity) 
		{
			NetworkHooks.openGui((ServerPlayerEntity)player, (WitchOvenTileEntity)tileEntity);
		}
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) 
	{
		if (!state.isIn((ITag<Block>) newState.getBlock()))
		{
			TileEntity tileentity = worldIn.getTileEntity(pos);
	        if (tileentity instanceof WitchOvenTileEntity) 
	        {
	        	InventoryHelper.dropInventoryItems(worldIn, pos, (WitchOvenTileEntity)tileentity);
	             //((WitchOvenTileEntity)tileentity).grantStoredRecipeExperience(worldIn, Vector3d.copyCentered(pos));
	             worldIn.updateComparatorOutputLevel(pos, this);
	          }

	          super.onReplaced(state, worldIn, pos, newState, isMoving);
	       }
	}
	

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		switch (state.get(FACING)) {
		case EAST:
			return SHAPE_E;
		case SOUTH:
			return SHAPE_S;
		case WEST:
			return SHAPE_W;
		default:
			return SHAPE_N;
		}
	}
    
	@Override
	public boolean hasTileEntity(BlockState state) 
	{
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) 
	{
		return TileEntityTypesInit.WITCH_OVEN.get().create();
	}
	
	@Override
	public boolean hasComparatorInputOverride(BlockState state) 
	{
		return true;
	}
	
	@Override
	public int getComparatorInputOverride(BlockState blockState, World worldIn, BlockPos pos) 
	{
		return Container.calcRedstone(worldIn.getTileEntity(pos));
	}
	
@Override
public BlockState rotate(BlockState state, Rotation rot) {
    return state.with(FACING, rot.rotate(state.get(FACING)));
}

@SuppressWarnings("deprecation")
@Override
public BlockState mirror(BlockState state, Mirror mirrorIn) 
{
	return state.rotate(mirrorIn.toRotation(state.get(FACING)));
}


@Override
protected void fillStateContainer(Builder<Block, BlockState> builder) 
{
	builder.add(FACING, LIT);
}

}
