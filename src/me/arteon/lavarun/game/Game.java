package me.arteon.lavarun.game;

import me.arteon.lavarun.LavaRun;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Game implements CommandExecutor {

    LavaRun plugin;
    GameManager gameManager;

    public Game(LavaRun lavaRun){
        this.plugin = lavaRun;
        this.gameManager = new GameManager();
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(!(commandSender instanceof Player)){return false;}

        Player player = (Player) commandSender;

        if(player.isOp()) {
            startGame();
        }
        else {
            player.sendMessage(ChatColor.RED + "You are not Operator on this server!");
        }
        return false;
    }

    private void startGame(){
        plugin.setGameRunning(true);
        for(Player p:new LavaRun().getServer().getOnlinePlayers()){
            p.teleport(plugin.getCenter());
            p.sendMessage("Game start.");
        }
    }

    private void gameEnd(){
        plugin.setGameRunning(false);
    }

}
