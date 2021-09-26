package me.arteon.lavarun;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private static boolean isGameRunning = false;
    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage("Lava Run Enabled.");
        getServer().getPluginManager().registerEvents(new Events(), this);
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("Lava Run Disabled.");
    }

    public static boolean isGameRunning() {
        return isGameRunning;
    }

    public static void setGameRunning(boolean gameRunning) {
        isGameRunning = gameRunning;
    }
    public static void startGame(){
        isGameRunning = true;
    }
    public static void onGameEnds(){
        isGameRunning = false;
    }
}
