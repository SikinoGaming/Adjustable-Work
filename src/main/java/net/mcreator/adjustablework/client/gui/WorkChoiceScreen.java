
package net.mcreator.adjustablework.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.adjustablework.world.inventory.WorkChoiceMenu;
import net.mcreator.adjustablework.network.WorkChoiceButtonMessage;
import net.mcreator.adjustablework.AdjustableWorkMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class WorkChoiceScreen extends AbstractContainerScreen<WorkChoiceMenu> {
	private final static HashMap<String, Object> guistate = WorkChoiceMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public WorkChoiceScreen(WorkChoiceMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 240;
		this.imageHeight = 170;
	}

	private static final ResourceLocation texture = new ResourceLocation("adjustable_work:textures/screens/work_choice.png");

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
		this.font.draw(poseStack, "S\u00E9l\u00E9ctionne ton m\u00E9tier :", 56, 18, -16777216);
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
		this.addRenderableWidget(new Button(this.leftPos + 137, this.topPos + 36, 71, 20, Component.literal("  Mineur "), e -> {
			if (true) {
				AdjustableWorkMod.PACKET_HANDLER.sendToServer(new WorkChoiceButtonMessage(0, x, y, z));
				WorkChoiceButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 137, this.topPos + 63, 71, 20, Component.literal(" Fermier "), e -> {
			if (true) {
				AdjustableWorkMod.PACKET_HANDLER.sendToServer(new WorkChoiceButtonMessage(1, x, y, z));
				WorkChoiceButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 137, this.topPos + 90, 71, 20, Component.literal(" Pêcheur "), e -> {
			if (true) {
				AdjustableWorkMod.PACKET_HANDLER.sendToServer(new WorkChoiceButtonMessage(2, x, y, z));
				WorkChoiceButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 29, this.topPos + 117, 77, 20, Component.literal("Architecte"), e -> {
			if (true) {
				AdjustableWorkMod.PACKET_HANDLER.sendToServer(new WorkChoiceButtonMessage(3, x, y, z));
				WorkChoiceButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 29, this.topPos + 90, 77, 20, Component.literal("Ingénieur "), e -> {
			if (true) {
				AdjustableWorkMod.PACKET_HANDLER.sendToServer(new WorkChoiceButtonMessage(4, x, y, z));
				WorkChoiceButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 29, this.topPos + 63, 76, 20, Component.literal("Forgemage"), e -> {
			if (true) {
				AdjustableWorkMod.PACKET_HANDLER.sendToServer(new WorkChoiceButtonMessage(5, x, y, z));
				WorkChoiceButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 29, this.topPos + 36, 77, 20, Component.literal("Cuisinier "), e -> {
			if (true) {
				AdjustableWorkMod.PACKET_HANDLER.sendToServer(new WorkChoiceButtonMessage(6, x, y, z));
				WorkChoiceButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 137, this.topPos + 117, 71, 20, Component.literal("  Agent  "), e -> {
			if (true) {
				AdjustableWorkMod.PACKET_HANDLER.sendToServer(new WorkChoiceButtonMessage(7, x, y, z));
				WorkChoiceButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}));
	}
}
