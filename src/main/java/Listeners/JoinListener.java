package Listeners;

import me.shakeforprotein.treebotalk.TreeboTalk;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinListener implements Listener {

    TreeboTalk pl = TreeboTalk.pl;

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Bukkit.getScheduler().runTaskLater(pl, new Runnable() {
            @Override
            public void run() {
                if(pl.getConfig().getConfigurationSection("PlayerColors").getKeys(false).contains(e.getPlayer().getUniqueId() + "")){
                    String col = pl.getConfig().getString("PlayerColors." + e.getPlayer().getUniqueId() + "");
                    (e.getPlayer()).setPlayerListName(ChatColor.valueOf(col) + e.getPlayer().getName());
                    (e.getPlayer()).setDisplayName(ChatColor.valueOf(col) + e.getPlayer().getName());
                    (e.getPlayer()).setCustomName(ChatColor.valueOf(col) + e.getPlayer().getName());
                    e.getPlayer().sendMessage(ChatColor.GOLD + "Your name has been updated to " + ChatColor.valueOf(col) + e.getPlayer().getName());
                }
            }
        }, 100);

    }
}
