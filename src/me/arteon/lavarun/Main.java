package me.arteon.lavarun;

import me.arteon.lavarun.commands.Setcenter;
import me.arteon.lavarun.events.Events;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private boolean running;
    private static Location center;
    Setcenter setcenter;



    //------------------------------------------------
    //MAIN FUNCTIONS
    //------------------------------------------------

    @Override
    public void onEnable() {
        firstSetup();
        getServer().getConsoleSender().sendMessage("Lava Run Enabled.");
        getServer().getPluginManager().registerEvents(new Events(this), this);
        getCommand("setcenter").setExecutor(setcenter);
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("Lava Run Disabled.");
    }

    private void firstSetup(){
        running = false;
        setcenter = new Setcenter(this);
    }



    //------------------------------------------------
    //GET AND SET
    //------------------------------------------------

    public boolean isGameRunning() {
        return running;
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
        this.running = true;
        for(Player p:new Main().getServer().getOnlinePlayers()){
             p.teleport(center);
             p.sendMessage("Game start.");
        }
    }

    public void gameEnd(){
        this.running= false;
    }

}
