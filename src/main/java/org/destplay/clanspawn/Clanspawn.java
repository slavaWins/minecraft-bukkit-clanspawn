package org.destplay.clanspawn;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.destplay.clanspawn.handles.CommandsHandle;
import org.destplay.clanspawn.helpers.ChatHelper;
import org.destplay.clanspawn.listeners.SignListener;
import org.destplay.clanspawn.repositories.ClanRepository;

public final class Clanspawn extends JavaPlugin {


    @Override
    public void onEnable() {
        ConfigHelper.Init(getDataFolder());
        ClanRepository.Link().Init(getDataFolder());

        getServer().getPluginManager().registerEvents(new SignListener(), this);


    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        //if (!command.getName().equalsIgnoreCase("clanspawn")) return false;




        if (command.getName().equalsIgnoreCase("list")) {
            CommandsHandle.ListCommand(sender);
            return true;
        }


        if (!sender.isOp()) {
            sender.sendMessage("Не хватает прав для выполнения команды");
            return true;
        }

        if (command.getName().equalsIgnoreCase("reload")) {
            // что-то выполняется
            ConfigHelper.Init(getDataFolder());
            reloadConfig();
            saveConfig();
            sender.sendMessage(ChatHelper.PREFIX + " Конфигурация была перезагружена!");

            return true;
        }


        if (command.getName().equalsIgnoreCase("create") && args.length == 1) {
            CommandsHandle.Create(sender, args[0]);
            return true;
        }

        if (command.getName().equalsIgnoreCase("remove") && args.length == 1) {
            CommandsHandle.Remove(sender, args[0]);

            return true;
        }


        if (command.getName().equalsIgnoreCase("tp") && args.length == 1) {
            CommandsHandle.TpTo(sender, args[0]);
            return true;
        }

        sender.sendMessage(ChatHelper.PREFIX + " /" + command.getName());
        if (args.length >0) {
            sender.sendMessage(ChatHelper.PREFIX + " /" + command.getName() + " " + args[0]);
            return true;
        }

        return false;
    }

    /*
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }*/
}
