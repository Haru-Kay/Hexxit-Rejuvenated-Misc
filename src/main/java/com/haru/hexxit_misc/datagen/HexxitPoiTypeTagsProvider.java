package com.haru.hexxit_misc.datagen;

import com.haru.hexxit_misc.HexxitMisc;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PoiTypeTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.PoiTypeTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class HexxitPoiTypeTagsProvider extends PoiTypeTagsProvider {
    public HexxitPoiTypeTagsProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pProvider, HexxitMisc.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        //tag(PoiTypeTags.ACQUIRABLE_JOB_SITE)
        //        .addOptional(ResourceLocation.fromNamespaceAndPath(HexxitMisc.MOD_ID, "sound_poi"));
    }
}
