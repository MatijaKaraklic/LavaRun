package me.arteon.lavarun.game;

import me.arteon.lavarun.LavaRun;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class GameManager {

    LavaRun plugin;
    private Material lava = Material.RED_STAINED_GLASS;

    public GameManager(LavaRun lavaRun){
        this.plugin = lavaRun;
    }

    public void startGame(){
        plugin.setGameRunning(true);
        for(Player p : plugin.getServer().getOnlinePlayers()){
            p.teleport(plugin.getCenter());
            fillTerrain(plugin.getPointA(), plugin.getPointB(), p);
            p.sendMessage("Game start.");
        }
    }

    public void stopGame(){
        plugin.setGameRunning(false);
    }

    private void fillTerrain(Location pointA, Location pointB, Player p){
        p.sendMessage("Fill");
    }

}
