package com.haru.hexxit_misc.datagen;

import com.haru.hexxit_misc.HexxitMisc;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class HexxitWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder();
    /*
            .add(Registries.CONFIGURED_FEATURE, HexxitConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, HexxitPlacedFeatures::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, HexxitBiomeModifiers::bootstrap);

     */
    public HexxitWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(HexxitMisc.MOD_ID));
    }
}
