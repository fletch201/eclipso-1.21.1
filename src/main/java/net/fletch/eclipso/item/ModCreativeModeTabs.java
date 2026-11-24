package net.fletch.eclipso.item;

import net.fletch.eclipso.Eclipso;
import net.fletch.eclipso.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Eclipso.MODID);

    public static final Supplier<CreativeModeTab> ECLIPSO_TAB = CREATIVE_MODE_TAB.register("eclipso_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.RAW_ECLIPSIUM.get()))
            .title(Component.translatable("itemGroup.eclipso_tab"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ModItems.ECLIPSIUM);
                output.accept(ModItems.RAW_ECLIPSIUM);
                output.accept(ModBlocks.BLOCK_OF_ECLIPSIUM);
                output.accept(ModBlocks.ECLIPSIUM_ORE);
            }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
