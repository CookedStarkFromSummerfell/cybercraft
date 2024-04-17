package io.kalishak.cybercraft.item;

import io.kalishak.cybercraft.Cybercraft;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CyberItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Cybercraft.MOD_ID);

    public static void init(IEventBus bus) {
        ITEMS.register(bus);
    }
}
