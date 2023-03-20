
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.adjustablework.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.adjustablework.client.gui.WorkChoiceScreen;
import net.mcreator.adjustablework.client.gui.LevelupMiner2Screen;
import net.mcreator.adjustablework.client.gui.LevelupMiner1Screen;
import net.mcreator.adjustablework.client.gui.LevelupCooker2Screen;
import net.mcreator.adjustablework.client.gui.LevelupCooker1Screen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class AdjustableWorkModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(AdjustableWorkModMenus.WORK_CHOICE.get(), WorkChoiceScreen::new);
			MenuScreens.register(AdjustableWorkModMenus.LEVELUP_COOKER_1.get(), LevelupCooker1Screen::new);
			MenuScreens.register(AdjustableWorkModMenus.LEVELUP_COOKER_2.get(), LevelupCooker2Screen::new);
			MenuScreens.register(AdjustableWorkModMenus.LEVELUP_MINER_1.get(), LevelupMiner1Screen::new);
			MenuScreens.register(AdjustableWorkModMenus.LEVELUP_MINER_2.get(), LevelupMiner2Screen::new);
		});
	}
}
