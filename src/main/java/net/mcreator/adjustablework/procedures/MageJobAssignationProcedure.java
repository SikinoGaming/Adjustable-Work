package net.mcreator.adjustablework.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.adjustablework.network.AdjustableWorkModVariables;

public class MageJobAssignationProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			String _setval = "Mage";
			entity.getCapability(AdjustableWorkModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Work = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (entity instanceof Player _player)
			_player.closeContainer();
	}
}
