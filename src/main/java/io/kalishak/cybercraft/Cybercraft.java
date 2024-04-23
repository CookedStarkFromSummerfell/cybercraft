package io.kalishak.cybercraft;

import io.kalishak.cybercraft.block.CyberBlocks;
import io.kalishak.cybercraft.data.CyberDataGenerators;
import io.kalishak.cybercraft.item.CyberItems;
import io.kalishak.cybercraft.registry.CyberRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(Cybercraft.MOD_ID)
public class Cybercraft {
    public static final String MOD_ID = "cybercraft";
    public static final Logger LOGGER = LoggerFactory.getLogger(Cybercraft.class);

    public Cybercraft(IEventBus bus) {
        CyberBlocks.init(bus);
        CyberItems.init(bus);

        bus.register(CyberEvents.class);
        bus.addListener(CyberRegistries::newDataPackRegistries);
        bus.addListener(CyberDataGenerators::gatherData);

        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, CyberConfig.CLIENT_SPEC);
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, CyberConfig.SERVER_SPEC);
    }
}
