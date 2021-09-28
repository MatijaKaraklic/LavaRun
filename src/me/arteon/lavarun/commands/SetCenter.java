package me.arteon.lavarun.commands;

import me.arteon.lavarun.LavaRun;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetCenter implements CommandExecutor {

    LavaRun plugin;

    public SetCenter(LavaRun lavaRun){
        this.plugin = lavaRun;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(!(commandSender instanceof Player)){return false;}

        Player player = (Player) commandSender;

        if(player.isOp()) {
            setupCenter(player);
        }
        else {
            player.sendMessage(ChatColor.RED + "You are not Operator on this server!");
        }

        return false;
    }

    private void setupCenter(Player p){

        Location l = p.getLocation();
        Location old = plugin.getCenter();

        if(old == null){
            plugin.setCenter(l);
            p.sendMessage(ChatColor.GREEN + "New center location is: " + simpleLocation(l));
        }
        else if(isEqualsLocationsInt(l, old)){
            plugin.setCenter(l);
            p.sendMessage(ChatColor.GREEN + "Center location is: " + simpleLocation(l));
        }
        else {
            plugin.setCenter(l);
            p.sendMessage(ChatColor.GREEN + "The center location has been moved from: " + simpleLocation(old));
            p.sendMessage(ChatColor.GREEN + "To: " + simpleLocation(l));
        }

    }

    private String simpleLocation(Location l){
        return "X: " + l.getBlockX() + " Y: " + l.getBlockY() + " Z: " + l.getBlockZ();
    }

    private boolean isEqualsLocationsInt(Location l1, Location l2){
        if (l1.getBlockX() == l2.getBlockX() && l1.getBlockY() == l2.getBlockY() && l1.getBlockZ() == l2.getBlockZ()){
            return true;
        }
        else return false;
    }

}
