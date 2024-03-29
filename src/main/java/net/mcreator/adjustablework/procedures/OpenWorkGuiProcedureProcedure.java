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

import net.mcreator.adjustablework.world.inventory.LevelupMiner1Menu;
import net.mcreator.adjustablework.world.inventory.LevelupMageMenu;
import net.mcreator.adjustablework.world.inventory.LevelupFarmer1Menu;
import net.mcreator.adjustablework.world.inventory.LevelupCooker1Menu;
import net.mcreator.adjustablework.network.AdjustableWorkModVariables;

import io.netty.buffer.Unpooled;

public class OpenWorkGuiProcedureProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (("Cooker").equals((entity.getCapability(AdjustableWorkModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AdjustableWorkModVariables.PlayerVariables())).Work)) {
			if (entity instanceof Player _player)
				_player.closeContainer();
			{
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = new BlockPos(x, y, z);
					NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("LevelupCooker1");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new LevelupCooker1Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
		} else {
			if (("Miner").equals((entity.getCapability(AdjustableWorkModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new AdjustableWorkModVariables.PlayerVariables())).Work)) {
				if (entity instanceof Player _player)
					_player.closeContainer();
				{
					if (entity instanceof ServerPlayer _ent) {
						BlockPos _bpos = new BlockPos(x, y, z);
						NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("LevelupMiner1");
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new LevelupMiner1Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _bpos);
					}
				}
			} else {
				if (("Farmer").equals((entity.getCapability(AdjustableWorkModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new AdjustableWorkModVariables.PlayerVariables())).Work)) {
					if (entity instanceof Player _player)
						_player.closeContainer();
					{
						if (entity instanceof ServerPlayer _ent) {
							BlockPos _bpos = new BlockPos(x, y, z);
							NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
								@Override
								public Component getDisplayName() {
									return Component.literal("LevelupFarmer1");
								}

								@Override
								public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
									return new LevelupFarmer1Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
								}
							}, _bpos);
						}
					}
				} else {
					if (("Mage").equals((entity.getCapability(AdjustableWorkModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new AdjustableWorkModVariables.PlayerVariables())).Work)) {
						if (entity instanceof Player _player)
							_player.closeContainer();
						{
							if (entity instanceof ServerPlayer _ent) {
								BlockPos _bpos = new BlockPos(x, y, z);
								NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
									@Override
									public Component getDisplayName() {
										return Component.literal("LevelupMage");
									}

									@Override
									public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
										return new LevelupMageMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
									}
								}, _bpos);
							}
						}
					}
				}
			}
		}
	}
}
