package net.fletch.eclipso.datagen;

import net.fletch.eclipso.block.ModBlocks;
import net.fletch.eclipso.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLOCK_OF_ECLIPSIUM.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.ECLIPSIUM.get())
                .unlockedBy("has_eclipsium", has(ModItems.ECLIPSIUM.get()))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ECLIPSIUM.get(), 9)
                .requires(ModBlocks.BLOCK_OF_ECLIPSIUM)
                .unlockedBy("has_block_of_eclipsium", has(ModBlocks.BLOCK_OF_ECLIPSIUM)).save(recipeOutput);

        List<ItemLike> ORE_SMELTABLES = List.of(ModBlocks.ECLIPSIUM_ORE.get());
        List<ItemLike> RAW_SMELTABLES = List.of(ModItems.RAW_ECLIPSIUM.get());

        oreSmelting(recipeOutput, ORE_SMELTABLES, RecipeCategory.MISC, ModItems.RAW_ECLIPSIUM.get(), 1f, 200, "raw_eclipsium");
        oreBlasting(recipeOutput, ORE_SMELTABLES, RecipeCategory.MISC, ModItems.RAW_ECLIPSIUM.get(), 1.5f, 100, "raw_eclipsium");

        oreSmelting(recipeOutput, RAW_SMELTABLES, RecipeCategory.MISC, ModItems.ECLIPSIUM.get(), 1f, 200, "eclipsium");
        oreBlasting(recipeOutput, RAW_SMELTABLES, RecipeCategory.MISC, ModItems.ECLIPSIUM.get(), 1.5f, 100, "eclipsium");
    }
}