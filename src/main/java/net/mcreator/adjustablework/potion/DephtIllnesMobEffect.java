
package net.mcreator.adjustablework.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.adjustablework.procedures.DephtIllnessApplicationProcedure;

public class DephtIllnesMobEffect extends MobEffect {
	public DephtIllnesMobEffect() {
		super(MobEffectCategory.NEUTRAL, -1);
	}

	@Override
	public String getDescriptionId() {
		return "effect.adjustable_work.depht_illnes";
	}

	@Override
	public boolean isInstantenous() {
		return true;
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		DephtIllnessApplicationProcedure.execute(entity.level, entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
