package io.kalishak.cybercraft.registry;

import io.kalishak.cybercraft.Cybercraft;
import io.kalishak.cybercraft.api.cyberware.CyberwareSlotType;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.registries.DataPackRegistryEvent;
import net.neoforged.neoforge.registries.NewRegistryEvent;

public class CyberRegistries {
    public static final ResourceKey<Registry<CyberwareSlotType>> CYBERWARE_SLOT_TYPE_KEY = ResourceKey.createRegistryKey(new ResourceLocation(Cybercraft.MOD_ID, "cyberware_slot_type"));

    @SubscribeEvent
    public static void newRegistries(final NewRegistryEvent event) {
    }

    @SubscribeEvent
    public static void newDataPackRegistries(final DataPackRegistryEvent.NewRegistry event) {
        event.dataPackRegistry(CYBERWARE_SLOT_TYPE_KEY, CyberwareSlotType.CODEC);
    }
}
