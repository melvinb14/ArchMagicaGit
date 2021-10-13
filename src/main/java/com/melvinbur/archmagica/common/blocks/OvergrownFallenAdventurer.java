package com.melvinbur.archmagica.common.blocks;

import com.melvinbur.archmagica.common.handler.RenderLayerHandler;
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

import java.util.stream.Stream;

public class OvergrownFallenAdventurer extends BaseHorizontalBlock{
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(15.449999999999998, 0, 3.4749999999999996, 16.800000000000004, 1.625, 10.899999999999999),
            Block.makeCuboidShape(4, 3, 9, 6, 4, 10),
            Block.makeCuboidShape(3.9000000000000004, 8.604228440844963e-16, 18.800000000000054, 11.7, 6.949999999999994, 26.000000000000068),
            Block.makeCuboidShape(5, 4, 6, 7, 5, 7),
            Block.makeCuboidShape(5.254, 5.699999999999999, 12.450000000000001, 8.673999999999998, 6.84, 13.590000000000005),
            Block.makeCuboidShape(8.673999999999998, 5.699999999999999, 13.590000000000005, 12.093999999999998, 6.84, 14.73),
            Block.makeCuboidShape(5, 5, 3, 8, 6, 4),
            Block.makeCuboidShape(8, 5, 4, 11, 6, 5),
            Block.makeCuboidShape(9, 4, 7, 11, 5, 8),
            Block.makeCuboidShape(9, 4, 9, 11, 5, 10),
            Block.makeCuboidShape(-1.5000000000000004, 9.71445146547012e-16, 10.299999999999995, -0.1750000000000016, 7.625, 11.899999999999995),
            Block.makeCuboidShape(3, 0, 9, 4, 3, 10),
            Block.makeCuboidShape(4, 0, 6, 5, 4, 7),
            Block.makeCuboidShape(4.114000000000001, 0, 12.450000000000001, 5.254, 5.699999999999999, 13.590000000000005),
            Block.makeCuboidShape(4, 0, 3, 5, 5, 4),
            Block.makeCuboidShape(11, 0, 9, 12, 4, 10),
            Block.makeCuboidShape(12.093999999999998, 0, 13.590000000000005, 13.233999999999996, 5.699999999999999, 14.73),
            Block.makeCuboidShape(11, 0, 7, 12, 4, 8),
            Block.makeCuboidShape(11, 0, 4, 12, 5, 5)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(4.799999999999999, 0, 16.3, 12.224999999999998, 1.625, 17.650000000000006),
            Block.makeCuboidShape(5.6999999999999975, 3, 4.850000000000003, 6.699999999999996, 4, 6.850000000000003),
            Block.makeCuboidShape(-10.300000000000068, 8.604228440844963e-16, 4.7500000000000036, -3.1000000000000565, 6.949999999999994, 12.550000000000002),
            Block.makeCuboidShape(8.699999999999996, 4, 5.850000000000003, 9.699999999999996, 5, 7.850000000000003),
            Block.makeCuboidShape(2.1099999999999923, 5.699999999999999, 6.104000000000003, 3.2499999999999964, 6.84, 9.524000000000001),
            Block.makeCuboidShape(0.9699999999999971, 5.699999999999999, 9.524000000000001, 2.1099999999999923, 6.84, 12.944),
            Block.makeCuboidShape(11.699999999999996, 5, 5.850000000000003, 12.699999999999996, 6, 8.850000000000003),
            Block.makeCuboidShape(10.699999999999996, 5, 8.850000000000003, 11.699999999999996, 6, 11.850000000000003),
            Block.makeCuboidShape(7.699999999999996, 4, 9.850000000000003, 8.699999999999996, 5, 11.850000000000003),
            Block.makeCuboidShape(5.6999999999999975, 4, 9.850000000000003, 6.699999999999996, 5, 11.850000000000003),
            Block.makeCuboidShape(3.8000000000000025, 9.71445146547012e-16, -0.6499999999999968, 5.400000000000002, 7.625, 0.6750000000000025),
            Block.makeCuboidShape(5.6999999999999975, 0, 3.850000000000003, 6.699999999999996, 3, 4.850000000000003),
            Block.makeCuboidShape(8.699999999999996, 0, 4.850000000000003, 9.699999999999996, 4, 5.850000000000003),
            Block.makeCuboidShape(2.1099999999999923, 0, 4.964000000000004, 3.2499999999999964, 5.699999999999999, 6.104000000000003),
            Block.makeCuboidShape(11.699999999999996, 0, 4.850000000000003, 12.699999999999996, 5, 5.850000000000003),
            Block.makeCuboidShape(5.6999999999999975, 0, 11.850000000000003, 6.699999999999996, 4, 12.850000000000003),
            Block.makeCuboidShape(0.9699999999999971, 0, 12.944, 2.1099999999999923, 5.699999999999999, 14.084),
            Block.makeCuboidShape(7.699999999999996, 0, 11.850000000000003, 8.699999999999996, 4, 12.850000000000003),
            Block.makeCuboidShape(10.699999999999996, 0, 11.850000000000003, 11.699999999999996, 5, 12.850000000000003)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(3.775000000000002, 0, 16.3, 11.200000000000001, 1.625, 17.650000000000006),
            Block.makeCuboidShape(9.300000000000004, 3, 4.850000000000003, 10.300000000000002, 4, 6.850000000000003),
            Block.makeCuboidShape(19.10000000000006, 8.604228440844963e-16, 4.7500000000000036, 26.300000000000068, 6.949999999999994, 12.550000000000002),
            Block.makeCuboidShape(6.300000000000004, 4, 5.850000000000003, 7.300000000000004, 5, 7.850000000000003),
            Block.makeCuboidShape(12.750000000000004, 5.699999999999999, 6.104000000000003, 13.890000000000008, 6.84, 9.524000000000001),
            Block.makeCuboidShape(13.890000000000008, 5.699999999999999, 9.524000000000001, 15.030000000000003, 6.84, 12.944),
            Block.makeCuboidShape(3.3000000000000043, 5, 5.850000000000003, 4.300000000000004, 6, 8.850000000000003),
            Block.makeCuboidShape(4.300000000000004, 5, 8.850000000000003, 5.300000000000004, 6, 11.850000000000003),
            Block.makeCuboidShape(7.300000000000004, 4, 9.850000000000003, 8.300000000000004, 5, 11.850000000000003),
            Block.makeCuboidShape(9.300000000000004, 4, 9.850000000000003, 10.300000000000002, 5, 11.850000000000003),
            Block.makeCuboidShape(10.599999999999998, 9.71445146547012e-16, -0.6499999999999968, 12.199999999999998, 7.625, 0.6750000000000025),
            Block.makeCuboidShape(9.300000000000004, 0, 3.850000000000003, 10.300000000000002, 3, 4.850000000000003),
            Block.makeCuboidShape(6.300000000000004, 0, 4.850000000000003, 7.300000000000004, 4, 5.850000000000003),
            Block.makeCuboidShape(12.750000000000004, 0, 4.964000000000004, 13.890000000000008, 5.699999999999999, 6.104000000000003),
            Block.makeCuboidShape(3.3000000000000043, 0, 4.850000000000003, 4.300000000000004, 5, 5.850000000000003),
            Block.makeCuboidShape(9.300000000000004, 0, 11.850000000000003, 10.300000000000002, 4, 12.850000000000003),
            Block.makeCuboidShape(13.890000000000008, 0, 12.944, 15.030000000000003, 5.699999999999999, 14.084),
            Block.makeCuboidShape(7.300000000000004, 0, 11.850000000000003, 8.300000000000004, 4, 12.850000000000003),
            Block.makeCuboidShape(4.300000000000004, 0, 11.850000000000003, 5.300000000000004, 5, 12.850000000000003)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(15.449999999999998, 0, 5.100000000000001, 16.800000000000004, 1.625, 12.525),
            Block.makeCuboidShape(4, 3, 6, 6, 4, 7),
            Block.makeCuboidShape(3.9000000000000004, 8.604228440844963e-16, -10.000000000000068, 11.7, 6.949999999999994, -2.800000000000054),
            Block.makeCuboidShape(5, 4, 9, 7, 5, 10),
            Block.makeCuboidShape(5.254, 5.699999999999999, 2.409999999999995, 8.673999999999998, 6.84, 3.549999999999999),
            Block.makeCuboidShape(8.673999999999998, 5.699999999999999, 1.2699999999999996, 12.093999999999998, 6.84, 2.409999999999995),
            Block.makeCuboidShape(5, 5, 12, 8, 6, 13),
            Block.makeCuboidShape(8, 5, 11, 11, 6, 12),
            Block.makeCuboidShape(9, 4, 8, 11, 5, 9),
            Block.makeCuboidShape(9, 4, 6, 11, 5, 7),
            Block.makeCuboidShape(-1.5000000000000004, 9.71445146547012e-16, 4.100000000000005, -0.1750000000000016, 7.625, 5.700000000000005),
            Block.makeCuboidShape(3, 0, 6, 4, 3, 7),
            Block.makeCuboidShape(4, 0, 9, 5, 4, 10),
            Block.makeCuboidShape(4.114000000000001, 0, 2.409999999999995, 5.254, 5.699999999999999, 3.549999999999999),
            Block.makeCuboidShape(4, 0, 12, 5, 5, 13),
            Block.makeCuboidShape(11, 0, 6, 12, 4, 7),
            Block.makeCuboidShape(12.093999999999998, 0, 1.2699999999999996, 13.233999999999996, 5.699999999999999, 2.409999999999995),
            Block.makeCuboidShape(11, 0, 8, 12, 4, 9),
            Block.makeCuboidShape(11, 0, 11, 12, 5, 12)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();








    public OvergrownFallenAdventurer(Properties properties) {
        super(properties);

        RenderLayerHandler.setRenderType(this, RenderLayerHandler.RenderTypeSkeleton.CUTOUT);

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

