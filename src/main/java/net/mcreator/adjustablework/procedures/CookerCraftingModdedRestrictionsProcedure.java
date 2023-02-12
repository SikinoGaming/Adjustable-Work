package net.mcreator.adjustablework.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.adjustablework.network.AdjustableWorkModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class MinerSmeltingRestrictionsProcedure {
	@SubscribeEvent
	public static void onItemSmelted(PlayerEvent.ItemSmeltedEvent event) {
		execute(event, event.getEntity(), event.getSmelting());
	}

	public static void execute(Entity entity, ItemStack itemstack) {
		execute(null, entity, itemstack);
	}

	private static void execute(@Nullable Event event, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getItem() == Items.IRON_INGOT || itemstack.getItem() == Items.GOLD_INGOT || itemstack.getItem() == Items.COAL
				|| itemstack.getItem() == Items.DIAMOND || itemstack.getItem() == Items.LAPIS_LAZULI || itemstack.getItem() == Items.NETHERITE_SCRAP
				|| itemstack.getItem() == Items.COPPER_INGOT) {
			if ((entity.getCapability(AdjustableWorkModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new AdjustableWorkModVariables.PlayerVariables())).MinerLevel < 1) {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = (itemstack.copy());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1,
							_player.inventoryMenu.getCraftSlots());
				}
			} else {
				if ((entity.getCapability(AdjustableWorkModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new AdjustableWorkModVariables.PlayerVariables())).MinerLevel < 2
						&& (itemstack.getItem() == Items.GOLD_INGOT || itemstack.getItem() == Items.DIAMOND
								|| itemstack.getItem() == Items.LAPIS_LAZULI || itemstack.getItem() == Items.NETHERITE_SCRAP)) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = (itemstack.copy());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1,
								_player.inventoryMenu.getCraftSlots());
					}
				} else {
					if ((entity.getCapability(AdjustableWorkModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new AdjustableWorkModVariables.PlayerVariables())).MinerLevel < 3
							&& (itemstack.getItem() == Items.DIAMOND || itemstack.getItem() == Items.NETHERITE_SCRAP)) {
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = (itemstack.copy());
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1,
									_player.inventoryMenu.getCraftSlots());
						}
					} else {
						if ((entity.getCapability(AdjustableWorkModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new AdjustableWorkModVariables.PlayerVariables())).MinerLevel < 4
								&& itemstack.getItem() == Items.NETHERITE_SCRAP) {
							if (entity instanceof Player _player) {
								ItemStack _stktoremove = (itemstack.copy());
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1,
										_player.inventoryMenu.getCraftSlots());
							}
						}
					}
				}
			}
		}
	}
}
