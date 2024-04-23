package io.kalishak.cybercraft.data;

import io.kalishak.cybercraft.Cybercraft;
import io.kalishak.cybercraft.api.cyberware.Cyberware;
import io.kalishak.cybercraft.item.CyberItems;
import io.kalishak.cybercraft.registry.CyberRegistries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

public interface Cyberwares {
    ResourceKey<Cyberware> SANDEVISTAN = create("sandevistan");
    ResourceKey<Cyberware> MILITECH_PARALINE_MK1 = create("militech_paraline_mk1");

    static void bootstap(BootstapContext<Cyberware> ctx) {
        var slotTypes = ctx.lookup(CyberRegistries.CYBERWARE_SLOT_TYPE_KEY);
        var generations = ctx.lookup(CyberRegistries.CYBERWARE_GENERATION_KEY);

        ctx.register(SANDEVISTAN, new Cyberware(
                CyberItems.SANDEVISTAN.get().getDefaultInstance(),
                slotTypes.getOrThrow(CyberwareSlotTypes.NERVOUS_SYSTEM),
                generations.getOrThrow(CyberwareGenerations.GEN_III),
                15));
        ctx.register(MILITECH_PARALINE_MK1, new Cyberware(
                CyberItems.MILITECH_PARALINE_MK1.get().getDefaultInstance(),
                slotTypes.getOrThrow(CyberwareSlotTypes.OPERATING_SYSTEM),
                generations.getOrThrow(CyberwareGenerations.GEN_I),
                5));
    }

    static ResourceKey<Cyberware> create(String name) {
        return ResourceKey.create(CyberRegistries.CYBERWARE_KEY, new ResourceLocation(Cybercraft.MOD_ID, name));
    }
}
