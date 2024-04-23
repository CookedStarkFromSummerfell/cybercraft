package io.kalishak.cybercraft.data;

import io.kalishak.cybercraft.Cybercraft;
import io.kalishak.cybercraft.api.cyberware.CyberwareGeneration;
import io.kalishak.cybercraft.registry.CyberRegistries;
import net.minecraft.ChatFormatting;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

public interface CyberwareGenerations {
    ResourceKey<CyberwareGeneration> GEN_I = create("generation_1");
    ResourceKey<CyberwareGeneration> GEN_I_PLUS = create("generation_1_plus");
    ResourceKey<CyberwareGeneration> GEN_II = create("generation_2");
    ResourceKey<CyberwareGeneration> GEN_II_PLUS =create("generation_2_plus");
    ResourceKey<CyberwareGeneration> GEN_III = create("generation_3");

    static void bootstap(BootstapContext<CyberwareGeneration> context) {
        context.register(GEN_I, new CyberwareGeneration(1, ChatFormatting.GRAY));
        context.register(GEN_I_PLUS, new CyberwareGeneration(1, ChatFormatting.GRAY, true));
        context.register(GEN_II, new CyberwareGeneration(2, ChatFormatting.AQUA));
        context.register(GEN_II_PLUS, new CyberwareGeneration(2, ChatFormatting.AQUA, true));
        context.register(GEN_III, new CyberwareGeneration(3, ChatFormatting.GOLD));
    }

    static ResourceKey<CyberwareGeneration> create(String name) {
        return ResourceKey.create(CyberRegistries.CYBERWARE_GENERATION_KEY, new ResourceLocation(Cybercraft.MOD_ID, name));
    }
}
