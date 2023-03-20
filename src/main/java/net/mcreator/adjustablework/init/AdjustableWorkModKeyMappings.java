
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.adjustablework.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.adjustablework.network.AgentShiftMessage;
import net.mcreator.adjustablework.AdjustableWorkMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class AdjustableWorkModKeyMappings {
	public static final KeyMapping AGENT_SHIFT = new KeyMapping("key.adjustable_work.agent_shift", GLFW.GLFW_KEY_LEFT_SHIFT, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				AdjustableWorkMod.PACKET_HANDLER.sendToServer(new AgentShiftMessage(0, 0));
				AgentShiftMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				AGENT_SHIFT_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - AGENT_SHIFT_LASTPRESS);
				AdjustableWorkMod.PACKET_HANDLER.sendToServer(new AgentShiftMessage(1, dt));
				AgentShiftMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	private static long AGENT_SHIFT_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(AGENT_SHIFT);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				AGENT_SHIFT.consumeClick();
			}
		}
	}
}
