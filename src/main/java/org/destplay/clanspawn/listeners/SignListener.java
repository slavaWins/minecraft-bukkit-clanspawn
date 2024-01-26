package org.destplay.clanspawn.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.destplay.clanspawn.handles.SignRentHandle;


public class SignListener implements Listener {

    @org.bukkit.event.EventHandler
    public void onPlayerChat(PlayerChatEvent event) {
        String originalMessage = event.getMessage();
        String playerName = event.getPlayer().getName();



        ChatColor prefixColor = ChatColor.GOLD;
        event.setFormat(ChatColor.GOLD + "[CLAN] " + ChatColor.RESET + playerName + ": " + originalMessage);
    }
}