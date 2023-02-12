
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.adjustablework.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.adjustablework.potion.DephtIllnesMobEffect;
import net.mcreator.adjustablework.AdjustableWorkMod;

public class AdjustableWorkModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, AdjustableWorkMod.MODID);
	public static final RegistryObject<MobEffect> DEPHT_ILLNES = REGISTRY.register("depht_illnes", () -> new DephtIllnesMobEffect());
}
