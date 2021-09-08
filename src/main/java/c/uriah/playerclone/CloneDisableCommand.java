package c.uriah.playerclone;

import com.mojang.realmsclient.gui.ChatFormatting;

import dev.rootnet.addons.api.addon.AddonCommand;
import dev.rootnet.addons.api.annotations.RootnetCommand;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;
	
@RootnetCommand(name = "purgeClone", description = "Removes the cloned player")

public final class CloneDisableCommand extends AddonCommand {
		
		@Override
		public void run(String[] purgeClone) {
			if (Minecraft.getMinecraft().world != null) {
				String message = (ChatFormatting.DARK_GREEN + "[")+(ChatFormatting.GREEN + "rootNET")+(ChatFormatting.DARK_GREEN + "]"+ChatFormatting.WHITE+" ") + "Removed the player clone";
				Minecraft.getMinecraft().player.sendMessage(new TextComponentString(message));
		        Minecraft.getMinecraft().world.removeEntityFromWorld(-420);
		    }
		}
}
