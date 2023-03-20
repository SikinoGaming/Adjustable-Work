package net.mcreator.adjustablework.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.adjustablework.world.inventory.LevelupCooker2Menu;
import net.mcreator.adjustablework.procedures.CookerLevel4buttonProcedure;
import net.mcreator.adjustablework.network.LevelupCooker2ButtonMessage;
import net.mcreator.adjustablework.AdjustableWorkMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class LevelupCooker2Screen extends AbstractContainerScreen<LevelupCooker2Menu> {
	private final static HashMap<String, Object> guistate = LevelupCooker2Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_divin;
	Button button_retour;

	public LevelupCooker2Screen(LevelupCooker2Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("adjustable_work:textures/screens/levelup_cooker_2.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("adjustable_work:textures/screens/pomme_en_or1.png"));
		this.blit(ms, this.leftPos + 45, this.topPos + 36, 0, 0, 80, 80, 80, 80);

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
		this.font.draw(poseStack, Component.translatable("gui.adjustable_work.levelup_cooker_2.label_50_niveaux"), 60, 127, -12829636);
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
		button_divin = new Button(this.leftPos + 61, this.topPos + 9, 51, 20, Component.translatable("gui.adjustable_work.levelup_cooker_2.button_divin"), e -> {
			if (CookerLevel4buttonProcedure.execute(entity)) {
				AdjustableWorkMod.PACKET_HANDLER.sendToServer(new LevelupCooker2ButtonMessage(0, x, y, z));
				LevelupCooker2ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (CookerLevel4buttonProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		};
		guistate.put("button:button_divin", button_divin);
		this.addRenderableWidget(button_divin);
		button_retour = new Button(this.leftPos + 112, this.topPos + 140, 56, 20, Component.translatable("gui.adjustable_work.levelup_cooker_2.button_retour"), e -> {
			if (true) {
				AdjustableWorkMod.PACKET_HANDLER.sendToServer(new LevelupCooker2ButtonMessage(1, x, y, z));
				LevelupCooker2ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_retour", button_retour);
		this.addRenderableWidget(button_retour);
	}
}
