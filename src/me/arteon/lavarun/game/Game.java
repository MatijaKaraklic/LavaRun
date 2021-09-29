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
        this.gameManager = new GameManager(plugin);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(!(commandSender instanceof Player)){return false;}

        Player player = (Player) commandSender;

        if(player.isOp()) {
            switch (args[0]){
                case "start":
                    gameManager.startGame();
                    break;
                case "stop":
                    gameManager.stopGame();
                    break;
            }
        }
        else {
            player.sendMessage(ChatColor.RED + "You are not Operator on this server!");
        }
        return false;
    }

}
