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
        CyberBlockTags cyberBlockTags = new CyberBlockTags(packOutput, registries, Cybercraft.MOD_ID, fileHelper);
        dataGenerator.addProvider(event.includeServer(), cyberBlockTags);
        dataGenerator.addProvider(event.includeServer(), new CyberItemTags(packOutput, registries, cyberBlockTags.contentsGetter(), Cybercraft.MOD_ID, fileHelper));
    }
}
