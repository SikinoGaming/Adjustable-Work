
package net.mcreator.adjustablework.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.adjustablework.world.inventory.LevelupFarmer2Menu;
import net.mcreator.adjustablework.procedures.FarmerLevel4buttonProcedure;
import net.mcreator.adjustablework.network.LevelupFarmer2ButtonMessage;
import net.mcreator.adjustablework.AdjustableWorkMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class LevelupFarmer2Screen extends AbstractContainerScreen<LevelupFarmer2Menu> {
	private final static HashMap<String, Object> guistate = LevelupFarmer2Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public LevelupFarmer2Screen(LevelupFarmer2Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 320;
		this.imageHeight = 170;
	}

	private static final ResourceLocation texture = new ResourceLocation("adjustable_work:textures/screens/levelup_farmer_2.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		RenderSystem.setShaderTexture(0, new ResourceLocation("adjustable_work:textures/screens/netherite_hoe.png"));
		this.blit(ms, this.leftPos + 115, this.topPos + 44, 0, 0, 80, 80, 80, 80);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "50 niveaux", 129, 134, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		this.addRenderableWidget(new Button(this.leftPos + 130, this.topPos + 12, 51, 20, Component.literal("Divin"), e -> {
			if (FarmerLevel4buttonProcedure.execute(entity)) {
				AdjustableWorkMod.PACKET_HANDLER.sendToServer(new LevelupFarmer2ButtonMessage(0, x, y, z));
				LevelupFarmer2ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (FarmerLevel4buttonProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 4, this.topPos + 143, 56, 20, Component.literal("Retour"), e -> {
			if (true) {
				AdjustableWorkMod.PACKET_HANDLER.sendToServer(new LevelupFarmer2ButtonMessage(1, x, y, z));
				LevelupFarmer2ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
	}
}
