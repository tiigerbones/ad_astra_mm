package com.enchantedwisp.aamm.datagen;

import com.enchantedwisp.aamm.registry.RegistryHandler;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;

import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators generator) {
        generator.createTrivialCube(RegistryHandler.MARS_CARMOT_ORE);
        generator.createTrivialCube(RegistryHandler.MOON_STORMYX_ORE);
        generator.createTrivialCube(RegistryHandler.MERCURY_PALLADIUM_ORE);
        generator.createTrivialCube(RegistryHandler.VENUS_ORICHALCUM_ORE);
        generator.createTrivialCube(RegistryHandler.GLACIO_UNOBTAINIUM_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        // Not needed for simple cube blocks
    }
}