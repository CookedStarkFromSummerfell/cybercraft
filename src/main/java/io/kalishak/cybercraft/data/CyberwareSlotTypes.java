package io.kalishak.cybercraft.data;

import io.kalishak.cybercraft.Cybercraft;
import io.kalishak.cybercraft.api.cyberware.CyberwareSlotType;
import io.kalishak.cybercraft.registry.CyberRegistries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

public interface CyberwareSlotTypes {
    ResourceKey<CyberwareSlotType> FRONTAL_CORTEX = create("front_cortex");
    ResourceKey<CyberwareSlotType> OPERATING_SYSTEM = create("operating_system");
    ResourceKey<CyberwareSlotType> ARMS = create("arms");
    ResourceKey<CyberwareSlotType> FACE = create("face");
    ResourceKey<CyberwareSlotType> SKELETON = create("skeleton");
    ResourceKey<CyberwareSlotType> HANDS = create("hands");
    ResourceKey<CyberwareSlotType> NERVOUS_SYSTEM = create("nervous_system");
    ResourceKey<CyberwareSlotType> CIRCULATORY_SYSTEM = create("circulatory_system");
    ResourceKey<CyberwareSlotType> INTEGUMENTARY_SYSTEM = create("integumentary_system");
    ResourceKey<CyberwareSlotType> LEGS = create("legs");

    static void bootstap(BootstapContext<CyberwareSlotType> cxt) {
        cxt.register(FRONTAL_CORTEX, new CyberwareSlotType(3, 1.0F));
        cxt.register(OPERATING_SYSTEM, new CyberwareSlotType(1, 1.0F));
        cxt.register(ARMS, new CyberwareSlotType(1, 1.0F));
        cxt.register(FACE, new CyberwareSlotType(2, 1.0F));
        cxt.register(SKELETON, new CyberwareSlotType(3, 1.0F));
        cxt.register(HANDS, new CyberwareSlotType(2, 1.0F));
        cxt.register(NERVOUS_SYSTEM, new CyberwareSlotType(3, 1.0F));
        cxt.register(CIRCULATORY_SYSTEM, new CyberwareSlotType(3, 1.0F));
        cxt.register(INTEGUMENTARY_SYSTEM, new CyberwareSlotType(3, 1.0F));
        cxt.register(LEGS, new CyberwareSlotType(1, 1.0F));
    }

    static ResourceKey<CyberwareSlotType> create(String name) {
        return ResourceKey.create(CyberRegistries.CYBERWARE_SLOT_TYPE_KEY, new ResourceLocation(Cybercraft.MOD_ID, name));
    }
}
