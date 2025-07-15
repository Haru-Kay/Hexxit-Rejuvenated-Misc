package com.haru.hexxit_misc.datagen;

import com.haru.hexxit_misc.HexxitMisc;
import com.haru.hexxit_misc.util.HexxitWoodTypes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = HexxitMisc.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new HexxitRecipeProvider(packOutput));
        generator.addProvider(event.includeServer(), HexxitLootTableProvider.create(packOutput));

        generator.addProvider(event.includeClient(), new HexxitBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new HexxitItemModelProvider(packOutput, existingFileHelper));

        HexxitBlockTagGenerator blockTagGenerator = generator.addProvider(event.includeServer(),
                new HexxitBlockTagGenerator(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new HexxitItemTagGenerator(packOutput, lookupProvider, blockTagGenerator.contentsGetter(), existingFileHelper));

        //generator.addProvider(event.includeServer(), new HexxitGlobalLootModifiersProvider(packOutput));
        generator.addProvider(event.includeServer(), new HexxitPoiTypeTagsProvider(packOutput, lookupProvider, existingFileHelper));

        generator.addProvider(event.includeServer(), new HexxitWorldGenProvider(packOutput, lookupProvider));
    }
}
