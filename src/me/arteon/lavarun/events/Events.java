package me.arteon.lavarun.events;

import me.arteon.lavarun.LavaRun;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Events implements Listener {

    LavaRun plugin;

    public Events(LavaRun lavaRun){
        this.plugin = lavaRun;
    }



    //------------------------------------------------
    //PLAYER JOIN
    //------------------------------------------------

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (plugin.isGameRunning()) {
            event.getPlayer().setGameMode(GameMode.SPECTATOR);
        } else {
            event.getPlayer().setGameMode(GameMode.ADVENTURE);
        }
    }

}
