
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.adjustablework.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.adjustablework.block.PrimaryBrewingStandBlock;
import net.mcreator.adjustablework.block.CamomilleBlock;
import net.mcreator.adjustablework.AdjustableWorkMod;

public class AdjustableWorkModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, AdjustableWorkMod.MODID);
	public static final RegistryObject<Block> CAMOMILLE = REGISTRY.register("camomille", () -> new CamomilleBlock());
	public static final RegistryObject<Block> PRIMARY_BREWING_STAND = REGISTRY.register("primary_brewing_stand",
			() -> new PrimaryBrewingStandBlock());
}
