package me.shakeforprotein.treebotalk;

import Commands.ClearMyChat;
import Commands.OpenGui;
import Commands.Reload;
import Commands.Version;
import Listeners.ChatListener;
import Listeners.GuiListener;
import Listeners.JoinListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDateTime;

public final class TreeboTalk extends JavaPlugin {

    public static TreeboTalk pl;

    private ClearMyChat nameIt = new ClearMyChat(this);
    private Reload reload = new Reload(this);
    private Version version = new Version(this);

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
        this.getCommand("treebotalkreload").setExecutor(new Reload(this));
        this.getCommand("treebotalkversion").setExecutor(new Version(this));
        this.getCommand("clearmychat").setExecutor(new ClearMyChat(this));
    }

    @Override
    public void onDisable() {

    }

    public String badge = ChatColor.translateAlternateColorCodes('&', getConfig().getString("general.messages.badge") + " ");
    public String err = badge + ChatColor.translateAlternateColorCodes('&', getConfig().getString("general.messages.error") + " ");

    public void makeLog(Exception tr) {
        System.out.println("Creating new log folder - " + new File(this.getDataFolder() + File.separator + "logs").mkdir());
        String dateTimeString = LocalDateTime.now().toString().replace(":", "_").replace("T", "__");
        File file = new File(this.getDataFolder() + File.separator + "logs" + File.separator + dateTimeString + "-" + tr.getCause() + ".log");
        try {
            PrintStream ps = new PrintStream(file);
            tr.printStackTrace(ps);
            System.out.println(this.getDescription().getName() + " - " + this.getDescription().getVersion() + "Encountered Error of type: " + tr.getCause());
            System.out.println("A log file has been generated at " + this.getDataFolder() + File.separator + "logs" + File.separator + dateTimeString + "-" + tr.getCause() + ".log");
            ps.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error creating new log file for " + getDescription().getName() + " - " + getDescription().getVersion());
            System.out.println("Error was as follows");
            System.out.println(e.getMessage());
        }
    }
}
