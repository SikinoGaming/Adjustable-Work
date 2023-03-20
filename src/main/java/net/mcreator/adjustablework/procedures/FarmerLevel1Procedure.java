package net.mcreator.adjustablework.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.adjustablework.network.AdjustableWorkModVariables;

public class FarmerLevel1Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _plr ? _plr.experienceLevel : 0) >= 10) {
			if (entity instanceof Player _player)
				_player.giveExperienceLevels(-(10));
			{
				double _setval = 1;
				entity.getCapability(AdjustableWorkModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.FarmerLevel = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
