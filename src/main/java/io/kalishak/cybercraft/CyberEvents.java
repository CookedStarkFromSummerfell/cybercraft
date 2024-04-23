package io.kalishak.cybercraft;

import io.kalishak.cybercraft.capability.CyberCapabilities;
import io.kalishak.cybercraft.capability.CyberdeckInventoryImpl;
import net.minecraft.SharedConstants;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackCompatibility;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlagSet;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.event.AddPackFindersEvent;

import java.nio.file.Path;
import java.util.List;

public class CyberEvents {
    @SubscribeEvent
    public static void registerCapabilities(final RegisterCapabilitiesEvent event) {
        event.registerEntity(
                CyberCapabilities.Cyberdeck.ENTITY,
                EntityType.PLAYER,
                (player, v) -> new CyberdeckInventoryImpl(player));
    }

    @SubscribeEvent
    public static void registerDataPacks(AddPackFindersEvent event) {
        setupClassicPack(event);

        setupCyberpunk2077Pack(event);
    }

    private static void setupClassicPack(AddPackFindersEvent event) {
        if (event.getPackType() == PackType.CLIENT_RESOURCES) {
            Path path = ModList.get().getModFileById(Cybercraft.MOD_ID).getFile().findResource("packs/classic");
            PackMetadataSection metaData = new PackMetadataSection(Component.translatable("pack.cybercraft.classic.description"), SharedConstants.getCurrentVersion().getPackVersion(PackType.SERVER_DATA));
            event.addRepositorySource(source -> source.accept(Pack.create(
                    "builtin/classic",
                    Component.translatable("pack.cybercraft.classic.title"),
                    false,
                    new PathPackResources.PathResourcesSupplier(path, true),
                    new Pack.Info(metaData.description(), PackCompatibility.COMPATIBLE, FeatureFlagSet.of(), List.of(), false),
                    Pack.Position.TOP,
                    false,
                    PackSource.BUILT_IN)));
        }
    }

    private static void setupCyberpunk2077Pack(AddPackFindersEvent event) {
        if (event.getPackType() == PackType.SERVER_DATA) {
            Path path = ModList.get().getModFileById(Cybercraft.MOD_ID).getFile().findResource("packs/cyberpunk2077");
            PackMetadataSection metaData = new PackMetadataSection(Component.translatable("pack.cybercraft.cyberpunk2077.description"), SharedConstants.getCurrentVersion().getPackVersion(PackType.SERVER_DATA));
            event.addRepositorySource(source -> source.accept(Pack.create(
                    "builtin/cyberpunk2077",
                    Component.translatable("pack.cybercraft.cyberpunk2077.title"),
                    true,
                    new PathPackResources.PathResourcesSupplier(path, true),
                    new Pack.Info(metaData.description(), PackCompatibility.COMPATIBLE, FeatureFlagSet.of(), List.of(), false),
                    Pack.Position.TOP,
                    false,
                    PackSource.BUILT_IN)));
        }
    }
}
