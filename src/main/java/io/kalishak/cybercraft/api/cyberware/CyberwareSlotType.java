package io.kalishak.cybercraft.api.cyberware;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.kalishak.cybercraft.registry.CyberRegistries;
import net.minecraft.core.Holder;
import net.minecraft.resources.RegistryFileCodec;

public record CyberwareSlotType(int slotCount, float capacityBase) {
    public static final Codec<CyberwareSlotType> DIRECT_CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("slot_count").forGetter(CyberwareSlotType::slotCount),
            Codec.FLOAT.fieldOf("capacity_base").forGetter(CyberwareSlotType::capacityBase)
    ).apply(instance, CyberwareSlotType::new));
    public static final Codec<Holder<CyberwareSlotType>> CODEC = RegistryFileCodec.create(CyberRegistries.CYBERWARE_SLOT_TYPE_KEY, DIRECT_CODEC);
}
