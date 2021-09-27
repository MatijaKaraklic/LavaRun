package me.arteon.lavarun.commands;

import me.arteon.lavarun.Main;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetupInfo implements CommandExecutor {

    Main plugin;

    public SetupInfo(Main main){
        this.plugin = main;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(!(commandSender instanceof Player)){return false;}

        Player player = (Player) commandSender;

        if(player.isOp()){
            setupInfo(player);
        }
        else {
            player.sendMessage(ChatColor.RED + "You are not Operator on this server!");
        }
        return false;
    }

    private void setupInfo(Player p){
        p.sendMessage(ChatColor.GOLD + "-----------INFO-----------");
        p.sendMessage(ChatColor.GREEN + "Center: " + simpleLocation(plugin.getCenter()));
        p.sendMessage(ChatColor.GREEN + "Point A: " + simpleLocation(plugin.getPointA()));
        p.sendMessage(ChatColor.GREEN + "Point B: " + simpleLocation(plugin.getPointB()));
        p.sendMessage(ChatColor.GOLD + "--------------------------");
    }

    private String simpleLocation(Location l){
        return "X: " + l.getBlockX() + " Y: " + l.getBlockY() + " Z: " + l.getBlockZ();
    }
}
