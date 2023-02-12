
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.adjustablework.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.adjustablework.item.ShatteredLuminousItem;
import net.mcreator.adjustablework.item.ResetJobItem;
import net.mcreator.adjustablework.AdjustableWorkMod;

public class AdjustableWorkModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, AdjustableWorkMod.MODID);
	public static final RegistryObject<Item> RESET_JOB = REGISTRY.register("reset_job", () -> new ResetJobItem());
	public static final RegistryObject<Item> CAMOMILLE = block(AdjustableWorkModBlocks.CAMOMILLE, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Item> SHATTERED_LUMINOUS = REGISTRY.register("shattered_luminous", () -> new ShatteredLuminousItem());
	public static final RegistryObject<Item> PRIMARY_BREWING_STAND = block(AdjustableWorkModBlocks.PRIMARY_BREWING_STAND,
			CreativeModeTab.TAB_BUILDING_BLOCKS);

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
