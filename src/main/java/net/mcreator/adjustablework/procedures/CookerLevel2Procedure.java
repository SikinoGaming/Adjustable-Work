package net.mcreator.adjustablework.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.adjustablework.network.AdjustableWorkModVariables;

public class CookerLevel2Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _plr ? _plr.experienceLevel : 0) >= 20 && 1 <= (entity.getCapability(AdjustableWorkModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AdjustableWorkModVariables.PlayerVariables())).CookerLevel) {
			{
				double _setval = 2;
				entity.getCapability(AdjustableWorkModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CookerLevel = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player)
				_player.giveExperienceLevels(-(20));
		}
	}
}
