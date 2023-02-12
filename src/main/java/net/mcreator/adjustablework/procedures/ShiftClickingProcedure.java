package net.mcreator.adjustablework.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.adjustablework.network.AdjustableWorkModVariables;

public class ShiftClickingProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			boolean _setval = true;
			entity.getCapability(AdjustableWorkModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.ShiftIsActive = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
