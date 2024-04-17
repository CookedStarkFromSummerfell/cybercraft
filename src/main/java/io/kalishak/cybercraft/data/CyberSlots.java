package io.kalishak.cybercraft.data;

import io.kalishak.cybercraft.Cybercraft;
import io.kalishak.cybercraft.api.cyberware.CyberwareSlotType;
import io.kalishak.cybercraft.registry.CyberRegistries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

public interface CyberSlots {
    ResourceKey<CyberwareSlotType> FRONTAL_CORTEX = ResourceKey.create(CyberRegistries.CYBERWARE_SLOT_TYPE_KEY, new ResourceLocation(Cybercraft.MOD_ID, "front_cortex"));
    ResourceKey<CyberwareSlotType> OPERATING_SYSTEM = ResourceKey.create(CyberRegistries.CYBERWARE_SLOT_TYPE_KEY, new ResourceLocation(Cybercraft.MOD_ID, "operating_system"));
    ResourceKey<CyberwareSlotType> ARMS = ResourceKey.create(CyberRegistries.CYBERWARE_SLOT_TYPE_KEY, new ResourceLocation(Cybercraft.MOD_ID, "arms"));
    ResourceKey<CyberwareSlotType> FACE = ResourceKey.create(CyberRegistries.CYBERWARE_SLOT_TYPE_KEY, new ResourceLocation(Cybercraft.MOD_ID, "face"));
    ResourceKey<CyberwareSlotType> SKELETON = ResourceKey.create(CyberRegistries.CYBERWARE_SLOT_TYPE_KEY, new ResourceLocation(Cybercraft.MOD_ID, "skeleton"));
    ResourceKey<CyberwareSlotType> HANDS = ResourceKey.create(CyberRegistries.CYBERWARE_SLOT_TYPE_KEY, new ResourceLocation(Cybercraft.MOD_ID, "hands"));
    ResourceKey<CyberwareSlotType> NERVOUS_SYSTEM = ResourceKey.create(CyberRegistries.CYBERWARE_SLOT_TYPE_KEY, new ResourceLocation(Cybercraft.MOD_ID, "nervous_system"));
    ResourceKey<CyberwareSlotType> CIRCULATORY_SYSTEM = ResourceKey.create(CyberRegistries.CYBERWARE_SLOT_TYPE_KEY, new ResourceLocation(Cybercraft.MOD_ID, "circulatory_system"));
    ResourceKey<CyberwareSlotType> INTEGUMENTARY_SYSTEM = ResourceKey.create(CyberRegistries.CYBERWARE_SLOT_TYPE_KEY, new ResourceLocation(Cybercraft.MOD_ID, "integumentary_system"));
    ResourceKey<CyberwareSlotType> LEGS = ResourceKey.create(CyberRegistries.CYBERWARE_SLOT_TYPE_KEY, new ResourceLocation(Cybercraft.MOD_ID, "legs"));

    static void bootstrap(BootstapContext<CyberwareSlotType> bootstrap) {
        bootstrap.register(FRONTAL_CORTEX, new CyberwareSlotType(3, 1.0F));
        bootstrap.register(OPERATING_SYSTEM, new CyberwareSlotType(1, 1.0F));
        bootstrap.register(ARMS, new CyberwareSlotType(1, 1.0F));
        bootstrap.register(FACE, new CyberwareSlotType(2, 1.0F));
        bootstrap.register(SKELETON, new CyberwareSlotType(3, 1.0F));
        bootstrap.register(HANDS, new CyberwareSlotType(2, 1.0F));
        bootstrap.register(NERVOUS_SYSTEM, new CyberwareSlotType(3, 1.0F));
        bootstrap.register(CIRCULATORY_SYSTEM, new CyberwareSlotType(3, 1.0F));
        bootstrap.register(INTEGUMENTARY_SYSTEM, new CyberwareSlotType(3, 1.0F));
        bootstrap.register(LEGS, new CyberwareSlotType(1, 1.0F));
    }
}
