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
public class CookerSmeltingRestrictionsProcedure {
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
		if (((entity.getCapability(AdjustableWorkModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AdjustableWorkModVariables.PlayerVariables())).Work).equals("Cooker") && (itemstack.getItem() == Items.COOKED_BEEF
				|| itemstack.getItem() == Items.COOKED_SALMON || itemstack.getItem() == Items.COOKED_PORKCHOP || itemstack.getItem() == Items.COOKED_MUTTON || itemstack.getItem() == Items.BAKED_POTATO || itemstack.getItem() == Items.COOKED_CHICKEN
				|| itemstack.getItem() == Items.COOKED_COD || itemstack.getItem() == Items.COOKED_RABBIT || itemstack.getItem() == Items.DRIED_KELP || itemstack.getItem() == Items.COOKED_CHICKEN)) {
			if ((entity.getCapability(AdjustableWorkModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AdjustableWorkModVariables.PlayerVariables())).CookerLevel < 1) {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = (itemstack.copy());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
			} else {
				if ((entity.getCapability(AdjustableWorkModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AdjustableWorkModVariables.PlayerVariables())).CookerLevel < 2 && (itemstack.getItem() == Items.COOKED_BEEF
						|| itemstack.getItem() == Items.COOKED_SALMON || itemstack.getItem() == Items.COOKED_PORKCHOP || itemstack.getItem() == Items.COOKED_MUTTON || itemstack.getItem() == Items.BAKED_POTATO
						|| itemstack.getItem() == Items.COOKED_CHICKEN || itemstack.getItem() == Items.COOKED_COD || itemstack.getItem() == Items.COOKED_RABBIT || itemstack.getItem() == Items.COOKED_CHICKEN)) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = (itemstack.copy());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
				} else {
					if ((entity.getCapability(AdjustableWorkModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AdjustableWorkModVariables.PlayerVariables())).CookerLevel < 3
							&& (itemstack.getItem() == Items.COOKED_BEEF || itemstack.getItem() == Items.COOKED_SALMON || itemstack.getItem() == Items.COOKED_PORKCHOP || itemstack.getItem() == Items.COOKED_MUTTON
									|| itemstack.getItem() == Items.COOKED_CHICKEN || itemstack.getItem() == Items.COOKED_COD || itemstack.getItem() == Items.COOKED_RABBIT || itemstack.getItem() == Items.COOKED_CHICKEN)) {
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = (itemstack.copy());
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					}
				}
			}
		} else {
			if (itemstack.getItem() == Items.COOKED_BEEF || itemstack.getItem() == Items.COOKED_SALMON || itemstack.getItem() == Items.COOKED_PORKCHOP || itemstack.getItem() == Items.COOKED_MUTTON || itemstack.getItem() == Items.BAKED_POTATO
					|| itemstack.getItem() == Items.COOKED_CHICKEN || itemstack.getItem() == Items.COOKED_COD || itemstack.getItem() == Items.COOKED_RABBIT || itemstack.getItem() == Items.DRIED_KELP || itemstack.getItem() == Items.COOKED_CHICKEN) {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = (itemstack.copy());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
			}
		}
	}
}
