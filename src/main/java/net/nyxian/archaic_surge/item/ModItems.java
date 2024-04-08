package net.nyxian.archaic_surge.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nyxian.archaic_surge.ArchaicSurge;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ArchaicSurge.MOD_ID);

    public static final RegistryObject<Item> AVENTURINE = ITEMS.register("aventurine",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_AVENTURINE = ITEMS.register("raw_aventurine",
            () -> new Item(new Item.Properties()));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
