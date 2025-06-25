package net.lyon.evenbetteramethystfabric;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.lyon.evenbetteramethystfabric.datagen.ModBlockTagProvider;
import net.lyon.evenbetteramethystfabric.datagen.ModBlockLootTableProvider;
import net.lyon.evenbetteramethystfabric.datagen.ModModelProvider;
import net.lyon.evenbetteramethystfabric.datagen.ModRecipeProvider;

public class EvenBetterAmethystFabricDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModBlockLootTableProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);

	}
}
