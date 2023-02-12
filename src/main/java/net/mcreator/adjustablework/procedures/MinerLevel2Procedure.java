package net.mcreator.adjustablework.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.adjustablework.network.AdjustableWorkModVariables;

public class MinerLevel2Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (20 <= (entity instanceof Player _plr ? _plr.experienceLevel : 0)) {
			if (entity instanceof Player _player)
				_player.giveExperienceLevels(-(20));
			{
				double _setval = 2;
				entity.getCapability(AdjustableWorkModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MinerLevel = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
