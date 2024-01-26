package org.destplay.clanspawn.handles;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.destplay.clanspawn.ConfigHelper;
import org.destplay.clanspawn.contracts.Clan;
import org.destplay.clanspawn.helpers.ChatHelper;
import org.destplay.clanspawn.repositories.ClanRepository;
import org.destplay.clanspawn.views.RentChatView;

import java.util.List;

public class CommandsHandle {
    public static void TpTo(CommandSender sender, String name) {


        Clan clan = ClanRepository.Link().FindByName(name);
        if (clan == null) {
            sender.sendMessage(ChatHelper.PREFIX + "Не найден такой регион");
            return;
        }

        Player player = (Player) sender;

        World tWorld = Bukkit.getServer().getWorld(clan.world);
        Location loc = new Location(tWorld, clan.x, clan.y, clan.z);


        if (ConfigHelper.IsDebug()) {
            System.out.println(ChatColor.YELLOW + ChatHelper.PREFIX + " to ПОЗ:" + loc.getX());
        }


        player.teleport(loc);

        sender.sendMessage(ChatHelper.PREFIX + "Вы телепортированы на спавн клана");
    }

    public static void ListCommand(CommandSender sender) {

        List<Clan> clans = ClanRepository.Link().Get();

        sender.sendMessage(ChatHelper.PREFIX + " Все зареганные кланы на серве: " + clans.size() + " шт.");

        for (int i = 0; i < clans.size(); i++) {
            Clan map = clans.get(i);
            RentChatView.ElementList((Player) sender, map);
        }

    }

    public static void Create(CommandSender sender, String name) {


        List<Clan> clans = ClanRepository.Link().Get();


        if (ClanRepository.Link().FindByName(name) != null) {
            sender.sendMessage(ChatHelper.PREFIX + " Такой клан уже зареган");
            return;
        }

        Clan clan = new Clan();
        clan.name = name;
        clan.price = 1;

        clans.add(clan);

        ClanRepository.Link().Save(clans);


        sender.sendMessage(ChatHelper.PREFIX + " Клан создан");

    }

    public static void Remove(CommandSender sender, String name) {
        sender.sendMessage(ChatHelper.PREFIX + " 1");

        List<Clan> clans = ClanRepository.Link().Get();

        sender.sendMessage(ChatHelper.PREFIX + " 2");

        if (ClanRepository.Link().FindByName(name) == null) {
            sender.sendMessage(ChatHelper.PREFIX + " Такой клан не найден");
            return;
        }

        clans.remove(ClanRepository.Link().FindByName(name));

        ClanRepository.Link().Save(clans);


        sender.sendMessage(ChatHelper.PREFIX + " Клан удален");
    }

    public static void SetSpawn(CommandSender sender, String arg) {


        sender.sendMessage(ChatHelper.PREFIX + " 1 ");
        sender.sendMessage(ChatHelper.PREFIX + " 1.= "+arg);
        Clan clan = ClanRepository.Link().FindByName(arg);

        sender.sendMessage(ChatHelper.PREFIX + " 2");
        if (clan == null) {
            sender.sendMessage(ChatHelper.PREFIX + " Такой клан не найден");
            return;
        }

        sender.sendMessage(ChatHelper.PREFIX + " 3");
        Player player = (Player) sender;

        sender.sendMessage(ChatHelper.PREFIX + " 4");
        Location location = player.getLocation();

        sender.sendMessage(ChatHelper.PREFIX + " 5");

        clan.x = location.getX();
        clan.y = location.getY();
        clan.z = location.getZ();
        sender.sendMessage(ChatHelper.PREFIX + " 6");
        clan.world = location.getWorld().getName();

        sender.sendMessage(ChatHelper.PREFIX + " 7");
        ClanRepository.Link().Save(ClanRepository.Link().Get());

        sender.sendMessage(ChatHelper.PREFIX + " Спавн клана установлен");
    }
}
