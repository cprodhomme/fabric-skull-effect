package com.example;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

// import com.example.MischievousSkullBlock.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.block.ModBlocks;

public class ExampleMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final String MOD_ID = "examplemod";
    public static final Logger LOGGER = LoggerFactory.getLogger("modid");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Initalize : " + MOD_ID);

		ModBlocks.registerModBlock();

		// Registry.register(
		// 	Registries.BLOCK,
		// 	new Identifier("tutorial", "mischievous_skull_block"), MISCHIEVOUS_SKULL_BLOCK
		// );
		// Registry.register(
		// 	Registries.ITEM,
		// 	new Identifier("tutorial", "mischievous_skull_block"), 
		//  new BlockItem(MISCHIEVOUS_SKULL_BLOCK, new Item.Settings())
		// );
	}
}
