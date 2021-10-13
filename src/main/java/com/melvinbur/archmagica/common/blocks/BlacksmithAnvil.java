package com.melvinbur.archmagica.common.blocks;



import java.util.stream.Stream;

import com.melvinbur.archmagica.common.container.BlacksmithAnvilContainer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CraftingTableBlock;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;


public class BlacksmithAnvil extends CraftingTableBlock {
	private static final ITextComponent CONTAINER_NAME =
			new TranslationTextComponent("");

	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;


	private static final VoxelShape SHAPE_N = Stream.of(
			Block.makeCuboidShape(17.000000000000004, 8.1, 6.6000000000000005, 19.000000000000004, 10.1, 8.6),
			Block.makeCuboidShape(15, 7.1, 5.6000000000000005, 17.000000000000004, 10.1, 9.6),
			Block.makeCuboidShape(13, 6.1, 4.6000000000000005, 15, 10.1, 10.6),
			Block.makeCuboidShape(3, 5.1, 3.6, 13, 10.1, 11.6),
			Block.makeCuboidShape(4, 4.1, 4.6000000000000005, 11, 5.1, 10.6),
			Block.makeCuboidShape(4.999999999999999, 1.1, 5.6000000000000005, 10, 4.1, 9.6),
			Block.makeCuboidShape(2.95, 0.1, 2.9499999999999997, 13, 1.1, 12.35)
	).reduce((v1, v2) -> {
		return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
	}).get();

	private static final VoxelShape SHAPE_E = Stream.of(
			Block.makeCuboidShape(7.1999999999999975, 8.1, -3.000000000000025, 9.2, 10.1, -1.0000000000000036),
			Block.makeCuboidShape(6.1999999999999975, 7.1, -1.0000000000000036, 10.2, 10.1, 1.000000000000007),
			Block.makeCuboidShape(5.1999999999999975, 6.1, 1.000000000000007, 11.2, 10.1, 3.000000000000007),
			Block.makeCuboidShape(4.199999999999999, 5.1, 3.000000000000007, 12.199999999999998, 10.1, 13),
			Block.makeCuboidShape(5.1999999999999975, 4.1, 5.000000000000007, 11.2, 5.1, 12),
			Block.makeCuboidShape(6.1999999999999975, 1.1, 6.000000000000007, 10.2, 4.1, 11),
			Block.makeCuboidShape(3.5499999999999994, 0.1, 3.000000000000007, 12.949999999999998, 1.1, 13.05)
	).reduce((v1, v2) -> {
		return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
	}).get();

	private static final VoxelShape SHAPE_W = Stream.of(
			Block.makeCuboidShape(7.299999999999999, 8.1, 17.000000000000004, 9.3, 10.1, 19.000000000000025),
			Block.makeCuboidShape(6.299999999999999, 7.1, 14.999999999999993, 10.3, 10.1, 17.000000000000004),
			Block.makeCuboidShape(5.299999999999999, 6.1, 12.999999999999993, 11.3, 10.1, 14.999999999999993),
			Block.makeCuboidShape(4.3, 5.1, 2.9999999999999996, 12.3, 10.1, 12.999999999999993),
			Block.makeCuboidShape(5.299999999999999, 4.1, 4, 11.3, 5.1, 10.999999999999993),
			Block.makeCuboidShape(6.299999999999999, 1.1, 4.999999999999999, 10.3, 4.1, 9.999999999999993),
			Block.makeCuboidShape(3.55, 0.1, 2.9499999999999997, 12.950000000000001, 1.1, 12.999999999999993)
	).reduce((v1, v2) -> {
		return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
	}).get();

	private static final VoxelShape SHAPE_S = Stream.of(
			Block.makeCuboidShape(-3.0000000000000036, 8.1, 6.6000000000000005, -1.0000000000000036, 10.1, 8.6),
			Block.makeCuboidShape(-1.0000000000000036, 7.1, 5.6000000000000005, 1, 10.1, 9.6),
			Block.makeCuboidShape(1, 6.1, 4.6000000000000005, 3, 10.1, 10.6),
			Block.makeCuboidShape(3, 5.1, 3.6, 13, 10.1, 11.6),
			Block.makeCuboidShape(5, 4.1, 4.6000000000000005, 12, 5.1, 10.6),
			Block.makeCuboidShape(6, 1.1, 5.6000000000000005, 11, 4.1, 9.6),
			Block.makeCuboidShape(3, 0.1, 2.9499999999999997, 13.05, 1.1, 12.35)
	).reduce((v1, v2) -> {
		return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
	}).get();


	public BlacksmithAnvil(Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));


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
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
	{
		builder.add(FACING);
	}






	public INamedContainerProvider getContainer(BlockState state, World worldIn, BlockPos pos) {
		return new SimpleNamedContainerProvider((id, inventory, player) -> new
				BlacksmithAnvilContainer(id, inventory, IWorldPosCallable.of(worldIn, pos)), CONTAINER_NAME);
	}



}