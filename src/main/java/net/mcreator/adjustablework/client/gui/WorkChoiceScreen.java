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
	Button button_mineur;
	Button button_fermier;
	Button button_pecheur;
	Button button_architecte;
	Button button_ingenieur;
	Button button_mage;
	Button button_cuisinier;
	Button button_agent;

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
		this.font.draw(poseStack, Component.translatable("gui.adjustable_work.work_choice.label_selectionne_ton_metier"), 56, 18, -16777216);
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
		button_mineur = new Button(this.leftPos + 137, this.topPos + 36, 71, 20, Component.translatable("gui.adjustable_work.work_choice.button_mineur"), e -> {
			if (true) {
				AdjustableWorkMod.PACKET_HANDLER.sendToServer(new WorkChoiceButtonMessage(0, x, y, z));
				WorkChoiceButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_mineur", button_mineur);
		this.addRenderableWidget(button_mineur);
		button_fermier = new Button(this.leftPos + 137, this.topPos + 63, 71, 20, Component.translatable("gui.adjustable_work.work_choice.button_fermier"), e -> {
			if (true) {
				AdjustableWorkMod.PACKET_HANDLER.sendToServer(new WorkChoiceButtonMessage(1, x, y, z));
				WorkChoiceButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_fermier", button_fermier);
		this.addRenderableWidget(button_fermier);
		button_pecheur = new Button(this.leftPos + 137, this.topPos + 90, 71, 20, Component.translatable("gui.adjustable_work.work_choice.button_pecheur"), e -> {
			if (true) {
				AdjustableWorkMod.PACKET_HANDLER.sendToServer(new WorkChoiceButtonMessage(2, x, y, z));
				WorkChoiceButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_pecheur", button_pecheur);
		this.addRenderableWidget(button_pecheur);
		button_architecte = new Button(this.leftPos + 29, this.topPos + 117, 77, 20, Component.translatable("gui.adjustable_work.work_choice.button_architecte"), e -> {
			if (true) {
				AdjustableWorkMod.PACKET_HANDLER.sendToServer(new WorkChoiceButtonMessage(3, x, y, z));
				WorkChoiceButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:button_architecte", button_architecte);
		this.addRenderableWidget(button_architecte);
		button_ingenieur = new Button(this.leftPos + 29, this.topPos + 90, 77, 20, Component.translatable("gui.adjustable_work.work_choice.button_ingenieur"), e -> {
			if (true) {
				AdjustableWorkMod.PACKET_HANDLER.sendToServer(new WorkChoiceButtonMessage(4, x, y, z));
				WorkChoiceButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:button_ingenieur", button_ingenieur);
		this.addRenderableWidget(button_ingenieur);
		button_mage = new Button(this.leftPos + 29, this.topPos + 63, 76, 20, Component.translatable("gui.adjustable_work.work_choice.button_mage"), e -> {
			if (true) {
				AdjustableWorkMod.PACKET_HANDLER.sendToServer(new WorkChoiceButtonMessage(5, x, y, z));
				WorkChoiceButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:button_mage", button_mage);
		this.addRenderableWidget(button_mage);
		button_cuisinier = new Button(this.leftPos + 29, this.topPos + 36, 77, 20, Component.translatable("gui.adjustable_work.work_choice.button_cuisinier"), e -> {
			if (true) {
				AdjustableWorkMod.PACKET_HANDLER.sendToServer(new WorkChoiceButtonMessage(6, x, y, z));
				WorkChoiceButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		});
		guistate.put("button:button_cuisinier", button_cuisinier);
		this.addRenderableWidget(button_cuisinier);
		button_agent = new Button(this.leftPos + 137, this.topPos + 117, 71, 20, Component.translatable("gui.adjustable_work.work_choice.button_agent"), e -> {
			if (true) {
				AdjustableWorkMod.PACKET_HANDLER.sendToServer(new WorkChoiceButtonMessage(7, x, y, z));
				WorkChoiceButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		});
		guistate.put("button:button_agent", button_agent);
		this.addRenderableWidget(button_agent);
	}
}
