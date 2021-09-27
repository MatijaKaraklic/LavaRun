package me.arteon.lavarun;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private boolean isGameRunning;
    private static Location center;
    Commands commands;



    //------------------------------------------------
    //MAIN FUNCTIONS
    //------------------------------------------------

    @Override
    public void onEnable() {
        firstSetup();
        getServer().getConsoleSender().sendMessage("Lava Run Enabled.");
        getServer().getPluginManager().registerEvents(new Events(this), this);
        getCommand("setcenter").setExecutor(commands);
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("Lava Run Disabled.");
    }

    private void firstSetup(){
        isGameRunning = false;
        commands = new Commands(this);
    }



    //------------------------------------------------
    //GET AND SET
    //------------------------------------------------

    public boolean isGameRunning() {
        return isGameRunning;
    }

    public Location getCenter(){
        return this.center;
    }
    public void setCenter(Location l){
        this.center = l;
    }



    //------------------------------------------------
    //GAME
    //------------------------------------------------

    public void startGame(){
        isGameRunning = true;
        for(Player p:new Main().getServer().getOnlinePlayers()){
             p.teleport(center);
        }
    }

    public void gameEnd(){
        this.isGameRunning = false;
    }

}
