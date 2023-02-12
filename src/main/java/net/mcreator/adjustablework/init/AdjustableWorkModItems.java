
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.adjustablework.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.mcreator.adjustablework.item.ResetJobItem;
import net.mcreator.adjustablework.AdjustableWorkMod;

public class AdjustableWorkModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, AdjustableWorkMod.MODID);
	public static final RegistryObject<Item> RESET_JOB = REGISTRY.register("reset_job", () -> new ResetJobItem());
}
