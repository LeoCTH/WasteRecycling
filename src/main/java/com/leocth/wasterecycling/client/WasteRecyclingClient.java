package com.leocth.wasterecycling.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class WasteRecyclingClient implements ClientModInitializer {
    /// 当*客户端*模组加载时会调用此方法
    /// 在这里注册一切与渲染、快捷键、界面等*只在客户端存在也只与客户端有关的*东西！
    @Override
    public void onInitializeClient() {

    }
}
