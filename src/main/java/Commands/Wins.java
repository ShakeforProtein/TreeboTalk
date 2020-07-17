package Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Wins implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        List<String> outputStrings = new ArrayList<>();
        List<String> inputStrings = new ArrayList<>();

        if (args.length == 0) {
            inputStrings.add("SpeedTypist");
            inputStrings.add("Unscramble");
        }

        if (args.length == 1) {
            inputStrings.add("SpeedTypist");
            inputStrings.add("Unscramble");
        }

        if (args.length == 2) {
            inputStrings.add("Top");
            inputStrings.add("TopSpeed");
            for (Player p : Bukkit.getOnlinePlayers()) {
                inputStrings.add(p.getName());
            }
        }

        for (String input : inputStrings) {
            if (args.length == 0 || args[args.length - 1].toLowerCase().startsWith(input)) {
                outputStrings.add(input);
            }
        }
        return outputStrings;
    }
}
