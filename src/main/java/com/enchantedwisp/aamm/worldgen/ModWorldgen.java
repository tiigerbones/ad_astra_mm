package com.enchantedwisp.aamm.worldgen;

import com.enchantedwisp.aamm.AdAstraMythicMetals;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeModification;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public final class ModWorldgen {

    private ModWorldgen() {}

    private static final ResourceKey<PlacedFeature> ORE_CARMOT =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation("mythicmetals", "ore_carmot"));

    private static final ResourceKey<PlacedFeature> ORE_STORMYX =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation("mythicmetals", "ore_stormyx"));

    private static final ResourceKey<PlacedFeature> ORE_ORICHALCUM =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation("mythicmetals", "ore_orichalcum"));

    private static final ResourceKey<PlacedFeature> ORE_PALLADIUM =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation("mythicmetals", "ore_palladium"));

    private static final ResourceKey<PlacedFeature> ORE_UNOBTAINIUM =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation("mythicmetals", "ore_unobtainium"));

    public static void init() {
        AdAstraMythicMetals.LOGGER.info("Removing normal Mythic Metals overworld ores...");

        // Create one modification set for removing ores
        BiomeModification removal = BiomeModifications.create(
                new ResourceLocation(AdAstraMythicMetals.MOD_ID, "remove_mythic_ores")
        );

        // Remove from Overworld
        removal.add(
                ModificationPhase.REMOVALS,
                BiomeSelectors.foundInOverworld(),
                context -> {
                    context.getGenerationSettings().removeFeature(
                            GenerationStep.Decoration.UNDERGROUND_ORES, ORE_CARMOT);
                    context.getGenerationSettings().removeFeature(
                            GenerationStep.Decoration.UNDERGROUND_ORES, ORE_ORICHALCUM);
                    context.getGenerationSettings().removeFeature(
                            GenerationStep.Decoration.UNDERGROUND_ORES, ORE_UNOBTAINIUM);
                }
        );

        // Remove from the Nether
        removal.add(
                ModificationPhase.REMOVALS,
                BiomeSelectors.foundInTheNether(),
                context -> {
                    context.getGenerationSettings().removeFeature(
                            GenerationStep.Decoration.UNDERGROUND_DECORATION, ORE_PALLADIUM);
                    context.getGenerationSettings().removeFeature(
                            GenerationStep.Decoration.UNDERGROUND_DECORATION, ORE_STORMYX);
                }
        );
    }
}