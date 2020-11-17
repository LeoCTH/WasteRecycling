package com.leocth.wasterecycling;

import com.leocth.wasterecycling.item.BatteryItem;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

// 存放所有物品的类
// 知识点：
// static（静态）成员和方法 - 无需对象即可
// 建造者（Builder）

// Java 的可视域（简化）
// private（私有）- 只有你可以看见
// protected（保护）- 只有你和你的子类/子对象可以看到
// （默认 aka 包保护/私有）- 只有你包内的类可以看到（可能不包括子类）
// public - 所有人都可以看见
public class WRItems {

    // 物品组
    public static final ItemGroup GROUP;

    // 新建并注册一个物品
    // 注Item.Settings的诸多用法
    public static Item COTTON_BALL;
    public static Item APPLE_CORE;
    public static Item BATTERY;
    public static Item SODA_CAN;



    // 公开且静态的方法
    // WRItems.register(); √
    public static void register() {
        registerItem(COTTON_BALL, "cotton_ball");
        registerItem(APPLE_CORE, "apple_core");
        registerItem(BATTERY, "battery");
        registerItem(SODA_CAN, "soda_can");
    }

    // 私有方法
    // 从别的类中调用WRItems.registerItem(...) <---- 报错！
    private static void registerItem(Item item, String id) {
        // 调用静态方法 Registry.register（注册）
        Registry.register(Registry.ITEM, id(id), item);
    }

    // 帮手方法
    // 此处作为创建一个新Identifier（如minecraft:potato）的便捷方式
    public static Identifier id(String path) {
        return new Identifier(WasteRecycling.MODID, path);
    }

    static {
        GROUP = FabricItemGroupBuilder                 // Fabric的贴心扩展
                    .build(
                            id("waste"),                // wasterecycling:waste
                            () -> new ItemStack(APPLE_CORE)); // 将图标物品设成苹果核

        COTTON_BALL = new Item(new Item.Settings().group(GROUP));
        APPLE_CORE = new Item(new Item.Settings().food(FoodComponents.POISONOUS_POTATO).group(GROUP));
        BATTERY = new BatteryItem(new Item.Settings().maxDamage(-100000).group(GROUP));
        SODA_CAN = new Item(new Item.Settings().maxCount(3).group(GROUP));
    }
}
