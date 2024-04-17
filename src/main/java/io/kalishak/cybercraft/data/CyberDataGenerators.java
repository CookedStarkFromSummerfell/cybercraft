package io.kalishak.cybercraft.data;

import io.kalishak.cybercraft.Cybercraft;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public class CyberDataGenerators {
    @SubscribeEvent
    public static void gatherData(final GatherDataEvent event) {
        var dataGenerator = event.getGenerator();
        var packOutput = dataGenerator.getPackOutput();
        var registries = event.getLookupProvider();
        var fileHelper = event.getExistingFileHelper();

        dataGenerator.addProvider(event.includeServer(), new CyberDataPack(packOutput, registries, Cybercraft.MOD_ID));
    }
}
