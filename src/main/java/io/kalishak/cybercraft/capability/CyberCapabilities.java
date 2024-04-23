package io.kalishak.cybercraft.capability;

import io.kalishak.cybercraft.Cybercraft;
import io.kalishak.cybercraft.api.CyberdeckInventory;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.capabilities.EntityCapability;
import net.neoforged.neoforge.capabilities.ItemCapability;

public class CyberCapabilities {
    public static final class Cyberdeck {
        public static final EntityCapability<CyberdeckInventory, Void> ENTITY = EntityCapability.createVoid(
                new ResourceLocation(Cybercraft.MOD_ID, "cyberdeck"),
                CyberdeckInventory.class);
    }

    public static final class Cyberware {
        public static final ItemCapability<io.kalishak.cybercraft.api.cyberware.Cyberware, Void> ITEM = ItemCapability.createVoid(
                new ResourceLocation(Cybercraft.MOD_ID, "cyberware"),
                io.kalishak.cybercraft.api.cyberware.Cyberware.class);
    }
}
