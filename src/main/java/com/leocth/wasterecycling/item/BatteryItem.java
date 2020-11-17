package com.leocth.wasterecycling.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

// BatteryItem 继承自 Item
// 即 BatteryItem 是 Item 的子类

// 所有 BatteryItem 都是 Item，但不是所有 Item 都是 BatteryItem
// (is-a关系)
public class BatteryItem extends Item {

    // 构造方法
    // 需要一个Item.Settings对象创建一个BatteryItem对象
    public BatteryItem(Settings settings) {
        // 由于Item没有默认的构造方法，所以你的构造方法中
        // 必须要给父类（Item）上递它所想要的参数
        super(settings);
    }

    // 右键使用的事件
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient) // 因为MC独特的架构，我们需要保证是否在服务端运行，以免二次触发
            // 当然你在这里加一点客户端显示代码也是可以的
            return super.use(world, user, hand);
        // 给玩家发送消息 - TranslatableText能够本地化，使得各语言的翻译各有不同
        // actionBar参数决定了是否在Action Bar（即玩家血量上方会显示文字的区域）上显示文字
        // 如果为真（true）则在Action Bar上渲染
        user.sendMessage(new TranslatableText("text.wasterecycling.battery_ded"), true);

        // (Typed-)ActionResult代表了事件执行的成功程度
        // 实际上被用于显示和事件处理
        // success会标记为成功，并使玩家作出挥手动作
        // consume也会标记为成功，但不会使玩家作出动作
        // pass代表无事发生，并继续执行其他事件
        // 而fail代表事件执行失败，并停止执行其他事件
        return TypedActionResult.success(user.getStackInHand(hand));
    }
}
