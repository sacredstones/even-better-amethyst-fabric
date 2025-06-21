package net.lyon.evenbetteramethystfabric.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.lyon.evenbetteramethystfabric.EvenBetterAmethystFabric;
import net.minecraft.block.Blocks;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import static net.minecraft.block.Blocks.createLightLevelFromLitBlockState;

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

    public static final Block AMETHYST_CRYSTAL_BLOCK = registerBlock("amethyst_crystal_block",
            new Block(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.PURPLE)
                            .strength(3f, 9f)
                            .sounds(BlockSoundGroup.AMETHYST_BLOCK)
                            .requiresTool()
                            .solid()
            )
    );


    public static final Block AMETHYST_CRYSTAL_LAMP = registerBlock("amethyst_crystal_lamp",
            new Block(
                    AbstractBlock.Settings.create()
                            .instrument(NoteBlockInstrument.HAT)
                            .strength(0.3F)
                            .sounds(BlockSoundGroup.GLASS)
                            .nonOpaque()
                            .allowsSpawning(Blocks::never)
                            .solidBlock(Blocks::never)
                            .suffocates(Blocks::never)
                            .blockVision(Blocks::never)
                            .luminance(blockState -> 15)
            )
    );

    public static final Block AMETHYST_REDSTONE_LAMP = registerBlock("amethyst_redstone_lamp",
            new RedstoneLampBlock(
                    AbstractBlock.Settings.create()
                            .luminance(createLightLevelFromLitBlockState(15))
                            .strength(0.3f)
                            .sounds(BlockSoundGroup.AMETHYST_BLOCK)
                            .mapColor(MapColor.PURPLE)
                            .allowsSpawning(Blocks::always)


            )
    );

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(EvenBetterAmethystFabric.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(EvenBetterAmethystFabric.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.CHISELED_AMETHYST_CRYSTAL_BLOCK);
            entries.add(ModBlocks.SMOOTH_AMETHYST_CRYSTAL_BLOCK);
            entries.add(ModBlocks.AMETHYST_CRYSTAL_BLOCK);

        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(entries -> {
            entries.add(ModBlocks.AMETHYST_REDSTONE_LAMP);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.add(ModBlocks.AMETHYST_REDSTONE_LAMP);
            entries.add(ModBlocks.AMETHYST_CRYSTAL_LAMP);
        });

    }

    public static void registerModBlocks() {
        EvenBetterAmethystFabric.LOGGER.info("Registering Mod Blocks For " + EvenBetterAmethystFabric.MOD_ID);
    }
}
