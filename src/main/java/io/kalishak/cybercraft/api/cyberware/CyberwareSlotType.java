package io.kalishak.cybercraft.api.cyberware;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public record CyberwareSlotType(int slotCount, float capacityBase) {
    public static final Codec<CyberwareSlotType> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("slot_count").forGetter(CyberwareSlotType::slotCount),
            Codec.FLOAT.fieldOf("capacity_base").forGetter(CyberwareSlotType::capacityBase)
    ).apply(instance, CyberwareSlotType::new));
}
