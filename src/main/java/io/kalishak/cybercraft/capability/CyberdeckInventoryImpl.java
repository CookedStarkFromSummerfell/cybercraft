package io.kalishak.cybercraft.capability;

import io.kalishak.cybercraft.api.CyberdeckInventory;
import io.kalishak.cybercraft.api.cyberware.CyberwareSlotType;
import io.kalishak.cybercraft.registry.CyberRegistries;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

import java.util.Map;
import java.util.Set;

public class CyberdeckInventoryImpl implements CyberdeckInventory {
    private final int[] indexes;

    private final NonNullList<ItemStack> items;
    private final LivingEntity owner;

    private int energyCapacity;
    private int storedEnergy = 0;

    public CyberdeckInventoryImpl(NonNullList<ItemStack> items, LivingEntity owner) {
        this.indexes = getSlotIndexes(owner.level().registryAccess());
        this.items = items;
        this.owner = owner;
    }

    public CyberdeckInventoryImpl(LivingEntity owner) {
        this(NonNullList.withSize(getRegisteredSlots(owner.level().registryAccess()), ItemStack.EMPTY), owner);
    }

    @Override
    public NonNullList<ItemStack> getItems() {
        return this.items;
    }

    @Override
    public LivingEntity getOwner() {
        return this.owner;
    }

    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) {
        if (!canReceive()) {
            int received = Math.min(maxReceive, this.energyCapacity - storedEnergy);

            if (!simulate) {
                storedEnergy += received;
            }

            return received;
        }

        return 0;
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate) {
        if (!canExtract()) {
            int extracted = Math.min(maxExtract, this.storedEnergy);

            if (!simulate) {
                storedEnergy -= extracted;
            }

            return extracted;
        }

        return 0;
    }

    @Override
    public int getEnergyStored() {
        return this.storedEnergy;
    }

    @Override
    public int getMaxEnergyStored() {
        return this.energyCapacity;
    }

    @Override
    public boolean canExtract() {
        return this.storedEnergy > 0;
    }

    @Override
    public boolean canReceive() {
        return this.storedEnergy != this.energyCapacity;
    }

    @Override
    public int getSlots() {
        return getItems().size();
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return this.items.get(slot);
    }

    @Override
    public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
        return null;
    }

    @Override
    public ItemStack extractItem(int slot, int amount, boolean simulate) {
        return null;
    }

    @Override
    public int getSlotLimit(int slot) {
        return 0;
    }

    @Override
    public boolean isItemValid(int slot, ItemStack stack) {
        return false;
    }

    private static int getRegisteredSlots(RegistryAccess registryAccess) {
        int size = 0;
        Set<Map.Entry<ResourceKey<CyberwareSlotType>, CyberwareSlotType>> set = registryAccess
                .registry(CyberRegistries.CYBERWARE_SLOT_TYPE_KEY)
                .orElseThrow(IllegalStateException::new)
                .entrySet();

        for (var entry : set) {
            size += entry.getValue().slotCount();
        }

        return size;
    }

    private static int[] getSlotIndexes(RegistryAccess registryAccess) {
        int index = 0;
        int i = 0;
        Set<Map.Entry<ResourceKey<CyberwareSlotType>, CyberwareSlotType>> set = registryAccess
                .registry(CyberRegistries.CYBERWARE_SLOT_TYPE_KEY)
                .orElseThrow(IllegalStateException::new)
                .entrySet();
        int[] indexes = new int[set.size()];

        for (Map.Entry<ResourceKey<CyberwareSlotType>, CyberwareSlotType> entry : set) {
            indexes[i] = index;
            index += entry.getValue().slotCount();
            i++;
        }

        return indexes;
    }
}
