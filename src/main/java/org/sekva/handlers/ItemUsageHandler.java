package org.sekva.handlers;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.sekva.OtherPath;
import org.sekva.items.NetherTome;
import org.sekva.rituals.NetherRitual;

public class ItemUsageHandler implements Listener {

    public ItemUsageHandler(OtherPath plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    
    @EventHandler
    public static void onItemUse(PlayerInteractEvent event) {
        if(event.getItem() == null) {
            return;
        }

        Block block = event.getClickedBlock();
        ItemStack item = event.getItem();

        if (event.getAction() == Action.LEFT_CLICK_BLOCK) {
            checkLeftClick(event.getPlayer(), item, block);
        }

        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            checkRightClick(event.getPlayer(), item, block);
        }
    }

    private static void checkLeftClick(Player player, ItemStack item, Block block) {
        if(NetherTome.isNetherTome(item)) {
            NetherRitual.tryStartRitual(player, block);
        }
    }

    private static void checkRightClick(Player player, ItemStack item, Block block) {}    
}
