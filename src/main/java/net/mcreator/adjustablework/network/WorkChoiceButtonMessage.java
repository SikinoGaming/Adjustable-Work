
package net.mcreator.adjustablework.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.adjustablework.world.inventory.WorkChoiceMenu;
import net.mcreator.adjustablework.procedures.MinerJobAssignationProcedure;
import net.mcreator.adjustablework.procedures.MageJobAssignationProcedure;
import net.mcreator.adjustablework.procedures.FishermanJobAssignationProcedure;
import net.mcreator.adjustablework.procedures.FarmerJobAssignationProcedure;
import net.mcreator.adjustablework.procedures.EngineerJobAssignationProcedure;
import net.mcreator.adjustablework.procedures.CookerJobAsignationProcedure;
import net.mcreator.adjustablework.procedures.ArchitectJobAssignationProcedure;
import net.mcreator.adjustablework.procedures.AgentJobAssignationProcedure;
import net.mcreator.adjustablework.AdjustableWorkMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class WorkChoiceButtonMessage {
	private final int buttonID, x, y, z;

	public WorkChoiceButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public WorkChoiceButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(WorkChoiceButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(WorkChoiceButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = WorkChoiceMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			MinerJobAssignationProcedure.execute(entity);
		}
		if (buttonID == 1) {

			FarmerJobAssignationProcedure.execute(entity);
		}
		if (buttonID == 2) {

			FishermanJobAssignationProcedure.execute(entity);
		}
		if (buttonID == 3) {

			ArchitectJobAssignationProcedure.execute(entity);
		}
		if (buttonID == 4) {

			EngineerJobAssignationProcedure.execute(entity);
		}
		if (buttonID == 5) {

			MageJobAssignationProcedure.execute(entity);
		}
		if (buttonID == 6) {

			CookerJobAsignationProcedure.execute(entity);
		}
		if (buttonID == 7) {

			AgentJobAssignationProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		AdjustableWorkMod.addNetworkMessage(WorkChoiceButtonMessage.class, WorkChoiceButtonMessage::buffer, WorkChoiceButtonMessage::new,
				WorkChoiceButtonMessage::handler);
	}
}
