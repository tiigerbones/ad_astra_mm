package com.enchantedwisp.aamm.datagen;

import com.enchantedwisp.aamm.registry.RegistryHandler;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;

import java.util.concurrent.CompletableFuture;
public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {

        // Mining Tags
        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(RegistryHandler.MARS_CARMOT_ORE)
                .add(RegistryHandler.MOON_STORMYX_ORE)
                .add(RegistryHandler.MERCURY_PALLADIUM_ORE)
                .add(RegistryHandler.VENUS_ORICHALCUM_ORE)
                .add(RegistryHandler.GLACIO_UNOBTAINIUM_ORE);

        // Carmot
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(RegistryHandler.MARS_CARMOT_ORE)
                .add(RegistryHandler.MOON_STORMYX_ORE);

        // Palladium Orichalcum
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(RegistryHandler.MERCURY_PALLADIUM_ORE)
                .add(RegistryHandler.VENUS_ORICHALCUM_ORE);

        // Unobtainium = Level 4
        getOrCreateTagBuilder(TagKey.create(Registries.BLOCK, new ResourceLocation("fabric", "needs_tool_level_4")))
                .add(RegistryHandler.GLACIO_UNOBTAINIUM_ORE);

        // Common Ore Tags
        getOrCreateTagBuilder(TagKey.create(Registries.BLOCK, new ResourceLocation("c", "ores")))
                .add(RegistryHandler.MARS_CARMOT_ORE)
                .add(RegistryHandler.MOON_STORMYX_ORE)
                .add(RegistryHandler.MERCURY_PALLADIUM_ORE)
                .add(RegistryHandler.VENUS_ORICHALCUM_ORE)
                .add(RegistryHandler.GLACIO_UNOBTAINIUM_ORE);

        // Mythic Metals specific tags
        getOrCreateTagBuilder(TagKey.create(Registries.BLOCK, new ResourceLocation("mythicmetals", "carmot_ores")))
                .add(RegistryHandler.MARS_CARMOT_ORE);
        getOrCreateTagBuilder(TagKey.create(Registries.BLOCK, new ResourceLocation("mythicmetals", "stormyx_ores")))
                .add(RegistryHandler.MOON_STORMYX_ORE);
        getOrCreateTagBuilder(TagKey.create(Registries.BLOCK, new ResourceLocation("mythicmetals", "palladium_ores")))
                .add(RegistryHandler.MERCURY_PALLADIUM_ORE);
        getOrCreateTagBuilder(TagKey.create(Registries.BLOCK, new ResourceLocation("mythicmetals", "orichalcum_ores")))
                .add(RegistryHandler.VENUS_ORICHALCUM_ORE);
        getOrCreateTagBuilder(TagKey.create(Registries.BLOCK, new ResourceLocation("mythicmetals", "unobtainium_ores")))
                .add(RegistryHandler.GLACIO_UNOBTAINIUM_ORE);
    }
}