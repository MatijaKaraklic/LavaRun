package me.arteon.lavarun.commands;

import me.arteon.lavarun.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Start implements CommandExecutor {

    Main plugin;

    public Start(Main main){
        this.plugin = main;
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
        for(Player p:new Main().getServer().getOnlinePlayers()){
            p.teleport(plugin.getCenter());
            p.sendMessage("Game start.");
        }
    }

    private void gameEnd(){
        plugin.setGameRunning(false);
    }

}
