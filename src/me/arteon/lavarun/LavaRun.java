package me.arteon.lavarun;

import me.arteon.lavarun.config.Config;
import me.arteon.lavarun.game.Game;
import me.arteon.lavarun.events.Events;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

public class LavaRun extends JavaPlugin {
    private boolean running;
    public Location center;
    public Location pointA;
    public Location pointB;
    public int safe_time;
    public int time;
    public Material lava;
    private Game game;



    //------------------------------------------------
    //MAIN FUNCTIONS
    //------------------------------------------------

    @Override
    public void onEnable() {
        configSetup();
        firstSetup();
        classSetup();
        getServer().getConsoleSender().sendMessage("Lava Run Enabled.");
        getServer().getPluginManager().registerEvents(new Events(this), this);
        getCommand("game").setExecutor(game);
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("Lava Run Disabled.");
    }

    private void configSetup(){
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
    }
    private void classSetup(){
        running = false;
        game = new Game(this);
    }
    private void firstSetup(){
        center = Config.convertStringToLocation(this.getConfig().getString("Game.center"), this);
        pointA = Config.convertStringToLocation(this.getConfig().getString("Game.pointA"), this);
        pointB = Config.convertStringToLocation(this.getConfig().getString("Game.pointB"), this);
        time = this.getConfig().getInt("Game.time");
        safe_time = this.getConfig().getInt("Game.safe_time");
        lava = Material.getMaterial(this.getConfig().getString("Game.material"));
    }



    //------------------------------------------------
    //GET AND SET
    //------------------------------------------------

    public boolean isGameRunning() {
        return running;
    }
    public void setGameRunning(Boolean b){
        this.running = b;
    }


}
