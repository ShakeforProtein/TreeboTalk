package Commands;

import me.shakeforprotein.treebotalk.TreeboTalk;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class Reload implements CommandExecutor {

    private TreeboTalk pl;

    public Reload(TreeboTalk main) {
        this.pl = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
                        pl.reloadConfig();
                        sender.sendMessage(pl.badge + "Config Reloaded");
                    return true;
                }
}
