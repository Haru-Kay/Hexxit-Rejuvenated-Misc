package com.haru.hexxit_misc.datagen;

import com.haru.hexxit_misc.HexxitMisc;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HexxitBlockStateProvider extends BlockStateProvider {
    public HexxitBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, HexxitMisc.MOD_ID, exFileHelper);
    }
    @Override
    protected void registerStatesAndModels() {
    }


    public ResourceLocation blockTexture(Block block) {
        ResourceLocation name = key(block);
        return ResourceLocation.fromNamespaceAndPath(name.getNamespace(), ModelProvider.BLOCK_FOLDER + "/" + name.getPath());
    }
    public ResourceLocation blockTexture(Block block, String path) {
        ResourceLocation name = key(block);
        return ResourceLocation.fromNamespaceAndPath(name.getNamespace(), ModelProvider.BLOCK_FOLDER + "/" + path + name.getPath());
    }
    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(),
                blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ResourceLocation texture) {
        ModelFile sign = models().sign(name(signBlock), texture);
        hangingSignBlock(signBlock, wallSignBlock, sign);
    }

    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ModelFile sign) {
        simpleBlock(signBlock, sign);
        simpleBlock(wallSignBlock, sign);
    }

    private String name(Block block) {
        return key(block).getPath();
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject, String wood) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout_mipped"));
    }

    private void bookshelfBlock(RegistryObject<Block> blockRegistryObject, String wood) {
        simpleBlockWithItem(blockRegistryObject.get(), models().cubeColumn(wood + "_bookshelf",
                modLoc("block/" + wood + "_bookshelf"),
                modLoc("block/" + wood + "_planks")));
    }
    private void workbenchBlock(RegistryObject<Block> blockRegistryObject, String wood) {
        simpleBlockWithItem(blockRegistryObject.get(), models().cube(wood + "_workbench",
                modLoc("block/" + wood + "_planks"),
                modLoc("block/" + wood + "_workbench_top"),
                modLoc("block/" + wood + "_workbench_face"),
                modLoc("block/" + wood + "_workbench_side"),
                modLoc("block/" + wood + "_workbench_face"),
                modLoc("block/" + wood + "_workbench_side")));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(HexxitMisc.MOD_ID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }
    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
