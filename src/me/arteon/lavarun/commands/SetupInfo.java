package me.arteon.lavarun.commands;

import me.arteon.lavarun.LavaRun;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetupInfo implements CommandExecutor {

    LavaRun plugin;

    public SetupInfo(LavaRun lavaRun){
        this.plugin = lavaRun;
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
        p.sendMessage(ChatColor.GREEN + "Center: " + info(plugin.getCenter()));
        p.sendMessage(ChatColor.GREEN + "Point A: " + info(plugin.getPointA()));
        p.sendMessage(ChatColor.GREEN + "Point B: " + info(plugin.getPointB()));
        p.sendMessage(ChatColor.GREEN + "Delay: " + plugin.getTimeSec() + " second" + (plugin.getTimeSec()>1?"s":""));
        p.sendMessage(ChatColor.GOLD + "--------------------------");
    }

    private String simpleLocation(Location l){
        return "X: " + l.getBlockX() + " Y: " + l.getBlockY() + " Z: " + l.getBlockZ();
    }

    private String info(Location l){
        if(l == null){
            return "Not setup";
        }
        else return simpleLocation(l);
    }
}
