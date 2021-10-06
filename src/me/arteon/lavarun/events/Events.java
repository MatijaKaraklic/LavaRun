package me.arteon.lavarun.events;

import com.sun.media.jfxmedia.events.PlayerStateEvent;
import me.arteon.lavarun.LavaRun;
import me.arteon.lavarun.game.GameManager;
import org.bukkit.ChatColor;
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
    GameManager gameManager;

    public Events(LavaRun lavaRun){
        this.plugin = lavaRun;
        this.gameManager = new GameManager(plugin);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.getPlayer().setGameMode(GameMode.SPECTATOR);
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event){
        Location l = event.getPlayer().getLocation();
        if(l.getBlock().getType().equals(Material.RED_STAINED_GLASS)){
            playerDieMessage(event.getPlayer());
            event.getPlayer().setGameMode(GameMode.SPECTATOR);
            gameManager.gameUpdate();
        }
        l = l.add(0, -1, 0);
        if(l.getBlock().getType().equals(Material.RED_STAINED_GLASS)){
            playerDieMessage(event.getPlayer());
            event.getPlayer().setGameMode(GameMode.SPECTATOR);
            gameManager.gameUpdate();
        }
        l = l.add(0, +2, 0);
        if(l.getBlock().getType().equals(Material.RED_STAINED_GLASS)){
            playerDieMessage(event.getPlayer());
            event.getPlayer().setGameMode(GameMode.SPECTATOR);
            gameManager.gameUpdate();
        }
    }

    public void playerDieMessage(Player player){
        if(player.getGameMode().equals(GameMode.ADVENTURE)){
            for(Player p : plugin.getServer().getOnlinePlayers()){
                p.sendMessage(ChatColor.RED + plugin.player_die[0] + " " + player.getName() + " " + plugin.player_die[1]);
            }
        }
    }

}
