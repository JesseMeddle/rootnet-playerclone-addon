package c.uriah.playerclone;

import java.util.UUID;

import com.mojang.authlib.GameProfile;
import com.mojang.realmsclient.gui.ChatFormatting;

import dev.rootnet.addons.api.addon.AddonCommand;
import dev.rootnet.addons.api.annotations.RootnetCommand;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.GameType;

@RootnetCommand(name = "clone", description = "Clones the player")

public final class CloneCommand extends AddonCommand {
	
	@Override
	public void run(String[] clone) {
		String message = (ChatFormatting.DARK_GREEN + "[")+(ChatFormatting.GREEN + "rootNET")+(ChatFormatting.DARK_GREEN + "]"+ChatFormatting.WHITE+" ") + "Cloned the player";
		Minecraft.getMinecraft().player.sendMessage(new TextComponentString(message));
		
		final EntityOtherPlayerMP clonedPlayer;
		Minecraft mc = Minecraft.getMinecraft();

	    if (mc.player == null || mc.player.isDead){
	        return;
	    }

	    clonedPlayer = new EntityOtherPlayerMP(mc.world, new GameProfile(UUID.fromString("53017c17-a7cf-4b57-b072-1bb56fe078d4"), "Clone"));
	    clonedPlayer.copyLocationAndAnglesFrom(mc.player);
	    clonedPlayer.rotationYawHead = mc.player.rotationYawHead;
	    clonedPlayer.rotationYaw = mc.player.rotationYaw;
	    clonedPlayer.rotationPitch = mc.player.rotationPitch;
	    clonedPlayer.setGameType(GameType.SURVIVAL);
	    clonedPlayer.setHealth(20);
	    mc.world.addEntityToWorld(-420, clonedPlayer);
	    clonedPlayer.onLivingUpdate();
	}	
}
