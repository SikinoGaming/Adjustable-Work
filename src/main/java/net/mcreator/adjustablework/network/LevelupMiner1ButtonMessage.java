
package net.mcreator.adjustablework.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.adjustablework.world.inventory.LevelupMiner1Menu;
import net.mcreator.adjustablework.procedures.NextPageMinerProcedure;
import net.mcreator.adjustablework.procedures.MinerLevel3Procedure;
import net.mcreator.adjustablework.procedures.MinerLevel2Procedure;
import net.mcreator.adjustablework.procedures.MinerLevel1Procedure;
import net.mcreator.adjustablework.AdjustableWorkMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class LevelupMiner1ButtonMessage {
	private final int buttonID, x, y, z;

	public LevelupMiner1ButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public LevelupMiner1ButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(LevelupMiner1ButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(LevelupMiner1ButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level;
		HashMap guistate = LevelupMiner1Menu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			MinerLevel1Procedure.execute(entity);
		}
		if (buttonID == 1) {

			MinerLevel2Procedure.execute(entity);
		}
		if (buttonID == 2) {

			MinerLevel3Procedure.execute(entity);
		}
		if (buttonID == 3) {

			NextPageMinerProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		AdjustableWorkMod.addNetworkMessage(LevelupMiner1ButtonMessage.class, LevelupMiner1ButtonMessage::buffer, LevelupMiner1ButtonMessage::new,
				LevelupMiner1ButtonMessage::handler);
	}
}
