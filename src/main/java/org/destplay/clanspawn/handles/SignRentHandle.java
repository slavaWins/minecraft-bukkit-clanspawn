package org.destplay.clanspawn.handles;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.destplay.clanspawn.ConfigHelper;
import org.destplay.clanspawn.contracts.Clan;
import org.destplay.clanspawn.helpers.ChatHelper;
import org.destplay.clanspawn.helpers.DateHelper;
import org.destplay.clanspawn.helpers.VaultHelper;
import org.destplay.clanspawn.repositories.ClanRepository;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class SignRentHandle {


    public static void InteractRentTable(Player player, String[] lines) {

        // Ваш код для обработки события
        String region = lines[2]; // получение значения Arg0

        Clan clan = ClanRepository.Link().FindByName(lines[2]);

        if (clan == null) {
            player.sendMessage("Не найдена инфа о регионе");
            return;
        }


        player.sendMessage(ChatColor.BOLD + "----------------ИНФОРМАЦИЯ О АРЕНДЕ----------\n\n");

        player.sendMessage(ChatColor.RESET + "Цена: " + ChatColor.AQUA + (clan.price * ConfigHelper.GetConfig().getInt("valute-view-coficient", 1)) + ChatColor.RESET + " " + VaultHelper.ValuteName() + " в сутки");
        player.sendMessage(ChatColor.GRAY + " * В реальные сутки, 24 часа реального времени. ");


        Material itemMaterial = VaultHelper.ValuteId();


    }


}