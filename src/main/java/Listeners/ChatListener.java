package Listeners;

import me.shakeforprotein.treebotalk.TreeboTalk;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;

import java.util.ArrayList;
import java.util.List;

public class ChatListener implements Listener {

    private TreeboTalk pl;

    @EventHandler
    public void onCommandInChat(AsyncPlayerChatEvent e) {
        if (!e.isCancelled()) {
            String message = e.getMessage();
            StringBuilder sB = new StringBuilder();
            boolean block = false;
            boolean cont = false;
            boolean cont1 = false;
            for (String msg : message.split(" ")) {
                if(msg.startsWith("@") && !(msg.equalsIgnoreCase("@admin") || msg.equalsIgnoreCase("@helper") || msg.equalsIgnoreCase("@mod") || msg.equalsIgnoreCase("@srmod"))){
                    msg = "@_" + msg.replace("@", "");
                }

                if (msg.length() > 1 && msg.startsWith("/") && !msg.startsWith(ChatColor.GOLD + "" + ChatColor.BOLD + "/")) {
                    msg = ChatColor.GOLD + "" + ChatColor.BOLD + msg;
                    block = true;
                }

                if (cont) {
                    msg = ChatColor.RED + "" + ChatColor.BOLD + msg;
                }
                if (msg.length() > 1 && msg.startsWith("<")) {
                    msg = ChatColor.RED + "" + ChatColor.BOLD + msg;
                    if (!msg.endsWith(">")) {
                        cont = true;
                    }
                } else if (msg.length() > 1 && msg.endsWith(">")) {
                    msg = ChatColor.RED + "" + ChatColor.BOLD + msg;
                    cont = false;
                }

                if (cont1) {
                    msg = ChatColor.GREEN + "" + ChatColor.BOLD + msg;
                }
                if (msg.length() > 1 && msg.startsWith("[")) {
                    msg = ChatColor.GREEN + "" + ChatColor.BOLD + msg;
                    if (!msg.endsWith("]")) {
                        cont1 = true;
                    }
                } else if (msg.length() > 1 && msg.endsWith("]")) {
                    msg = ChatColor.GREEN + "" + ChatColor.BOLD + msg;
                    cont1 = false;
                }

                msg = msg + ChatColor.RESET + " ";
                sB.append(msg);
            }
            if (block) {
                e.setMessage(sB.toString());
                //e.getPlayer().sendMessage(sB.toString());
            }

        }
    }
}

