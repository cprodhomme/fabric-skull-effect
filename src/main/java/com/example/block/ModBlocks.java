package com.example.block;

import com.example.ExampleMod;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
  public static final Block MISCHIEVOUS_SKULL_BLOCK = registerBlock(
    MischievousSkullBlock.IDENTIFIER,
    MischievousSkullBlock.MISCHIEVOUS_SKULL_BLOCK
  );

  private static Block registerBlock(String name, Block block) {
    return Registry.register(
      Registries.BLOCK,
      new Identifier(ExampleMod.MOD_ID, name),
      block
    );
  }

  private static Item registerBlockItem(String name, Block block) {
    return Registry.register(
      Registries.ITEM,
      new Identifier(ExampleMod.MOD_ID, name),
      new BlockItem(block, new Item.Settings())
    );
  }

  public static void registerModBlock() {
    ExampleMod.LOGGER.debug("Registrering ModBlocks for " + ExampleMod.MOD_ID);
  }
}
