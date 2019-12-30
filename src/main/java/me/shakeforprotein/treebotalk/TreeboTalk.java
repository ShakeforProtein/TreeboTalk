package me.shakeforprotein.treebotalk;

import Commands.OpenGui;
import Listeners.ChatListener;
import Listeners.GuiListener;
import Listeners.JoinListener;
import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class TreeboTalk extends JavaPlugin {

    public static TreeboTalk pl;

    @Override
    public void onEnable() {
        pl = this;
        getConfig().options().copyDefaults(true);
        getConfig().set("version", this.getDescription().getVersion());
        saveConfig();
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(new ChatListener(), this);
        Bukkit.getPluginManager().registerEvents(new GuiListener(), this);
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);

        this.getCommand("name-col").setExecutor(new OpenGui(this));
        if(getConfig().get("bstatsIntegration") != null) {
            if (getConfig().getBoolean("bstatsIntegration")) {
                Metrics metrics = new Metrics(this);
            }
        }
    }

    @Override
    public void onDisable() {
        saveConfig();
        // Plugin shutdown logic
    }

}
