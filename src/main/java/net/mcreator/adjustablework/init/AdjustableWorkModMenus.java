
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.adjustablework.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.adjustablework.world.inventory.WorkChoiceMenu;
import net.mcreator.adjustablework.world.inventory.LevelupMiner2Menu;
import net.mcreator.adjustablework.world.inventory.LevelupMiner1Menu;
import net.mcreator.adjustablework.world.inventory.LevelupMageMenu;
import net.mcreator.adjustablework.world.inventory.LevelupFarmer2Menu;
import net.mcreator.adjustablework.world.inventory.LevelupFarmer1Menu;
import net.mcreator.adjustablework.world.inventory.LevelupCooker2Menu;
import net.mcreator.adjustablework.world.inventory.LevelupCooker1Menu;
import net.mcreator.adjustablework.AdjustableWorkMod;

public class AdjustableWorkModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, AdjustableWorkMod.MODID);
	public static final RegistryObject<MenuType<WorkChoiceMenu>> WORK_CHOICE = REGISTRY.register("work_choice",
			() -> IForgeMenuType.create(WorkChoiceMenu::new));
	public static final RegistryObject<MenuType<LevelupCooker1Menu>> LEVELUP_COOKER_1 = REGISTRY.register("levelup_cooker_1",
			() -> IForgeMenuType.create(LevelupCooker1Menu::new));
	public static final RegistryObject<MenuType<LevelupCooker2Menu>> LEVELUP_COOKER_2 = REGISTRY.register("levelup_cooker_2",
			() -> IForgeMenuType.create(LevelupCooker2Menu::new));
	public static final RegistryObject<MenuType<LevelupMiner1Menu>> LEVELUP_MINER_1 = REGISTRY.register("levelup_miner_1",
			() -> IForgeMenuType.create(LevelupMiner1Menu::new));
	public static final RegistryObject<MenuType<LevelupMiner2Menu>> LEVELUP_MINER_2 = REGISTRY.register("levelup_miner_2",
			() -> IForgeMenuType.create(LevelupMiner2Menu::new));
	public static final RegistryObject<MenuType<LevelupFarmer1Menu>> LEVELUP_FARMER_1 = REGISTRY.register("levelup_farmer_1",
			() -> IForgeMenuType.create(LevelupFarmer1Menu::new));
	public static final RegistryObject<MenuType<LevelupFarmer2Menu>> LEVELUP_FARMER_2 = REGISTRY.register("levelup_farmer_2",
			() -> IForgeMenuType.create(LevelupFarmer2Menu::new));
	public static final RegistryObject<MenuType<LevelupMageMenu>> LEVELUP_MAGE = REGISTRY.register("levelup_mage",
			() -> IForgeMenuType.create(LevelupMageMenu::new));
}
