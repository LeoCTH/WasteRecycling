package com.leocth.wasterecycling.block;

import com.leocth.wasterecycling.WasteRecycling;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.util.registry.Registry;

public class WRBlocks {

    public static Block GARBAGE_BLOCK = new Block(FabricBlockSettings.of(Material.AGGREGATE));

    public static void register() {
        Registry.register(Registry.BLOCK, WasteRecycling.id("garbage_block"), GARBAGE_BLOCK);
    }
}
