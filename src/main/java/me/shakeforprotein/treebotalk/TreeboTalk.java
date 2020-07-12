package me.shakeforprotein.treebotalk;

import Commands.OpenGui;
import Listeners.ChatListener;
import Listeners.GuiListener;
import Listeners.JoinListener;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

public final class TreeboTalk extends JavaPlugin implements PluginMessageListener {

    public static TreeboTalk pl;

    @Override
    public void onEnable() {
        pl = this;
        this.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeTalk:channel", this);
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
        // Plugin shutdown logic
    }

    @SuppressWarnings("UnstableApiUsage")
    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        if (!channel.equals("bungeetalk:channel")) {
            return;
        }
        ByteArrayDataInput in = ByteStreams.newDataInput(message);
        String subchannel = in.readUTF();
        String data1 = in.readUTF();
        if (subchannel.startsWith("execute")) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), data1.split(":")[1]);
        }
        else{
            System.out.println("Data was " + data1);
        }
    }
}
