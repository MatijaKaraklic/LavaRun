package me.arteon.lavarun;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private static boolean isGameRunning = false;
    private static  Location center;

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage("Lava Run Enabled.");
        getServer().getPluginManager().registerEvents(new Events(this), this);
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("Lava Run Disabled.");
    }

    public boolean isGameRunning() {
        return isGameRunning;
    }

    public void setGameRunning(boolean gameRunning) {
        isGameRunning = gameRunning;
    }

    public void startGame(){
        isGameRunning = true;
        for(Player p:new Main().getServer().getOnlinePlayers()){
             p.teleport(center);
        }
    }

    public void onGameEnds(){
        isGameRunning = false;
    }

}
