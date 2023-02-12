
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.adjustablework.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.levelgen.feature.Feature;

import net.mcreator.adjustablework.world.features.plants.CamomilleFeature;
import net.mcreator.adjustablework.AdjustableWorkMod;

@Mod.EventBusSubscriber
public class AdjustableWorkModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, AdjustableWorkMod.MODID);
	public static final RegistryObject<Feature<?>> CAMOMILLE = REGISTRY.register("camomille", CamomilleFeature::feature);
}
