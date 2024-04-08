package net.nyxian.archaic_surge.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.nyxian.archaic_surge.ArchaicSurge;
import net.nyxian.archaic_surge.block.ModBlocks;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ArchaicSurge.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ARCHAIC_GEMS = CREATIVE_MODE_TABS.register("archaic_gems",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.AVENTURINE.get()))
                    .title(Component.translatable("creativetab.archaic_gems"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.RAW_AVENTURINE.get());
                        pOutput.accept(ModItems.AVENTURINE.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> ARCHAIC_BLOCKS = CREATIVE_MODE_TABS.register("archaic_blocks",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.AVENTURINE_BLOCK.get()))
                    .title(Component.translatable("creativetab.archaic_blocks"))
                    .displayItems((pParameters, pOutput) -> {

                        pOutput.accept(ModBlocks.AVENTURINE_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_AVENTURINE_ORE.get());
                        pOutput.accept(ModBlocks.AVENTURINE_BLOCK.get());
                        pOutput.accept(ModBlocks.RAW_AVENTURINE_BLOCK.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
