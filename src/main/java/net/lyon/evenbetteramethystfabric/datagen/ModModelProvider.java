package net.lyon.evenbetteramethystfabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.lyon.evenbetteramethystfabric.block.ModBlocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.VariantsBlockStateSupplier;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_AMETHYST_CRYSTAL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SMOOTH_AMETHYST_CRYSTAL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.AMETHYST_CRYSTAL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.AMETHYST_CRYSTAL_LAMP);



        BlockStateModelGenerator.BlockTexturePool amethystBrickPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.AMETHYST_BRICKS);

        amethystBrickPool.slab(ModBlocks.AMETHYST_BRICK_SLAB);
        amethystBrickPool.stairs(ModBlocks.AMETHYST_BRICK_STAIRS);
        amethystBrickPool.wall(ModBlocks.AMETHYST_BRICK_WALL);



    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {


    }
}
