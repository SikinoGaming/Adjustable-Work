
package net.mcreator.adjustablework.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;

import net.mcreator.adjustablework.procedures.ResetJobRightclickedProcedure;

public class ResetJobItem extends Item {
	public ResetJobItem() {
		super(new Item.Properties().tab(null).stacksTo(64).fireResistant().rarity(Rarity.COMMON));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ItemStack itemstack = ar.getObject();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		ResetJobRightclickedProcedure.execute(world, x, y, z, entity);
		return ar;
	}
}
