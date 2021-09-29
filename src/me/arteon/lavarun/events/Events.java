package me.arteon.lavarun.events;

import com.sun.media.jfxmedia.events.PlayerStateEvent;
import me.arteon.lavarun.LavaRun;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

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

    @EventHandler
    public void onMove(PlayerMoveEvent event){
        Location l = event.getPlayer().getLocation();
        if(l.getBlock().getType().equals(Material.RED_STAINED_GLASS)){
            event.getPlayer().setGameMode(GameMode.SPECTATOR);
        }
        l = l.add(0, -1, 0);
        if(l.getBlock().getType().equals(Material.RED_STAINED_GLASS)){
            event.getPlayer().setGameMode(GameMode.SPECTATOR);
        }
        l = l.add(0, +2, 0);
        if(l.getBlock().getType().equals(Material.RED_STAINED_GLASS)){
            event.getPlayer().setGameMode(GameMode.SPECTATOR);
        }
    }

}
