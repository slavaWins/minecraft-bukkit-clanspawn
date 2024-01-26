package org.destplay.clanspawn.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.destplay.clanspawn.handles.SignRentHandle;
import org.destplay.clanspawn.helpers.ChatHelper;


public class SignListener implements Listener {

    @org.bukkit.event.EventHandler
    public void onPlayerChat(PlayerChatEvent event) {
        String originalMessage = event.getMessage();
        String playerName = event.getPlayer().getName();


        event.setFormat(ChatColor.YELLOW + "[CLAN] " + ChatColor.RESET + playerName + ": " + originalMessage);
    }


    @org.bukkit.event.EventHandler
    public void onKillMob(EntityDeathEvent event) {


        Entity mob = event.getEntity();
        Player player = null;




        if (event.getEntity().getKiller() instanceof Player) {
            player = event.getEntity().getKiller();
        } else {
            System.out.println("----- [DEAD] xz player");
            return;
        }

        if (player == null) return;


        player.sendMessage(ChatHelper.PREFIX + " Игрок " + player.getDisplayName() + " Убил: " + mob.getCustomName());
        player.sendMessage(ChatHelper.PREFIX + " Игрок " + player.getDisplayName() + " Убил: " + mob.getName());

    }


}