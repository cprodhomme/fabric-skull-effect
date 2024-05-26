package com.example.block;
// package mods.mischievousskullblock;

import java.util.Random;

import com.example.ExampleMod;

import net.minecraft.block.BlockState;
import net.minecraft.block.WitherSkullBlock;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

// public class MischievousSkullBlock extends WitherSkullBlock {
public class MischievousSkullBlock extends WitherSkullBlock {

  public MischievousSkullBlock(Settings settings) {
    super(settings);
  }

  // Méthode appelée lorsqu'un bloc est cassé
  @Override
  public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
    ExampleMod.LOGGER.debug("break MischievousSkullBlock");
    world.playSound(player, pos, SoundEvents.ENTITY_WITHER_DEATH, SoundCategory.BLOCKS, 0.5f, 0.5f);

    // Appliquer un effet aléatoire au joueur
    applyRandomEffect(player);
    return state;
  }

  // Méthode pour appliquer un effet aléatoire au joueur
  private void applyRandomEffect(PlayerEntity player) {
    Random random = new Random();

    int randomEffectIndex = random.nextInt(5) + 1;

    // Créer une nouvelle instance d'effet aléatoire
    RegistryEntry<StatusEffect> randomEffect = getRandomEffect(randomEffectIndex);

    // Appliquer l'effet au joueur
    Integer amplifier = calculLevelEffect(player, randomEffect);

    StatusEffectInstance statusEffectInstance = new StatusEffectInstance(randomEffect, Integer.MAX_VALUE, amplifier);
    player.addStatusEffect(statusEffectInstance);
  }

  // assigne effet niveau 1 (amplifier 0) par défaut
  // assigne effet niveau 2 (amplifier 1) si le joueur possède déjà l'effet
  private Integer calculLevelEffect(PlayerEntity player, RegistryEntry<StatusEffect> effect) {
    Integer level = 0;
    Boolean hasStatus = player.hasStatusEffect(effect);
    if (hasStatus) {
      level += 1;
    }
    return level;
  }

  // Méthode pour obtenir un effet aléatoire en fonction de l'index
  private RegistryEntry<StatusEffect> getRandomEffect(int index) {
    switch (index) {
      case 1:
        return StatusEffects.STRENGTH;
      case 2:
        return StatusEffects.HASTE;
      case 3:
        return StatusEffects.JUMP_BOOST;
      case 4:
        return StatusEffects.SPEED;
      case 5:
        return StatusEffects.NIGHT_VISION;
      default:
        return StatusEffects.STRENGTH;
    }
  }
}
