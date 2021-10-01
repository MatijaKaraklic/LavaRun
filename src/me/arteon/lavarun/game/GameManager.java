package me.arteon.lavarun.game;

import me.arteon.lavarun.LavaRun;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class GameManager {

    LavaRun plugin;

    public GameManager(LavaRun lavaRun){
        this.plugin = lavaRun;
    }

    public void startGame(){
        plugin.setGameRunning(true);
        for(Player p : plugin.getServer().getOnlinePlayers()){
            p.teleport(plugin.center);
            fillTerrain(plugin.pointA, plugin.pointB, p);
            p.sendMessage("Game start.");
        }
    }

    public void stopGame(){
        plugin.setGameRunning(false);
    }

    public void info(Player p){
        p.sendMessage(ChatColor.GOLD + "-----------INFO-----------");
        p.sendMessage(ChatColor.GREEN + "Center: " + info(plugin.center));
        p.sendMessage(ChatColor.GREEN + "Point A: " + info(plugin.pointA));
        p.sendMessage(ChatColor.GREEN + "Point B: " + info(plugin.pointB));
        p.sendMessage(ChatColor.GREEN + "Time: " + plugin.time + " second" + (plugin.time>1?"s":""));
        p.sendMessage(ChatColor.GREEN + "Safe time: " + plugin.safe_time + " second" + (plugin.time>1?"s":""));
        p.sendMessage(ChatColor.GOLD + "--------------------------");
    }

    private void fillTerrain(Location pointA, Location pointB, Player p){
        p.sendMessage("Fill");
    }

    private String simpleLocation(Location l){
        return "X: " + l.getBlockX() + " Y: " + l.getBlockY() + " Z: " + l.getBlockZ();
    }

    private String info(Location l){
        if(l == null){
            return "Not setup";
        }
        else return simpleLocation(l);
    }

}
