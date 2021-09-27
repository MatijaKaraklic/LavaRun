package me.arteon.lavarun;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private boolean isGameRunning;
    private static Location center;


    //------------------------------------------------
    //MAIN FUNCTIONS
    //------------------------------------------------

    @Override
    public void onEnable() {
        firstSetup();
        getServer().getConsoleSender().sendMessage("Lava Run Enabled.");
        getServer().getPluginManager().registerEvents(new Events(this), this);
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("Lava Run Disabled.");
    }

    private void firstSetup(){
        isGameRunning = false;
    }

    //------------------------------------------------
    //GET AND SET
    //------------------------------------------------

    public boolean isGameRunning() {
        return isGameRunning;
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



    //------------------------------------------------
    //COMMANDS
    //------------------------------------------------

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return super.onCommand(sender, command, label, args);
    }
}
