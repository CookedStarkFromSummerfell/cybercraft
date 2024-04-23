package io.kalishak.cybercraft.item;

import io.kalishak.cybercraft.api.cyberware.CyberwareSlotType;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

public class CyberwareItem extends Item {
    protected final Holder<CyberwareSlotType> slotType;

    public CyberwareItem(Holder<CyberwareSlotType> slotType, Properties pProperties) {
        super(pProperties);
        this.slotType = slotType;
    }

    public Holder<CyberwareSlotType> getSlotType() {
        return this.slotType;
    }
}
