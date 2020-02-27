package Listeners;

import me.shakeforprotein.treebotalk.TreeboTalk;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    TreeboTalk pl = TreeboTalk.pl;

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Bukkit.getScheduler().runTaskLater(pl, new Runnable() {
            @Override
            public void run() {
                if (pl.getConfig().getConfigurationSection("PlayerColors") != null) {
                    if (pl.getConfig().getConfigurationSection("PlayerColors").getKeys(false).size() > 0) {
                        if (pl.getConfig().getConfigurationSection("PlayerColors").getKeys(false).contains(e.getPlayer().getUniqueId() + "")) {
                            String col = pl.getConfig().getString("PlayerColors." + e.getPlayer().getUniqueId() + "");
                            (e.getPlayer()).setPlayerListName(ChatColor.RESET + "" + ChatColor.valueOf(col) + e.getPlayer().getName());
                            (e.getPlayer()).setDisplayName(ChatColor.RESET + "" + ChatColor.valueOf(col) + e.getPlayer().getName());
                            (e.getPlayer()).setCustomName(ChatColor.RESET + "" + ChatColor.valueOf(col) + e.getPlayer().getName());
                            e.getPlayer().sendMessage(ChatColor.GOLD + "Your name has been updated to " + ChatColor.RESET + "" + ChatColor.valueOf(col) + e.getPlayer().getName());
                        }
                    }
                }
                if (pl.getConfig().getConfigurationSection("Nickname") != null) {
                    if(pl.getConfig().getString("Nickname." + e.getPlayer().getUniqueId().toString()) != null){
                        e.getPlayer().setDisplayName(pl.getConfig().getString("Nickname." + e.getPlayer().getUniqueId().toString()));
                        if(pl.getConfig().getString("PlayerColors." + e.getPlayer().getUniqueId().toString()) != null){
                            e.getPlayer().setDisplayName(ChatColor.valueOf(pl.getConfig().getString("PlayerColors." + e.getPlayer().getUniqueId().toString())) + pl.getConfig().getString("Nickname." + e.getPlayer().getUniqueId().toString()));
                            e.getPlayer().setPlayerListName(ChatColor.valueOf(pl.getConfig().getString("PlayerColors." + e.getPlayer().getUniqueId().toString())) + pl.getConfig().getString("Nickname." + e.getPlayer().getUniqueId().toString()));
                            e.getPlayer().setCustomName(ChatColor.valueOf(pl.getConfig().getString("PlayerColors." + e.getPlayer().getUniqueId().toString())) + pl.getConfig().getString("Nickname." + e.getPlayer().getUniqueId().toString()));
                        }
                    }
                }
            }
        }, 100);

    }
}
