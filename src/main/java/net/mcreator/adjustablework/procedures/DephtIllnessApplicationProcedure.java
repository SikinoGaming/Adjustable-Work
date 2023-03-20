package net.mcreator.adjustablework.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.adjustablework.network.AdjustableWorkModVariables;
import net.mcreator.adjustablework.init.AdjustableWorkModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class DephtIllnessApplicationProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getY() < 45) {
			if ((entity.getCapability(AdjustableWorkModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AdjustableWorkModVariables.PlayerVariables())).MinerLevel < 1) {
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(AdjustableWorkModMobEffects.DEPHT_ILLNES.get(), 40, 1, (false), (false)));
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 40, 1, (false), (false)));
				if (30 <= AdjustableWorkModVariables.MapVariables.get(world).TickDephtIllnessCooldown && !(entity.getDisplayName().getString()).equals("Lucrenne")) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("adjustable_work:heartbeatpulse")), SoundSource.AMBIENT, 1, 1);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("adjustable_work:heartbeatpulse")), SoundSource.AMBIENT, 1, 1, false);
						}
					}
					AdjustableWorkModVariables.MapVariables.get(world).TickDephtIllnessCooldown = 0;
					AdjustableWorkModVariables.MapVariables.get(world).syncData(world);
				} else {
					AdjustableWorkModVariables.MapVariables.get(world).TickDephtIllnessCooldown = 1 + AdjustableWorkModVariables.MapVariables.get(world).TickDephtIllnessCooldown;
					AdjustableWorkModVariables.MapVariables.get(world).syncData(world);
				}
			} else {
				if ((entity.getCapability(AdjustableWorkModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AdjustableWorkModVariables.PlayerVariables())).MinerLevel < 2 && entity.getY() < 15) {
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(AdjustableWorkModMobEffects.DEPHT_ILLNES.get(), 40, 1, (false), (false)));
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 40, 1, (false), (false)));
					if (30 <= AdjustableWorkModVariables.MapVariables.get(world).TickDephtIllnessCooldown && !(entity.getDisplayName().getString()).equals("Lucrenne")) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, new BlockPos(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("adjustable_work:heartbeatpulse")), SoundSource.AMBIENT, 1, 1);
							} else {
								_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("adjustable_work:heartbeatpulse")), SoundSource.AMBIENT, 1, 1, false);
							}
						}
						AdjustableWorkModVariables.MapVariables.get(world).TickDephtIllnessCooldown = 0;
						AdjustableWorkModVariables.MapVariables.get(world).syncData(world);
					} else {
						AdjustableWorkModVariables.MapVariables.get(world).TickDephtIllnessCooldown = 1 + AdjustableWorkModVariables.MapVariables.get(world).TickDephtIllnessCooldown;
						AdjustableWorkModVariables.MapVariables.get(world).syncData(world);
					}
				} else {
					if ((entity.getCapability(AdjustableWorkModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AdjustableWorkModVariables.PlayerVariables())).MinerLevel < 3 && entity.getY() < -15) {
						if (entity instanceof LivingEntity _entity)
							_entity.addEffect(new MobEffectInstance(AdjustableWorkModMobEffects.DEPHT_ILLNES.get(), 40, 1, (false), (false)));
						if (entity instanceof LivingEntity _entity)
							_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 40, 1, (false), (false)));
						if (30 <= AdjustableWorkModVariables.MapVariables.get(world).TickDephtIllnessCooldown && !(entity.getDisplayName().getString()).equals("Lucrenne")) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, new BlockPos(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("adjustable_work:heartbeatpulse")), SoundSource.AMBIENT, 1, 1);
								} else {
									_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("adjustable_work:heartbeatpulse")), SoundSource.AMBIENT, 1, 1, false);
								}
							}
							AdjustableWorkModVariables.MapVariables.get(world).TickDephtIllnessCooldown = 0;
							AdjustableWorkModVariables.MapVariables.get(world).syncData(world);
						} else {
							AdjustableWorkModVariables.MapVariables.get(world).TickDephtIllnessCooldown = 1 + AdjustableWorkModVariables.MapVariables.get(world).TickDephtIllnessCooldown;
							AdjustableWorkModVariables.MapVariables.get(world).syncData(world);
						}
					} else {
						if ((entity.getCapability(AdjustableWorkModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AdjustableWorkModVariables.PlayerVariables())).MinerLevel < 4 && entity.getY() < -45) {
							if (entity instanceof LivingEntity _entity)
								_entity.addEffect(new MobEffectInstance(AdjustableWorkModMobEffects.DEPHT_ILLNES.get(), 40, 1, (false), (false)));
							if (entity instanceof LivingEntity _entity)
								_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 40, 1, (false), (false)));
							if (30 <= AdjustableWorkModVariables.MapVariables.get(world).TickDephtIllnessCooldown && !(entity.getDisplayName().getString()).equals("Lucrenne")) {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, new BlockPos(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("adjustable_work:heartbeatpulse")), SoundSource.AMBIENT, 1, 1);
									} else {
										_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("adjustable_work:heartbeatpulse")), SoundSource.AMBIENT, 1, 1, false);
									}
								}
								AdjustableWorkModVariables.MapVariables.get(world).TickDephtIllnessCooldown = 0;
								AdjustableWorkModVariables.MapVariables.get(world).syncData(world);
							} else {
								AdjustableWorkModVariables.MapVariables.get(world).TickDephtIllnessCooldown = 1 + AdjustableWorkModVariables.MapVariables.get(world).TickDephtIllnessCooldown;
								AdjustableWorkModVariables.MapVariables.get(world).syncData(world);
							}
						}
					}
				}
			}
		}
	}
}
