package net.lyon.evenbetteramethystfabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.lyon.evenbetteramethystfabric.block.ModBlocks;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootTableProvider {
    public ModBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.CHISELED_AMETHYST_CRYSTAL_BLOCK);
        addDrop(ModBlocks.SMOOTH_AMETHYST_CRYSTAL_BLOCK);
        addDrop(ModBlocks.AMETHYST_CRYSTAL_BLOCK);
        addDrop(ModBlocks.AMETHYST_CRYSTAL_LAMP);
        addDrop(ModBlocks.AMETHYST_REDSTONE_LAMP);
        addDrop(ModBlocks.AMETHYST_BRICKS);
        addDrop(ModBlocks.AMETHYST_BRICK_SLAB, slabDrops(ModBlocks.AMETHYST_BRICK_SLAB));
        addDrop(ModBlocks.AMETHYST_BRICK_STAIRS);
        addDrop(ModBlocks.AMETHYST_BRICK_WALL);


    }
}
