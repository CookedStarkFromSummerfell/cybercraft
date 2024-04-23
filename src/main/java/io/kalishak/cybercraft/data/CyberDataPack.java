package io.kalishak.cybercraft.data;

import io.kalishak.cybercraft.registry.CyberRegistries;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class CyberDataPack extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(CyberRegistries.CYBERWARE_GENERATION_KEY, CyberwareGenerations::bootstap)
            .add(CyberRegistries.CYBERWARE_SLOT_TYPE_KEY, CyberwareSlotTypes::bootstap)
            .add(CyberRegistries.CYBERWARE_KEY, Cyberwares::bootstap);

    public CyberDataPack(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, String modId) {
        super(output, registries, BUILDER, Set.of(modId));
    }
}
