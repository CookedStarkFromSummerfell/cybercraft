package io.kalishak.cybercraft.api.cyberware;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.kalishak.cybercraft.registry.CyberRegistries;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.resources.RegistryFileCodec;

public record CyberwareGeneration(int generation, ChatFormatting color, boolean generationPlus) {
    public static final Codec<CyberwareGeneration> DIRECT_CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("generation").forGetter(CyberwareGeneration::generation),
            ChatFormatting.CODEC.fieldOf("color").forGetter(CyberwareGeneration::color),
            Codec.BOOL.fieldOf("generation_plus").forGetter(CyberwareGeneration::generationPlus)
    ).apply(instance, CyberwareGeneration::new));
    public static final Codec<Holder<CyberwareGeneration>> CODEC = RegistryFileCodec.create(CyberRegistries.CYBERWARE_GENERATION_KEY, DIRECT_CODEC);

    public CyberwareGeneration(int generation, ChatFormatting color) {
        this(generation, color, false);
    }
}
