package net.lyon.evenbetteramethystfabric.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.lyon.evenbetteramethystfabric.EvenBetterAmethystFabric;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {


    public static final Block CHISELED_AMETHYST_CRYSTAL_BLOCK = registerBlock("chiseled_amethyst_crystal_block",
            new Block(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.PURPLE)
                            .strength(3f, 9f)
                            .sounds(BlockSoundGroup.AMETHYST_BLOCK)
                            .requiresTool()
                            .solid()
            )
    );

    public static final Block SMOOTH_AMETHYST_CRYSTAL_BLOCK = registerBlock("smooth_amethyst_crystal_block",
            new Block(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.PURPLE)
                            .strength(3f, 9f)
                            .sounds(BlockSoundGroup.AMETHYST_BLOCK)
                            .requiresTool()
                            .solid()
            )
    );



    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(EvenBetterAmethystFabric.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(EvenBetterAmethystFabric.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));

    }

    public static void registerModBlocks() {
        EvenBetterAmethystFabric.LOGGER.info("Registering Mod Blocks For " + EvenBetterAmethystFabric.MOD_ID);
    }
}
