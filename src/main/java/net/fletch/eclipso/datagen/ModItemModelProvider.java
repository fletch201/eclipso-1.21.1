package net.fletch.eclipso.datagen;

import net.fletch.eclipso.Eclipso;
import net.fletch.eclipso.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Eclipso.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.RAW_ECLIPSIUM.get());
        basicItem(ModItems.ECLIPSIUM.get());
    }
}
