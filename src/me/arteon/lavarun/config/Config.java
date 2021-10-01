package me.arteon.lavarun.config;

import me.arteon.lavarun.LavaRun;
import org.bukkit.Location;
import org.bukkit.Material;

public class Config {

    public static Location convertStringToLocation(String s, LavaRun plugin){
        String[] args = s.split("\\|");
        double D_X = Double.parseDouble(args[0]) + 0.5;
        double D_Y = Double.parseDouble(args[1]) + 0.5;
        double D_Z = Double.parseDouble(args[2]) + 0.5;
        Location l = new Location(plugin.getServer().getWorld("world"), D_X, D_Y, D_Z);
        return l;
    }

    public static boolean isSetup(LavaRun plugin){
        if (plugin.center == null || plugin.pointA == null || plugin.pointB == null){
            return false;
        }
        else {
            return true;
        }
    }

}
