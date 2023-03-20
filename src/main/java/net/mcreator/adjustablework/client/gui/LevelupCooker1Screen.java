package net.mcreator.adjustablework.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.adjustablework.world.inventory.LevelupCooker1Menu;
import net.mcreator.adjustablework.procedures.CookerLevel3buttonProcedure;
import net.mcreator.adjustablework.procedures.CookerLevel2buttonProcedure;
import net.mcreator.adjustablework.procedures.CookerLevel1buttonProcedure;
import net.mcreator.adjustablework.network.LevelupCooker1ButtonMessage;
import net.mcreator.adjustablework.AdjustableWorkMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class LevelupCooker1Screen extends AbstractContainerScreen<LevelupCooker1Menu> {
	private final static HashMap<String, Object> guistate = LevelupCooker1Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_basique;
	Button button_avance;
	Button button_profesionnel;
	Button button_suivant;

	public LevelupCooker1Screen(LevelupCooker1Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 320;
		this.imageHeight = 180;
	}

	private static final ResourceLocation texture = new ResourceLocation("adjustable_work:textures/screens/levelup_cooker_1.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("adjustable_work:textures/screens/bread.png"));
		this.blit(ms, this.leftPos + 6, this.topPos + 50, 0, 0, 80, 80, 80, 80);

		RenderSystem.setShaderTexture(0, new ResourceLocation("adjustable_work:textures/screens/soup.png"));
		this.blit(ms, this.leftPos + 78, this.topPos + 32, 0, 0, 112, 112, 112, 112);

		RenderSystem.setShaderTexture(0, new ResourceLocation("adjustable_work:textures/screens/cooked_beef.png"));
		this.blit(ms, this.leftPos + 186, this.topPos + 50, 0, 0, 80, 80, 80, 80);

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
		this.font.draw(poseStack, Component.translatable("gui.adjustable_work.levelup_cooker_1.label_10_niveaux"), 15, 140, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.adjustable_work.levelup_cooker_1.label_20_niveaux"), 105, 140, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.adjustable_work.levelup_cooker_1.label_30_niveaux"), 204, 140, -12829636);
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
		button_basique = new Button(this.leftPos + 15, this.topPos + 23, 61, 20, Component.translatable("gui.adjustable_work.levelup_cooker_1.button_basique"), e -> {
			if (CookerLevel1buttonProcedure.execute(entity)) {
				AdjustableWorkMod.PACKET_HANDLER.sendToServer(new LevelupCooker1ButtonMessage(0, x, y, z));
				LevelupCooker1ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (CookerLevel1buttonProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		};
		guistate.put("button:button_basique", button_basique);
		this.addRenderableWidget(button_basique);
		button_avance = new Button(this.leftPos + 105, this.topPos + 23, 56, 20, Component.translatable("gui.adjustable_work.levelup_cooker_1.button_avance"), e -> {
			if (CookerLevel2buttonProcedure.execute(entity)) {
				AdjustableWorkMod.PACKET_HANDLER.sendToServer(new LevelupCooker1ButtonMessage(1, x, y, z));
				LevelupCooker1ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (CookerLevel2buttonProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		};
		guistate.put("button:button_avance", button_avance);
		this.addRenderableWidget(button_avance);
		button_profesionnel = new Button(this.leftPos + 186, this.topPos + 23, 88, 20, Component.translatable("gui.adjustable_work.levelup_cooker_1.button_profesionnel"), e -> {
			if (CookerLevel3buttonProcedure.execute(entity)) {
				AdjustableWorkMod.PACKET_HANDLER.sendToServer(new LevelupCooker1ButtonMessage(2, x, y, z));
				LevelupCooker1ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (CookerLevel3buttonProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		};
		guistate.put("button:button_profesionnel", button_profesionnel);
		this.addRenderableWidget(button_profesionnel);
		button_suivant = new Button(this.leftPos + 253, this.topPos + 155, 61, 20, Component.translatable("gui.adjustable_work.levelup_cooker_1.button_suivant"), e -> {
			if (true) {
				AdjustableWorkMod.PACKET_HANDLER.sendToServer(new LevelupCooker1ButtonMessage(3, x, y, z));
				LevelupCooker1ButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:button_suivant", button_suivant);
		this.addRenderableWidget(button_suivant);
	}
}
