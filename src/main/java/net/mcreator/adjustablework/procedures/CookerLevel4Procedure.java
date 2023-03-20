package net.mcreator.adjustablework.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.adjustablework.network.AdjustableWorkModVariables;

public class CookerLevel4Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _plr ? _plr.experienceLevel : 0) >= 50 && (entity.getCapability(AdjustableWorkModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AdjustableWorkModVariables.PlayerVariables())).CookerLevel >= 3) {
			if (entity instanceof Player _player)
				_player.giveExperienceLevels(-(50));
			{
				double _setval = 4;
				entity.getCapability(AdjustableWorkModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CookerLevel = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
