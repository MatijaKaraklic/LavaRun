package me.arteon.lavarun.game;

import me.arteon.lavarun.LavaRun;
import org.bukkit.entity.Player;

public class GameManager {

    LavaRun plugin;

    public GameManager(LavaRun lavaRun){
        this.plugin = lavaRun;
    }

    public void startGame(){
        plugin.setGameRunning(true);
        for(Player p:new LavaRun().getServer().getOnlinePlayers()){
            p.teleport(plugin.getCenter());
            p.sendMessage("Game start.");
        }
    }

    public void stopGame(){
        plugin.setGameRunning(false);
    }

}
