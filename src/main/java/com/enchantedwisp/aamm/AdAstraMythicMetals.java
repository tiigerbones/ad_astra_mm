package com.enchantedwisp.aamm;

import com.enchantedwisp.aamm.registry.RegistryHandler;
import com.enchantedwisp.aamm.worldgen.ModWorldgen;
import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.ResourceLocation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdAstraMythicMetals implements ModInitializer {
	public static final String MOD_ID = "ad_astra_mm";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		RegistryHandler.register();
		ModWorldgen.init();

		LOGGER.info("Ad Astra: Mythic Metals initialized successfully!");
	}

	public static ResourceLocation id(String path) {
		return new ResourceLocation(MOD_ID, path);
	}
}