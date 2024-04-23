package io.kalishak.cybercraft.data;

import io.kalishak.cybercraft.data.tags.CyberTags;
import io.kalishak.cybercraft.item.CyberItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class CyberItemTags extends ItemTagsProvider {
    public CyberItemTags(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries, CompletableFuture<TagLookup<Block>> blockTags, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, registries, blockTags, modId, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(CyberTags.Items.NERVOUS_SYSTEM)
                .add(CyberItems.SANDEVISTAN.get());
        tag(CyberTags.Items.OPERATING_SYSTEM)
                .add(CyberItems.MILITECH_PARALINE_MK1.get());
    }
}
