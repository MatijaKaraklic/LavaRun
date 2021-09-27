package me.arteon.lavarun;

import me.arteon.lavarun.commands.SetCenter;
import me.arteon.lavarun.commands.SetPoint;
import me.arteon.lavarun.commands.SetupInfo;
import me.arteon.lavarun.commands.Start;
import me.arteon.lavarun.events.Events;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private boolean running;
    private Location center;
    private Location pointA;
    private Location pointB;
    SetCenter setcenter;
    SetPoint setpoint;
    SetupInfo setupinfo;
    Start start;



    //------------------------------------------------
    //MAIN FUNCTIONS
    //------------------------------------------------

    @Override
    public void onEnable() {
        firstSetup();
        getServer().getConsoleSender().sendMessage("Lava Run Enabled.");
        getServer().getPluginManager().registerEvents(new Events(this), this);
        getCommand("setcenter").setExecutor(setcenter);
        getCommand("setpoint").setExecutor(setpoint);
        getCommand("setupinfo").setExecutor(setupinfo);
        getCommand("start").setExecutor(start);
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("Lava Run Disabled.");
    }

    private void firstSetup(){
        running = false;
        setcenter = new SetCenter(this);
        setpoint = new SetPoint(this);
        setupinfo = new SetupInfo(this);
        start = new Start(this);
    }



    //---------------------------------------------`---
    //GET AND SET
    //------------------------------------------------

    public boolean isGameRunning() {
        return running;
    }
    public void setGameRunning(Boolean b){
        this.running = b;
    }

    public Location getCenter(){
        return this.center;
    }
    public void setCenter(Location l){
        this.center = l;
    }

    public void setPointA(Location l){
        this.pointA = l;
    }
    public Location getPointA(){
        return this.pointA;
    }

    public void setPointB(Location l){
        this.pointB = l;
    }
    public Location getPointB(){
        return this.pointB;
    }

}
