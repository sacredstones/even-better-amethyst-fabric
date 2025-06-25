package net.lyon.evenbetteramethystfabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.lyon.evenbetteramethystfabric.EvenBetterAmethystFabric;
import net.lyon.evenbetteramethystfabric.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {



        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.AMETHYST_SHARD, 4)
                .input(Blocks.AMETHYST_BLOCK)
                        .criterion(hasItem(Blocks.AMETHYST_BLOCK), conditionsFromItem(Blocks.AMETHYST_BLOCK))
                                .offerTo(recipeExporter, Identifier.of(EvenBetterAmethystFabric.MOD_ID, "amethyst_block_to_shard"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMETHYST_BRICKS, 4)
                .pattern("XX")
                .pattern("XX")
                .input('X', Blocks.AMETHYST_BLOCK)
                .criterion(hasItem(Blocks.AMETHYST_BLOCK), conditionsFromItem(Blocks.AMETHYST_BLOCK))
                        .offerTo(recipeExporter, "amethyst_bricks_shapeless");

        offerSlabRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMETHYST_BRICK_SLAB, ModBlocks.AMETHYST_BRICKS);

        createStairsRecipe(ModBlocks.AMETHYST_BRICK_STAIRS, Ingredient.ofItems(ModBlocks.AMETHYST_BRICKS))
                .criterion(hasItem(ModBlocks.AMETHYST_BRICKS), conditionsFromItem(ModBlocks.AMETHYST_BRICKS))
                        .offerTo(recipeExporter, Identifier.of("amethyst_brick_stairs"));

        offerWallRecipe(recipeExporter, RecipeCategory.DECORATIONS, ModBlocks.AMETHYST_BRICK_WALL, ModBlocks.AMETHYST_BRICKS);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.AMETHYST_SHARD, 9)
                .input(ModBlocks.CHISELED_AMETHYST_CRYSTAL_BLOCK)
                        .criterion(hasItem(ModBlocks.CHISELED_AMETHYST_CRYSTAL_BLOCK), conditionsFromItem(ModBlocks.CHISELED_AMETHYST_CRYSTAL_BLOCK))
                                .offerTo(recipeExporter, Identifier.of("chiseled_amethyst_crystal_to_shards"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.AMETHYST_SHARD, 9)
                .input(ModBlocks.SMOOTH_AMETHYST_CRYSTAL_BLOCK)
                .criterion(hasItem(ModBlocks.SMOOTH_AMETHYST_CRYSTAL_BLOCK), conditionsFromItem(ModBlocks.SMOOTH_AMETHYST_CRYSTAL_BLOCK))
                .offerTo(recipeExporter, Identifier.of("smooth_amethyst_crystal_to_shards"));

        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.MISC, Items.AMETHYST_SHARD, RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMETHYST_CRYSTAL_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.AMETHYST_CRYSTAL_LAMP)
                .pattern(" A ")
                .pattern("AGA")
                .pattern(" A ")
                .input('A', Items.AMETHYST_SHARD)
                .input('G', Blocks.GLOWSTONE)
                .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                        .offerTo(recipeExporter, "amethyst_crystal_lamp");

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.AMETHYST_REDSTONE_LAMP)
                .pattern(" R ")
                .pattern("RLR")
                .pattern(" R ")
                .input('R', Items.REDSTONE)
                .input('L', ModBlocks.AMETHYST_CRYSTAL_LAMP)
                .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(recipeExporter, "amethyst_redstone_lamp");

        // stonecutter recipes for blocks
        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMETHYST_BRICKS, Blocks.AMETHYST_BLOCK);
        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMETHYST_BRICK_SLAB, ModBlocks.AMETHYST_BRICKS);
        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMETHYST_BRICK_STAIRS, ModBlocks.AMETHYST_BRICKS);
        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMETHYST_BRICK_WALL, ModBlocks.AMETHYST_BRICKS);
        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_AMETHYST_CRYSTAL_BLOCK, ModBlocks.AMETHYST_CRYSTAL_BLOCK);
        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_AMETHYST_CRYSTAL_BLOCK, ModBlocks.AMETHYST_CRYSTAL_BLOCK);
    }
}
