package io.kalishak.cybercraft.block;

import io.kalishak.cybercraft.Cybercraft;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CyberBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Cybercraft.MOD_ID);

    public static void init(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
