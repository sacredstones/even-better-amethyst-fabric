package net.lyon.evenbetteramethystfabric;

import net.fabricmc.api.ModInitializer;

import net.lyon.evenbetteramethystfabric.block.ModBlocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EvenBetterAmethystFabric implements ModInitializer {
	public static final String MOD_ID = "evenbetteramethystfabric";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		//ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}