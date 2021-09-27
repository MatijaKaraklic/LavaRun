package me.arteon.lavarun.commands;

import me.arteon.lavarun.Main;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetPoint implements CommandExecutor {

    Main plugin;

    public SetPoint(Main main){
        this.plugin = main;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(!(commandSender instanceof Player)){return false;}

        Player player = (Player) commandSender;

        if(player.isOp()){
            switch (args[0]){
                case "A":
                    setupPointA(player);
                    break;
                case "B":
                    setupPointB(player);
                    break;
            }
        }
        else {
            player.sendMessage(ChatColor.RED + "You are not Operator on this server!");
        }
        return false;
    }

    public void setupPointA(Player p){
        Location l = p.getLocation();
        plugin.setPointA(l);
        p.sendMessage(ChatColor.GREEN + "Point A is on location: " + simpleLocation(l));
    }

    public void setupPointB(Player p){
        Location l = p.getLocation();
        plugin.setPointB(l);
        p.sendMessage(ChatColor.GREEN + "Point B is on location: " + simpleLocation(l));
    }

    private String simpleLocation(Location l){
        return "X: " + l.getBlockX() + " Y: " + l.getBlockY() + " Z: " + l.getBlockZ();
    }
}
