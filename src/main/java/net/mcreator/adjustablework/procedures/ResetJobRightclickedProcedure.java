package net.mcreator.adjustablework.procedures;

import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.adjustablework.world.inventory.WorkChoiceMenu;
import net.mcreator.adjustablework.network.AdjustableWorkModVariables;

import io.netty.buffer.Unpooled;

public class ResetJobRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = new BlockPos(x, y, z);
				NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("WorkChoice");
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new WorkChoiceMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		{
			double _setval = 0;
			entity.getCapability(AdjustableWorkModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.CookerLevel = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = 0;
			entity.getCapability(AdjustableWorkModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.MinerLevel = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = 0;
			entity.getCapability(AdjustableWorkModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.FarmerLevel = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = 0;
			entity.getCapability(AdjustableWorkModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.MageLevel = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = 0;
			entity.getCapability(AdjustableWorkModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.ArchitectLevel = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = 0;
			entity.getCapability(AdjustableWorkModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.FishermanLevel = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = 0;
			entity.getCapability(AdjustableWorkModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.AgentLevel = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = 0;
			entity.getCapability(AdjustableWorkModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.EngineerLevel = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
