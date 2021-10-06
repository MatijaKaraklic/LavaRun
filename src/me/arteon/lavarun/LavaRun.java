package me.arteon.lavarun;

import me.arteon.lavarun.config.Config;
import me.arteon.lavarun.game.Game;
import me.arteon.lavarun.events.Events;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class LavaRun extends JavaPlugin {
    private boolean running;

    public Location center;
    public Location pointA;
    public Location pointB;
    public Material lava;
    public int safe_time;
    public int time;
    public String world_name;

    private Game game;

    public String gamestart;
    public String gamestop;
    public String[] player_die = {"null", "null"};
    public String[] player_win = {"null", "null"};

    public ArrayList<Player> alive_players = new ArrayList<>();


    //------------------------------------------------
    //MAIN FUNCTIONS
    //------------------------------------------------

    @Override
    public void onEnable() {
        configSetup();
        firstSetup();
        classSetup();
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "\n\nLava Run Enabled.\n");
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
        lava = Material.getMaterial(this.getConfig().getString("Game.lava"));
        time = this.getConfig().getInt("Game.time");
        safe_time = this.getConfig().getInt("Game.safe_time");
        world_name = this.getConfig().getString("Game.world_name");


        gamestart = this.getConfig().getString("Messages.gamestart");
        gamestop = this.getConfig().getString("Messages.gamestop");

        player_die[0] = this.getConfig().getString("Messages.player_die.player");
        player_die[1] = this.getConfig().getString("Messages.player_die.msg");
        player_win[0] = this.getConfig().getString("Messages.player_win.player");
        player_win[1] = this.getConfig().getString("Messages.player_win.msg");

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
