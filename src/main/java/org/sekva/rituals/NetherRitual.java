package org.sekva.rituals;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class NetherRitual {

    private static final int RITUAL_NUMBER = 6;

    private final static Vector[] playerDiffList = {
        new Vector(7, 0, 6),
        new Vector(7, 0, 3),
        new Vector(7, 0, 0),
        new Vector(7, 0, -3),
        new Vector(7, 0, -6)
    };

    private final static Material[] playerItems  = {
        Material.TOTEM_OF_UNDYING,
        Material.SPONGE,
        Material.SPORE_BLOSSOM,
        Material.MUSIC_DISC_5,
        Material.TOTEM_OF_UNDYING
    };
    
    public static void tryStartRitual(Player player, Block baseBlock) {

        if(baseBlock == null || player == null) {
            return;
        }

        if(baseBlock.getType() != Material.EMERALD_BLOCK) {
            return;
        }
        
        World world = player.getWorld();
        // TODO: chegar se tá no por do sol
        Location baseLocation = baseBlock.getLocation();
        Bukkit.getLogger().info("tudo ok, testando players");

        for(int i = 0; i < RITUAL_NUMBER - 1; i++) {
            Player assistPlayer = checkIfPlayerPosition(baseLocation.add(playerDiffList[i]), world);

            if(assistPlayer == null) {
                return;
            }

            if(!playerUsingGoldenArmor(assistPlayer) || !playerHandItem(assistPlayer, playerItems[i])) {
                return;
            }

            Bukkit.getLogger().info("player " + i + " ok:" + assistPlayer.getDisplayName());
        }

        for(Player p: world.getPlayers()) {
            p.sendTitle("Um ritual vai começar", "E lá vamos nós", 10, 70, 20);
        }

        buildPortal(baseLocation.clone(), world);
    }

    private static Player checkIfPlayerPosition(Location blockLocation, World world) {
        if(blockLocation.getBlock().getType() != Material.BONE_BLOCK) {
            return null;
        }

        Location playerLocation = blockLocation.add(0, 1, 0);
        for(Player p: world.getPlayers()){
            if(p.getLocation().distance(playerLocation) < 1.5) {
                return p;
            }
        }

        return null;
    }

    private static boolean playerUsingGoldenArmor(Player player)    {
        //TODO: fazer 
        return false;
    }

    private static boolean playerHandItem(Player player, Material material) {
        //TODO: fazer 
        return false;
    }
    
    private static void buildPortal(Location baseLocation, World world) {
        //TODO: fazer
    }
    
}
