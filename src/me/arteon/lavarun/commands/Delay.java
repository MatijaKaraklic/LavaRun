package me.arteon.lavarun.commands;

import me.arteon.lavarun.LavaRun;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Delay implements CommandExecutor {

    LavaRun plugin;

    public Delay(LavaRun lavaRun){
        this.plugin = lavaRun;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if(!(commandSender instanceof Player)){return false;}

        Player player = (Player) commandSender;

        if(player.isOp()) {
            player.sendMessage(args[0]);
        }
        else {
            player.sendMessage(ChatColor.RED + "You are not Operator on this server!");
        }

        return false;
    }
}
