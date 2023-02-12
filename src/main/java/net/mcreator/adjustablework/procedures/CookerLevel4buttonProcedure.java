package net.mcreator.adjustablework.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.adjustablework.network.AdjustableWorkModVariables;

public class CookerLevel4buttonProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity.getCapability(AdjustableWorkModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new AdjustableWorkModVariables.PlayerVariables())).CookerLevel < 4;
	}
}
