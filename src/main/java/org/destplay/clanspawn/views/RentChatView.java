package org.destplay.clanspawn.views;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.entity.Player;
import org.destplay.clanspawn.contracts.Clan;
import org.destplay.clanspawn.helpers.DateHelper;

import java.util.Date;

public class RentChatView {

    public static void ElementList(Player player, Clan rent) {

        String msg = "";

        msg += ChatColor.GREEN + "[" + rent.name + "] " + ChatColor.RESET;


        msg += " Некий клан ";

        TextComponent message = new TextComponent(msg);


        if (player.isOp()) {
            TextComponent btnTp = new TextComponent("  [TP]");
            btnTp.setColor(ChatColor.AQUA);
            btnTp.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Телепортироваться на спавн клана")));
            btnTp.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/clanspawn:tp " + rent.name));
            message.addExtra(btnTp);
        }

        if (player.isOp()) {
            TextComponent btnTp = new TextComponent("  [SETSPAWN]");
            btnTp.setColor(ChatColor.DARK_AQUA);
            btnTp.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Поменять точку спавна клана")));
            btnTp.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/clanspawn:setspawn " + rent.name));
            message.addExtra(btnTp);
        }

        if (player.isOp()) {
            TextComponent btnTp = new TextComponent("  [DELETE]");
            btnTp.setColor(ChatColor.RED);
            btnTp.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Удалить клан")));
            btnTp.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/clanspawn:remove " + rent.name));
            message.addExtra(btnTp);
        }

        player.spigot().sendMessage(message);


    }
}
