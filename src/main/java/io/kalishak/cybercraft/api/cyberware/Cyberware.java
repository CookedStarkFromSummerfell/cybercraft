package io.kalishak.cybercraft.api.cyberware;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.crafting.CraftingHelper;

import java.util.Optional;

@SuppressWarnings("UnstableApiUsage")
public record Cyberware(ItemStack holder, Holder<CyberwareSlotType> slotType, Holder<CyberwareGeneration> generation, int capacityBase, Optional<Integer> energyUsagePerTick) {
    public static final Codec<Cyberware> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            CraftingHelper.smeltingResultCodec().fieldOf("item").forGetter(Cyberware::holder),
            CyberwareSlotType.CODEC.fieldOf("slot_type").forGetter(Cyberware::slotType),
            CyberwareGeneration.CODEC.fieldOf("generation").forGetter(Cyberware::generation),
            Codec.INT.fieldOf("capacity").forGetter(Cyberware::capacityBase),
            Codec.INT.optionalFieldOf("energy_usage").forGetter(Cyberware::energyUsagePerTick)
    ).apply(instance, Cyberware::new));

    public Cyberware(ItemStack stack, Holder<CyberwareSlotType> slotType, Holder<CyberwareGeneration> generation, int capacityBase) {
        this(stack, slotType, generation, capacityBase, Optional.empty());
    }
}
