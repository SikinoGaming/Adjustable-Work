
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.adjustablework.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.adjustablework.AdjustableWorkMod;

public class AdjustableWorkModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, AdjustableWorkMod.MODID);
	public static final RegistryObject<SoundEvent> HEARTBEATPULSE = REGISTRY.register("heartbeatpulse", () -> new SoundEvent(new ResourceLocation("adjustable_work", "heartbeatpulse")));
}
