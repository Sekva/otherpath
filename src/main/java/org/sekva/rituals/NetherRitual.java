package org.sekva.rituals;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class NetherRitual {
    
    public static void tryStartRitual(Player player, Block baseBlock) {

        if(baseBlock == null || player == null) {
            return;
        }

        if(baseBlock.getType() != Material.EMERALD_BLOCK) {
            return;
        }
        
        World world = player.getWorld();
        List<Player> players = world.getPlayers();
        Location baseLocation = baseBlock.getLocation();

        Bukkit.getLogger().info("tudo ok, testando players");
        
        try {
            checkPlayer1(baseLocation.clone(), players);
            checkPlayer2(baseLocation.clone(), players);
            checkPlayer3(baseLocation.clone(), players);
            checkPlayer4(baseLocation.clone(), players);
            checkPlayer5(baseLocation.clone(), players);
            checkPlayer6(baseLocation.clone(), players);
        } catch(Exception _e) {
            _e.printStackTrace();
            return;
        }
        
        for(Player p: players) {
            p.sendTitle("Um ritual vai começar", "Sub", 10, 70, 20);
        }

        buildPortal(baseLocation.clone(), world);
    }


    private static void checkPlayer1(Location baseLocation, List<Player> players) throws Exception {

        // o player ta em cima de um bloco de diamante no lugar certo?
        // o player ta de armadura completa de ouro?
        // o player ta com o item certo na mao?

        // throw new Exception();
    }
    
    private static void checkPlayer2(Location baseLocation, List<Player> players) throws Exception {}
    private static void checkPlayer3(Location baseLocation, List<Player> players) throws Exception {}
    private static void checkPlayer4(Location baseLocation, List<Player> players) throws Exception {}
    private static void checkPlayer5(Location baseLocation, List<Player> players) throws Exception {}
    private static void checkPlayer6(Location baseLocation, List<Player> players) throws Exception {}
    
    private static void buildPortal(Location baseLocation, World world) {}
    
}
