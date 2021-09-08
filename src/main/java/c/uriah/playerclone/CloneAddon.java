package c.uriah.playerclone;

import dev.rootnet.addons.api.addon.Addon;
import dev.rootnet.addons.api.annotations.RootnetAddon;
import dev.rootnet.addons.api.annotations.RootnetSetting;

import org.apache.logging.log4j.Level;

import c.uriah.playerclone.CloneCommand;

import java.io.IOException;

@SuppressWarnings("unused")
@RootnetAddon(name = "PlayerClone", author = "Uriah C.", version = "#VERSION#")

public final class CloneAddon extends Addon {

    public CloneAddon() {
    }

    @Override
    public void init() {
        super.init();
        log(Level.INFO, "Initializing PlayerClone-Addon");
        getRootnet().registerCommand(this, new CloneCommand());
        getRootnet().registerCommand(this, new CloneDisableCommand());
    }

}