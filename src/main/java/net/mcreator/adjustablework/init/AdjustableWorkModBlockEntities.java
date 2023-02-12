
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.adjustablework.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.adjustablework.block.entity.PrimaryBrewingStandBlockEntity;
import net.mcreator.adjustablework.AdjustableWorkMod;

public class AdjustableWorkModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES,
			AdjustableWorkMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> PRIMARY_BREWING_STAND = register("primary_brewing_stand",
			AdjustableWorkModBlocks.PRIMARY_BREWING_STAND, PrimaryBrewingStandBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block,
			BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
