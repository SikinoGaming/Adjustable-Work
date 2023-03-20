package net.mcreator.adjustablework.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.adjustablework.world.inventory.LevelupFarmer1Menu;
import net.mcreator.adjustablework.procedures.FarmerLevel3buttonProcedure;
import net.mcreator.adjustablework.procedures.FarmerLevel2buttonProcedure;
import net.mcreator.adjustablework.procedures.FarmerLevel1buttonProcedure;
import net.mcreator.adjustablework.network.LevelupFarmer1ButtonMessage;
import net.mcreator.adjustablework.AdjustableWorkMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class LevelupFarmer1Screen extends AbstractContainerScreen<LevelupFarmer1Menu> {
	private final static HashMap<String, Object> guistate = LevelupFarmer1Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public LevelupFarmer1Screen(LevelupFarmer1Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 320;
		this.imageHeight = 170;
	}

	private static final ResourceLocation texture = new ResourceLocation("adjustable_work:textures/screens/levelup_farmer_1.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("adjustable_work:textures/screens/stone_hoe.png"));
		this.blit(ms, this.leftPos + 15, this.topPos + 45, 0, 0, 80, 80, 80, 80);

		RenderSystem.setShaderTexture(0, new ResourceLocation("adjustable_work:textures/screens/iron_hoe.png"));
		this.blit(ms, this.leftPos + 96, this.topPos + 45, 0, 0, 80, 80, 80, 80);

		RenderSystem.setShaderTexture(0, new ResourceLocation("adjustable_work:textures/screens/diamond_hoe.png"));
		this.blit(ms, this.leftPos + 195, this.topPos + 45, 0, 0, 80, 80, 80, 80);

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
		this.font.draw(poseStack, "10 niveaux", 24, 135, -12829636);
		this.font.draw(poseStack, "20 niveaux", 114, 135, -12829636);
		this.font.draw(poseStack, "30 niveaux", 204, 135, -12829636);
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
		this.addRenderableWidget(new Button(this.leftPos + 24, this.topPos + 18, 67, 20, Component.literal("Debutant"), e -> {
			if (FarmerLevel1buttonProcedure.execute(entity)) {
				AdjustableWorkMod.PACKET_HANDLER.sendToServer(new LevelupFarmer1ButtonMessage(0, x, y, z));
				LevelupFarmer1ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (FarmerLevel1buttonProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 114, this.topPos + 18, 56, 20, Component.literal("Avancé"), e -> {
			if (FarmerLevel2buttonProcedure.execute(entity)) {
				AdjustableWorkMod.PACKET_HANDLER.sendToServer(new LevelupFarmer1ButtonMessage(1, x, y, z));
				LevelupFarmer1ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (FarmerLevel2buttonProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 195, this.topPos + 18, 88, 20, Component.literal("Professionel"), e -> {
			if (FarmerLevel3buttonProcedure.execute(entity)) {
				AdjustableWorkMod.PACKET_HANDLER.sendToServer(new LevelupFarmer1ButtonMessage(2, x, y, z));
				LevelupFarmer1ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (FarmerLevel3buttonProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 263, this.topPos + 145, 51, 20, Component.literal("Suivant"), e -> {
			if (true) {
				AdjustableWorkMod.PACKET_HANDLER.sendToServer(new LevelupFarmer1ButtonMessage(3, x, y, z));
				LevelupFarmer1ButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}));
	}
}
