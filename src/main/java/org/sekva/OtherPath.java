package org.sekva;

import org.bukkit.plugin.java.JavaPlugin;
import org.sekva.handlers.ItemUsageHandler;
import org.sekva.handlers.NetherPortalHandler;

public final class OtherPath extends JavaPlugin {

    @Override
    public void onEnable() {
        new NetherPortalHandler(this);
        new ItemUsageHandler(this);
    }

    @Override
    public void onDisable() {
        getLogger().info("OtherPath disabled!");
    }
    
}
