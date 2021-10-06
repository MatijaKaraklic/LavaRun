package me.arteon.lavarun.game;

import me.arteon.lavarun.LavaRun;
import org.bukkit.*;
import org.bukkit.entity.Player;

import java.util.Random;

public class GameManager {

    Random r = new Random();

    LavaRun plugin;
    private int Y;

    public GameManager(LavaRun lavaRun){
        this.plugin = lavaRun;
        this.Y = plugin.center.getBlockY();
    }

    public void startGame(){
        plugin.setGameRunning(true);
        plugin.getServer().getWorld("world").playSound(plugin.center, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 0.7f+r.nextFloat()*0.6f);
        for(Player p : plugin.getServer().getOnlinePlayers()){
            p.setGameMode(GameMode.ADVENTURE);
            p.teleport(plugin.center);
            p.getInventory().clear();
            p.setHealth(20);
            p.setFoodLevel(20);
            p.sendMessage(ChatColor.AQUA + plugin.gamestart);
        }

        plugin.getServer().getScheduler().runTaskTimer(plugin, new Runnable() {
            @Override
            public void run() {
                if(plugin.isGameRunning()){
                    fillTerrain(plugin.pointA, plugin.pointB, plugin.lava);
                    gameUpdate();
                }
                else{
                    plugin.getServer().getScheduler().cancelTasks(plugin);
                }
            }
        }, plugin.safe_time * 20L, plugin.time * 20L);
    }

    public void stopGame(){
        plugin.setGameRunning(false);
        clearLava(plugin.pointA, plugin.pointB, plugin.lava);
        Y = plugin.center.getBlockY();
        plugin.getServer().getWorld("world").playSound(plugin.center, Sound.ENTITY_BLAZE_DEATH, 1, 0.7f+r.nextFloat()*0.6f);
        for(Player p : plugin.getServer().getOnlinePlayers()){
            p.setGameMode(GameMode.ADVENTURE);
            p.teleport(plugin.center);
            p.getInventory().clear();
            p.setHealth(20);
            p.setFoodLevel(20);
            p.sendMessage(ChatColor.DARK_AQUA + plugin.gamestop);
        }
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

    public void gameUpdate(){
        plugin.alive_players.clear();
        for(Player p : plugin.getServer().getOnlinePlayers()){
            if(p.getGameMode().equals(GameMode.ADVENTURE)){
                plugin.alive_players.add(p);
            }
            p.setHealth(20);
            p.setFoodLevel(20);
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
