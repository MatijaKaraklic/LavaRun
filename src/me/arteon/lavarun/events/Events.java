package me.arteon.lavarun.events;

import me.arteon.lavarun.Main;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class Events implements Listener {

    Main plugin;

    public Events(Main main){
        this.plugin = main;
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
