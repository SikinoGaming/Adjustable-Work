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
public class CookerCraftingRestrictionsProcedure {
	@SubscribeEvent
	public static void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {
		execute(event, event.getEntity(), event.getCrafting());
	}

	public static void execute(Entity entity, ItemStack itemstack) {
		execute(null, entity, itemstack);
	}

	private static void execute(@Nullable Event event, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (("Cooker").equals((entity.getCapability(AdjustableWorkModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AdjustableWorkModVariables.PlayerVariables())).Work)
				&& (itemstack.getItem() == Items.BREAD || itemstack.getItem() == Items.SUSPICIOUS_STEW || itemstack.getItem() == Items.COOKIE || itemstack.getItem() == Items.PUMPKIN_PIE || itemstack.getItem() == Items.GOLDEN_CARROT
						|| itemstack.getItem() == Items.CAKE || itemstack.getItem() == Items.GOLDEN_APPLE || itemstack.getItem() == Items.MUSHROOM_STEW || itemstack.getItem() == Items.RABBIT_STEW)) {
			if ((entity.getCapability(AdjustableWorkModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AdjustableWorkModVariables.PlayerVariables())).CookerLevel < 1
					&& (itemstack.getItem() == Items.BREAD || itemstack.getItem() == Items.SUSPICIOUS_STEW || itemstack.getItem() == Items.COOKIE || itemstack.getItem() == Items.PUMPKIN_PIE || itemstack.getItem() == Items.GOLDEN_CARROT
							|| itemstack.getItem() == Items.CAKE || itemstack.getItem() == Items.GOLDEN_APPLE || itemstack.getItem() == Items.MUSHROOM_STEW || itemstack.getItem() == Items.RABBIT_STEW)) {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = (itemstack.copy());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
			} else {
				if ((entity.getCapability(AdjustableWorkModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AdjustableWorkModVariables.PlayerVariables())).CookerLevel < 2
						&& (itemstack.getItem() == Items.SUSPICIOUS_STEW || itemstack.getItem() == Items.COOKIE || itemstack.getItem() == Items.PUMPKIN_PIE || itemstack.getItem() == Items.GOLDEN_CARROT || itemstack.getItem() == Items.CAKE
								|| itemstack.getItem() == Items.GOLDEN_APPLE || itemstack.getItem() == Items.MUSHROOM_STEW || itemstack.getItem() == Items.RABBIT_STEW)) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = (itemstack.copy());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
				} else {
					if ((entity.getCapability(AdjustableWorkModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AdjustableWorkModVariables.PlayerVariables())).CookerLevel < 3
							&& (itemstack.getItem() == Items.COOKIE || itemstack.getItem() == Items.PUMPKIN_PIE || itemstack.getItem() == Items.GOLDEN_CARROT || itemstack.getItem() == Items.GOLDEN_APPLE || itemstack.getItem() == Items.CAKE)) {
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = (itemstack.copy());
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					} else {
						if ((entity.getCapability(AdjustableWorkModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AdjustableWorkModVariables.PlayerVariables())).CookerLevel < 4
								&& (itemstack.getItem() == Items.GOLDEN_CARROT || itemstack.getItem() == Items.GOLDEN_APPLE)) {
							if (entity instanceof Player _player) {
								ItemStack _stktoremove = (itemstack.copy());
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
							}
						}
					}
				}
			}
		} else {
			if (itemstack.getItem() == Items.BREAD || itemstack.getItem() == Items.SUSPICIOUS_STEW || itemstack.getItem() == Items.COOKIE || itemstack.getItem() == Items.PUMPKIN_PIE || itemstack.getItem() == Items.GOLDEN_CARROT
					|| itemstack.getItem() == Items.CAKE || itemstack.getItem() == Items.GOLDEN_APPLE || itemstack.getItem() == Items.MUSHROOM_STEW || itemstack.getItem() == Items.RABBIT_STEW) {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = (itemstack.copy());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
			}
		}
	}
}
