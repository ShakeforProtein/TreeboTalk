package Commands;

import me.shakeforprotein.treebotalk.TreeboTalk;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ClearMyChat implements CommandExecutor {

    private TreeboTalk pl;

    public ClearMyChat(TreeboTalk main) {
        this.pl = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
                        int i;
                        for (i = 0; i < 30; i++) {
                            sender.sendMessage("");
                        }
                    return true;
    }
}