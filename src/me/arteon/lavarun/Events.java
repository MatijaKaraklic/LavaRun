package me.arteon.lavarun;

import org.bukkit.GameMode;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Events implements Listener {

    public Events(){

    }

    public void onJoin(PlayerJoinEvent event){

        event.getPlayer().sendMessage("BABABA");
        if (Main.isGameRunning()) {
            event.getPlayer().setGameMode(GameMode.SPECTATOR);
        } else {
            event.getPlayer().setGameMode(GameMode.ADVENTURE);
        }

    }


}
