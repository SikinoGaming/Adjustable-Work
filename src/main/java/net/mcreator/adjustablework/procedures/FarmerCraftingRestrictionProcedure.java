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
public class FarmerCraftingRestrictionProcedure {
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
		if (itemstack.getItem() == Items.IRON_HOE || itemstack.getItem() == Items.GOLDEN_HOE || itemstack.getItem() == Items.STONE_HOE
				|| itemstack.getItem() == Items.DIAMOND_HOE || itemstack.getItem() == Items.NETHERITE_HOE
				|| itemstack.getItem() == Items.WOODEN_HOE) {
			if ((entity.getCapability(AdjustableWorkModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new AdjustableWorkModVariables.PlayerVariables())).FarmerLevel < 1
					&& (itemstack.getItem() == Items.IRON_HOE || itemstack.getItem() == Items.GOLDEN_HOE || itemstack.getItem() == Items.STONE_HOE
							|| itemstack.getItem() == Items.DIAMOND_HOE || itemstack.getItem() == Items.NETHERITE_HOE
							|| itemstack.getItem() == Items.WOODEN_HOE)) {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = (itemstack.copy());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1,
							_player.inventoryMenu.getCraftSlots());
				}
			} else {
				if ((entity.getCapability(AdjustableWorkModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new AdjustableWorkModVariables.PlayerVariables())).FarmerLevel < 2
						&& (itemstack.getItem() == Items.IRON_HOE || itemstack.getItem() == Items.GOLDEN_HOE
								|| itemstack.getItem() == Items.DIAMOND_HOE || itemstack.getItem() == Items.NETHERITE_HOE)) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = (itemstack.copy());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1,
								_player.inventoryMenu.getCraftSlots());
					}
				} else {
					if ((entity.getCapability(AdjustableWorkModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new AdjustableWorkModVariables.PlayerVariables())).FarmerLevel < 3
							&& (itemstack.getItem() == Items.GOLDEN_HOE || itemstack.getItem() == Items.DIAMOND_HOE
									|| itemstack.getItem() == Items.NETHERITE_HOE)) {
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = (itemstack.copy());
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1,
									_player.inventoryMenu.getCraftSlots());
						}
					} else {
						if ((entity.getCapability(AdjustableWorkModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new AdjustableWorkModVariables.PlayerVariables())).FarmerLevel < 4
								&& (itemstack.getItem() == Items.GOLDEN_HOE || itemstack.getItem() == Items.NETHERITE_HOE)) {
							if (entity instanceof Player _player) {
								ItemStack _stktoremove = (itemstack.copy());
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1,
										_player.inventoryMenu.getCraftSlots());
							}
						} else {
							if ((entity.getCapability(AdjustableWorkModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new AdjustableWorkModVariables.PlayerVariables())).FarmerLevel < 5
									&& itemstack.getItem() == Items.GOLDEN_HOE) {
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
}
