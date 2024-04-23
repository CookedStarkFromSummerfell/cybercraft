package io.kalishak.cybercraft.api;

import net.minecraft.core.NonNullList;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.energy.IEnergyStorage;
import net.neoforged.neoforge.items.IItemHandler;

public interface CyberdeckInventory extends IItemHandler, IEnergyStorage {
    NonNullList<ItemStack> getItems();

    LivingEntity getOwner();
}
