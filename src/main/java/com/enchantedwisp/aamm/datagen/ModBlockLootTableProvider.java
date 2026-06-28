package com.enchantedwisp.aamm.datagen;

import com.enchantedwisp.aamm.registry.RegistryHandler;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

/**
 * ModBlockLootTableProvider - Generates loot tables for our custom ores.
 *
 * Each planetary ore will drop its corresponding raw Mythic Metals item.
 */
public class ModBlockLootTableProvider extends FabricBlockLootTableProvider {

    public ModBlockLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        this.add(RegistryHandler.MARS_CARMOT_ORE,
                this.createOreDrop(
                        RegistryHandler.MARS_CARMOT_ORE,
                        getMythicMetalsRawItem("raw_carmot")
                )
        );
        this.add(RegistryHandler.MOON_STORMYX_ORE,
                this.createOreDrop(
                        RegistryHandler.MOON_STORMYX_ORE,
                        getMythicMetalsRawItem("raw_stormyx")
                )
        );
        this.add(RegistryHandler.MERCURY_PALLADIUM_ORE,
                this.createOreDrop(
                        RegistryHandler.MERCURY_PALLADIUM_ORE,
                        getMythicMetalsRawItem("raw_palladium")
                )
        );
        this.add(RegistryHandler.VENUS_ORICHALCUM_ORE,
                this.createOreDrop(
                        RegistryHandler.VENUS_ORICHALCUM_ORE,
                        getMythicMetalsRawItem("raw_orichalcum")
                )
        );
        this.add(RegistryHandler.GLACIO_UNOBTAINIUM_ORE,
                this.createOreDrop(
                        RegistryHandler.GLACIO_UNOBTAINIUM_ORE,
                        getMythicMetalsRawItem("unobtainium")
                )
        );
    }

    private static Item getMythicMetalsRawItem(String rawItemName) {
        return BuiltInRegistries.ITEM.get(
                new ResourceLocation("mythicmetals", rawItemName)
        );
    }
}