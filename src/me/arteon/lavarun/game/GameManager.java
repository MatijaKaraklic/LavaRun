package me.arteon.lavarun.game;

import me.arteon.lavarun.LavaRun;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class GameManager {

    LavaRun plugin;
    private int Y;

    public GameManager(LavaRun lavaRun){
        this.plugin = lavaRun;
        this.Y = plugin.center.getBlockY();
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
        clearLava(plugin.pointA, plugin.pointB, plugin.lava);
        Y = plugin.center.getBlockY();
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
        Location temp_l;
        for(double i = pointB.getBlockX(); i < pointA.getBlockX(); i++){
            for(double j = pointB.getBlockZ(); j < pointA.getBlockZ(); j++){
                temp_l = new Location(plugin.getServer().getWorld("world"), i, Y, j);
                if(temp_l.getBlock().getType().equals(Material.AIR)){
                    temp_l.getBlock().setType(m);
                }
            }
        }
        Y++;
    }
    private void clearLava(Location pointA, Location pointB, Material m){
        Location temp_l;
        for(double i = pointB.getBlockX(); i < pointA.getBlockX(); i++){
            for(double j = pointB.getBlockZ(); j < pointA.getBlockZ(); j++){
                for(double k = Y; k > plugin.center.getBlockY()-1; k--){
                    temp_l = new Location(plugin.getServer().getWorld("world"), i, k, j);
                    if(temp_l.getBlock().getType().equals(m)){
                        temp_l.getBlock().setType(Material.AIR);
                    }
                }
            }
        }
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
