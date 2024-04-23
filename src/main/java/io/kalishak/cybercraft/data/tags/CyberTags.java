package io.kalishak.cybercraft.data.tags;

import io.kalishak.cybercraft.Cybercraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class CyberTags {
    public static class Items {
        public static final TagKey<Item> FRONTAL_CORTEX = create("frontal_cortex");
        public static final TagKey<Item> OPERATING_SYSTEM = create("operating_system");
        public static final TagKey<Item> ARMS = create("arms");
        public static final TagKey<Item> FACE = create("face");
        public static final TagKey<Item> SKELETON = create("skeleton");
        public static final TagKey<Item> HANDS = create("hands");
        public static final TagKey<Item> NERVOUS_SYSTEM = create("nervous_system");
        public static final TagKey<Item> CIRCULATORY_SYSTEM = create("circulatory_system");
        public static final TagKey<Item> INTEGUMENTARY_SYSTEM = create("integumentary_system");
        public static final TagKey<Item> LEGS = create("legs");

        private static TagKey<Item> create(String tagName) {
            return ItemTags.create(new ResourceLocation(Cybercraft.MOD_ID, tagName));
        }
    }
}
