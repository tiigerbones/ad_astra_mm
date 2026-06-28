package com.enchantedwisp.aamm.registry;

import com.enchantedwisp.aamm.AdAstraMythicMetals;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import org.slf4j.Logger;

public final class RegistryHandler {

    private static final Logger LOGGER = AdAstraMythicMetals.LOGGER;

    public static final Block MARS_CARMOT_ORE = new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE));
    public static final Block MOON_STORMYX_ORE = new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE));
    public static final Block MERCURY_PALLADIUM_ORE = new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE));
    public static final Block VENUS_ORICHALCUM_ORE = new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE));
    public static final Block GLACIO_UNOBTAINIUM_ORE = new Block(BlockBehaviour.Properties.copy(Blocks.ANCIENT_DEBRIS));

    public static final Item MARS_CARMOT_ORE_ITEM = new BlockItem(MARS_CARMOT_ORE, new Item.Properties());
    public static final Item MOON_STORMYX_ORE_ITEM = new BlockItem(MOON_STORMYX_ORE, new Item.Properties());
    public static final Item MERCURY_PALLADIUM_ORE_ITEM = new BlockItem(MERCURY_PALLADIUM_ORE, new Item.Properties());
    public static final Item VENUS_ORICHALCUM_ORE_ITEM = new BlockItem(VENUS_ORICHALCUM_ORE, new Item.Properties());
    public static final Item GLACIO_UNOBTAINIUM_ORE_ITEM = new BlockItem(GLACIO_UNOBTAINIUM_ORE, new Item.Properties());

    public static void register() {
        LOGGER.info("Registering blocks and items for Ad Astra: Mythic Metals");

        // Register Blocks
        registerBlock("mars_carmot_ore", MARS_CARMOT_ORE);
        registerBlock("moon_stormyx_ore", MOON_STORMYX_ORE);
        registerBlock("mercury_palladium_ore", MERCURY_PALLADIUM_ORE);
        registerBlock("venus_orichalcum_ore", VENUS_ORICHALCUM_ORE);
        registerBlock("glacio_unobtainium_ore", GLACIO_UNOBTAINIUM_ORE);

        // Register Items
        registerItem("mars_carmot_ore", MARS_CARMOT_ORE_ITEM);
        registerItem("moon_stormyx_ore", MOON_STORMYX_ORE_ITEM);
        registerItem("mercury_palladium_ore", MERCURY_PALLADIUM_ORE_ITEM);
        registerItem("venus_orichalcum_ore", VENUS_ORICHALCUM_ORE_ITEM);
        registerItem("glacio_unobtainium_ore", GLACIO_UNOBTAINIUM_ORE_ITEM);

        // Add to Ad Astra creative tab
        registerToCreativeTab();
    }

    private static void registerBlock(String name, Block block) {
        Registry.register(
                BuiltInRegistries.BLOCK,
                AdAstraMythicMetals.id(name),
                block
        );
    }

    private static void registerItem(String name, Item item) {
        Registry.register(
                BuiltInRegistries.ITEM,
                AdAstraMythicMetals.id(name),
                item
        );
    }

    private static void registerToCreativeTab() {
        ItemGroupEvents.modifyEntriesEvent(
                ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation("ad_astra", "main"))
        ).register(entries -> {
            entries.prepend(MARS_CARMOT_ORE_ITEM);
            entries.prepend(MOON_STORMYX_ORE_ITEM);
            entries.prepend(MERCURY_PALLADIUM_ORE_ITEM);
            entries.prepend(VENUS_ORICHALCUM_ORE_ITEM);
            entries.prepend(GLACIO_UNOBTAINIUM_ORE_ITEM);
        });
    }
}