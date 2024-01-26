package org.destplay.clanspawn.helpers;

import org.bukkit.ChatColor;

public class ChatHelper   {


    public static String PREFIX = ChatColor.YELLOW + "[clanspawn] " + ChatColor.RESET;


    public static String Error(String msg) {
        return PREFIX + ChatColor.RED + " " + msg;
    }

    public static String Info(String msg) {
        return PREFIX + ChatColor.GREEN + " " + msg;
    }



}
