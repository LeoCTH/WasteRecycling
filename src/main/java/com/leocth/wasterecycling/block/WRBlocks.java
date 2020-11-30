package com.leocth.wasterecycling.block;

import com.leocth.wasterecycling.WasteRecycling;
import com.leocth.wasterecycling.block.entity.GarbageBinBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.util.registry.Registry;

public class WRBlocks {

    public static Block GARBAGE_BLOCK = new Block(FabricBlockSettings.of(Material.AGGREGATE));
    public static Block GARBAGE_BIN = new GarbageBinBlock(FabricBlockSettings.copyOf(Blocks.BARREL));

    public static void register() {
        Registry.register(Registry.BLOCK, WasteRecycling.id("garbage_block"), GARBAGE_BLOCK);
        Registry.register(Registry.BLOCK, WasteRecycling.id("garbage_bin"), GARBAGE_BIN);

        Registry.register(Registry.BLOCK_ENTITY_TYPE, WasteRecycling.id("garbage_bin"), GarbageBinBlockEntity.TYPE);
    }
}
