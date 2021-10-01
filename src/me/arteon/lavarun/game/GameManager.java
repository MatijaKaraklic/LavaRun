package me.arteon.lavarun.game;

import me.arteon.lavarun.LavaRun;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class GameManager {

    LavaRun plugin;
    private int Y = 0;

    public GameManager(LavaRun lavaRun){
        this.plugin = lavaRun;
    }

    public void startGame(){
        plugin.setGameRunning(true);
        for(Player p : plugin.getServer().getOnlinePlayers()){
            p.teleport(plugin.center);
            fillTerrain(plugin.pointA, plugin.pointB, plugin.lava);
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
        p.sendMessage(ChatColor.GREEN + "Lava: " + plugin.lava);
        p.sendMessage(ChatColor.GOLD + "--------------------------");
    }

    private void fillTerrain(Location pointA, Location pointB, Material m){
        for(double i = 0; i < 60; i++){
            for(double j = 0; j < 60; j++){
                if(pointB.clone().add(i, Y, j).getBlock().getType().equals(Material.AIR)){
                    pointB.clone().add(i, Y, j).getBlock().setType(m);
                    System.out.println(i + "|" + Y + "|" + j);
                }
            }
        }

        Y++;
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
