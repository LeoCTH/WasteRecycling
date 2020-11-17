package com.leocth.wasterecycling;

import net.fabricmc.api.ModInitializer;


public class WasteRecycling implements ModInitializer {

    // public static final (psf)
    // 公开，静态（不与某个特定物体绑定）并且不可修改
    // 可视为该类提供的常量
    public static final String MODID = "wasterecycling";

    // 当模组加载时会调用此方法
    //（客户端和服务端皆会调用）
    // 在这里注册物品、方块、流体、实体、等等等
    @Override
    public void onInitialize() {
        WRItems.register(); // 注册所有物品
    }
}
