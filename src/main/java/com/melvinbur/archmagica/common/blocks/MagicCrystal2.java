package com.melvinbur.archmagica.common.blocks;



import java.util.stream.Stream;

import com.melvinbur.archmagica.common.handler.RenderLayerHandler;
import com.melvinbur.archmagica.common.handler.RenderLayerHandler.RenderTypeSkeleton;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;



public class MagicCrystal2 extends BaseHorizontalBlock  {


	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;


	private static final VoxelShape SHAPE_N = Stream.of(
			Block.makeCuboidShape(5.949999999999999, 15.649999999999991, 0.9250000000000007, 9.575, 24.050000000000022, 4.800000000000001),
			Block.makeCuboidShape(3.201012907149255, 9.162505161577565, 5.925, 5.226012907149258, 12.812505161577574, 8.175),
			Block.makeCuboidShape(6.0500000000000025, 8.875000000000002, 10.350000000000017, 8.925000000000002, 12.750000000000002, 13.150000000000002),
			Block.makeCuboidShape(13.160267071404043, 3.144099419296955, 5.95, 16.960267071404076, 5.044099419296954, 8.100000000000001),
			Block.makeCuboidShape(5.549999999999999, 1.05, 0.4000000000000008, 10.024999999999999, 15.75, 5.300000000000001),
			Block.makeCuboidShape(5.650000000000002, -3.9250000000000007, 9.850000000000017, 9.300000000000002, 8.975000000000001, 13.575000000000001),
			Block.makeCuboidShape(2.951012907149255, 1.4625051615775657, 5.65, 5.501012907149258, 9.187505161577565, 8.5),
			Block.makeCuboidShape(5.86026707140405, 2.819099419296955, 5.65, 13.160267071404048, 5.369099419296954, 8.5)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

	private static final VoxelShape SHAPE_E = Stream.of(
			Block.makeCuboidShape(1.7250000000000016, 15.649999999999991, 6.724999999999994, 5.600000000000007, 24.050000000000022, 10.350000000000001),
			Block.makeCuboidShape(6.725, 9.162505161577565, 11.073987092850743, 8.975000000000007, 12.812505161577574, 13.098987092850747),
			Block.makeCuboidShape(11.150000000000018, 8.875000000000002, 7.3749999999999964, 13.950000000000006, 12.750000000000002, 10.25),
			Block.makeCuboidShape(6.750000000000005, 3.144099419296955, -0.6602670714040784, 8.900000000000004, 5.044099419296954, 3.1397329285959543),
			Block.makeCuboidShape(1.199999999999996, 1.05, 6.274999999999999, 6.100000000000007, 15.75, 10.75),
			Block.makeCuboidShape(10.650000000000018, -3.9250000000000007, 6.999999999999993, 14.375000000000004, 8.975000000000001, 10.649999999999999),
			Block.makeCuboidShape(6.450000000000001, 1.4625051615775657, 10.798987092850744, 9.300000000000002, 9.187505161577565, 13.348987092850745),
			Block.makeCuboidShape(6.450000000000001, 2.819099419296955, 3.139732928595947, 9.300000000000002, 5.369099419296954, 10.439732928595951)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

	private static final VoxelShape SHAPE_W = Stream.of(
			Block.makeCuboidShape(10.399999999999993, 15.649999999999991, 6.724999999999994, 14.274999999999999, 24.050000000000022, 10.350000000000001),
			Block.makeCuboidShape(7.024999999999993, 9.162505161577565, 11.073987092850743, 9.275, 12.812505161577574, 13.098987092850747),
			Block.makeCuboidShape(2.0499999999999936, 8.875000000000002, 7.3749999999999964, 4.849999999999982, 12.750000000000002, 10.25),
			Block.makeCuboidShape(7.099999999999996, 3.144099419296955, -0.6602670714040784, 9.249999999999995, 5.044099419296954, 3.1397329285959543),
			Block.makeCuboidShape(9.899999999999993, 1.05, 6.274999999999999, 14.800000000000004, 15.75, 10.75),
			Block.makeCuboidShape(1.6249999999999964, -3.9250000000000007, 6.999999999999993, 5.349999999999982, 8.975000000000001, 10.649999999999999),
			Block.makeCuboidShape(6.6999999999999975, 1.4625051615775657, 10.798987092850744, 9.549999999999999, 9.187505161577565, 13.348987092850745),
			Block.makeCuboidShape(6.6999999999999975, 2.819099419296955, 3.139732928595947, 9.549999999999999, 5.369099419296954, 10.439732928595951)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

	private static final VoxelShape SHAPE_S = Stream.of(
			Block.makeCuboidShape(5.949999999999999, 15.649999999999991, 11.2, 9.575, 24.050000000000022, 15.075),
			Block.makeCuboidShape(3.201012907149255, 9.162505161577565, 7.824999999999999, 5.226012907149258, 12.812505161577574, 10.075),
			Block.makeCuboidShape(6.0500000000000025, 8.875000000000002, 2.849999999999998, 8.925000000000002, 12.750000000000002, 5.649999999999983),
			Block.makeCuboidShape(13.160267071404043, 3.144099419296955, 7.899999999999999, 16.960267071404076, 5.044099419296954, 10.05),
			Block.makeCuboidShape(5.549999999999999, 1.05, 10.7, 10.024999999999999, 15.75, 15.6),
			Block.makeCuboidShape(5.650000000000002, -3.9250000000000007, 2.424999999999999, 9.300000000000002, 8.975000000000001, 6.149999999999983),
			Block.makeCuboidShape(2.951012907149255, 1.4625051615775657, 7.5, 5.501012907149258, 9.187505161577565, 10.35),
			Block.makeCuboidShape(5.86026707140405, 2.819099419296955, 7.5, 13.160267071404048, 5.369099419296954, 10.35)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

	

	public MagicCrystal2(Properties properties) {
		super(properties);
		RenderLayerHandler.setRenderType(this, RenderTypeSkeleton.TRANSLUCENT);
		
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
public BlockState mirror(BlockState state, Mirror mirrorIn) {
    return state.rotate(mirrorIn.toRotation(state.get(FACING)));
     }
}

