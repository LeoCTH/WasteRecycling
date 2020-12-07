package com.leocth.wasterecycling.block.entity;

import com.leocth.wasterecycling.block.WRBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.collection.DefaultedList;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class GarbageBinBlockEntity extends BlockEntity {

    public static final BlockEntityType<GarbageBinBlockEntity> TYPE;
    private int currentItems = 0;
    private static final int MAX_CAPACITY = 10;
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(MAX_CAPACITY, ItemStack.EMPTY);

    public GarbageBinBlockEntity() {
        super(TYPE);
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        Inventories.fromTag(tag, inventory);
        currentItems = tag.getInt("currentItems");
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);
        Inventories.toTag(tag, inventory);
        tag.putInt("currentItems", currentItems);
        return tag;
    }

    // 添加物品
    public boolean addItem(ItemStack stack) {
        if (currentItems >= MAX_CAPACITY) {
            currentItems = MAX_CAPACITY;
            return false;
        }
        inventory.set(currentItems, stack);
        currentItems++;
        return true;
    }

    // 移除物品
    public ItemStack removeItem() {
        if (currentItems >= 0) {
            currentItems--;
            ItemStack stack = inventory.get(currentItems);
            inventory.set(currentItems, ItemStack.EMPTY);
            return stack;
        }
        else {
            return ItemStack.EMPTY;
        }
        //TODO! 练习
        //* 判断目前存放的物品数量（currentItems）是否*不小于*最小数量（0）
        //* * 如果不是，返回空物品堆（ItemStack.EMPTY）
        //* * 如果是，将物品数量减1 返回物品栏中位于currentItems的物品堆，并去除（remove）该物品堆
    }

    static {
        TYPE = BlockEntityType.Builder.create(GarbageBinBlockEntity::new, WRBlocks.GARBAGE_BIN).build(null);
    }
}
