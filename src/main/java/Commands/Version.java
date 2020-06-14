package Commands;

import me.shakeforprotein.treebotalk.TreeboTalk;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Version implements CommandExecutor {

    private TreeboTalk pl;

    public Version(TreeboTalk main) {
        this.pl = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        sender.sendMessage(pl.badge + "Version - " + pl.getDescription().getVersion());
        return true;
    }
}