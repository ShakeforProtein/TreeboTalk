package me.shakeforprotein.treebotalk;

import Commands.OpenGui;
import Commands.Wins;
import Listeners.ChatListener;
import Listeners.GuiListener;
import Listeners.JoinListener;
import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;


public final class TreeboTalk extends JavaPlugin implements PluginMessageListener {

    public static TreeboTalk pl;

    @Override
    public void onEnable() {
        pl = this;
        this.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", this);

        getConfig().options().copyDefaults(true);
        getConfig().set("version", this.getDescription().getVersion());
        saveConfig();
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(new ChatListener(), this);
        Bukkit.getPluginManager().registerEvents(new GuiListener(), this);
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);


        this.getCommand("name-col").setExecutor(new OpenGui(this));
        this.getCommand("wins").setExecutor(new Wins());
        this.getCommand("Wins").setTabCompleter(new Wins());

        if (getConfig().get("bstatsIntegration") != null) {
            if (getConfig().getBoolean("bstatsIntegration")) {
                Metrics metrics = new Metrics(this);
            }
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] data) {
        if (!channel.equals("BungeeCord")) return;
        DataInputStream input = new DataInputStream(new ByteArrayInputStream(data));
        String sub = "";
        try {
            sub = input.readUTF();
            if (sub.equals("bungeetalk")) {
                String message = input.readUTF();
                if (message.startsWith("SPCommand:")) {
                    String command = message.split(":", 2)[1];
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
                }else {
                    System.out.println(sub);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
