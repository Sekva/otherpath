package org.sekva.handlers;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.world.PortalCreateEvent;
import org.sekva.OtherPath;
import org.sekva.items.NetherTome;

public class NetherPortalHandler implements Listener {

    Player player;
    Location obsidianLocation;
    
    public NetherPortalHandler(OtherPath plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onCreateNetherPortalFire(BlockPlaceEvent event) {
        Block eventBlock = event.getBlock();
        Block againstBlock = event.getBlockAgainst();
        
        if(eventBlock != null && eventBlock.getType() != Material.FIRE) {
            return;
        }

        if(againstBlock != null && againstBlock.getType() != Material.OBSIDIAN) {
            return;
        }

        player = event.getPlayer();
        obsidianLocation = againstBlock.getLocation();
    }
    
    @EventHandler(priority = EventPriority.NORMAL)
    public void onCreateNetherPortal(PortalCreateEvent event) {

        boolean match = false;
        for (BlockState blk_state: event.getBlocks()) {
            Location testLocation = blk_state.getLocation();
            match |= (obsidianLocation.getX() == testLocation.getX() &&
                      obsidianLocation.getY() == testLocation.getY() &&
                      obsidianLocation.getZ() == testLocation.getZ());
        }

        if(match && player != null) {
            for(BlockState blk: event.getBlocks()) {
                blk.getBlock().breakNaturally();
            }

            event.getWorld().strikeLightningEffect(player.getLocation());
            player.getInventory().addItem(NetherTome.getTome());
            player.setHealth(2);
        }

        player = null;
        obsidianLocation = null;
        event.setCancelled(true);
    }
    
}
