
package net.mcreator.adjustablework.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.adjustablework.world.inventory.LevelupMageMenu;
import net.mcreator.adjustablework.procedures.MageLevel2buttonProcedure;
import net.mcreator.adjustablework.procedures.MageLevel1buttonProcedure;
import net.mcreator.adjustablework.network.LevelupMageButtonMessage;
import net.mcreator.adjustablework.AdjustableWorkMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class LevelupMageScreen extends AbstractContainerScreen<LevelupMageMenu> {
	private final static HashMap<String, Object> guistate = LevelupMageMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public LevelupMageScreen(LevelupMageMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 320;
		this.imageHeight = 170;
	}

	private static final ResourceLocation texture = new ResourceLocation("adjustable_work:textures/screens/levelup_mage.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("adjustable_work:textures/screens/index.png"));
		this.blit(ms, this.leftPos + 24, this.topPos + 53, 0, 0, 80, 80, 80, 80);

		RenderSystem.setShaderTexture(0, new ResourceLocation("adjustable_work:textures/screens/table_denchantement.png"));
		this.blit(ms, this.leftPos + 121, this.topPos + 29, 0, 0, 112, 112, 112, 112);

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
		this.font.draw(poseStack, "10 niveaux", 38, 143, -12829636);
		this.font.draw(poseStack, "30 niveaux", 150, 143, -12829636);
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
		this.addRenderableWidget(new Button(this.leftPos + 29, this.topPos + 12, 67, 20, Component.literal("Débutant"), e -> {
			if (MageLevel1buttonProcedure.execute(entity)) {
				AdjustableWorkMod.PACKET_HANDLER.sendToServer(new LevelupMageButtonMessage(0, x, y, z));
				LevelupMageButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (MageLevel1buttonProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 149, this.topPos + 12, 56, 20, Component.literal("Avancé"), e -> {
			if (MageLevel2buttonProcedure.execute(entity)) {
				AdjustableWorkMod.PACKET_HANDLER.sendToServer(new LevelupMageButtonMessage(1, x, y, z));
				LevelupMageButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (MageLevel2buttonProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
	}
}
