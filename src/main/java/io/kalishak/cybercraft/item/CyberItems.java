package io.kalishak.cybercraft.item;

import io.kalishak.cybercraft.Cybercraft;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CyberItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Cybercraft.MOD_ID);

    public static final DeferredItem<Item> SANDEVISTAN = ITEMS.registerSimpleItem("sandevistan");
    public static final DeferredItem<Item> MILITECH_PARALINE_MK1 = ITEMS.registerSimpleItem("militech_paraline_mk1");

    public static void init(IEventBus bus) {
        ITEMS.register(bus);
    }
}
