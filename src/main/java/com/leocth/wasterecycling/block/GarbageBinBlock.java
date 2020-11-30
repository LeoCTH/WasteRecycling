package com.leocth.wasterecycling.block;

import com.leocth.wasterecycling.block.entity.GarbageBinBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

// 垃圾娄方块类
public class GarbageBinBlock extends Block implements BlockEntityProvider {

    public GarbageBinBlock(Settings settings) {
        super(settings);
    }

    @SuppressWarnings("deprecation") // 无视警告（why mojang why）
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        // 乱写的
        // but it works™
        if (!world.isClient) {
            BlockEntity be = world.getBlockEntity(pos);
            if (be instanceof GarbageBinBlockEntity) {
                // java 15 wen
                GarbageBinBlockEntity gbe = (GarbageBinBlockEntity) be;
                if (player.isSneaking()) {
                    ItemStack stack = gbe.removeItem();
                    if (!stack.isEmpty()) {
                        player.giveItemStack(stack);
                        return ActionResult.SUCCESS;
                    }
                }
                else {
                    ItemStack stackInHand = player.getStackInHand(hand);
                    if (!stackInHand.isEmpty() && gbe.addItem(stackInHand)) {
                        player.setStackInHand(hand, ItemStack.EMPTY);
                        return ActionResult.SUCCESS;
                    }
                    else {
                        return ActionResult.CONSUME;
                    }
                }
            }
            return ActionResult.PASS;
        }
        return ActionResult.SUCCESS;
    }

    // 所有继承BlockEntityProvider的类都需要返回一个新的方块实体（BlockEntity)
    @Override
    public @Nullable BlockEntity createBlockEntity(BlockView world) {
        return new GarbageBinBlockEntity();
    }

}
