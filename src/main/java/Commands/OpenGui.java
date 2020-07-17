package Commands;

import me.shakeforprotein.treebotalk.TreeboTalk;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Nameable;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OpenGui implements CommandExecutor {

    private TreeboTalk pl;

    public OpenGui(TreeboTalk main){
        this.pl = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
/*
            Player p = (Player) sender;
            p.setDisplayName(args[0] + p.getName());
            p.setCustomName(args[0] + p.getName());
            p.setPlayerListName(args[0] + p.getName());
*/

            if (!sender.hasPermission("treebotalk.nickname") || args.length == 0) {
                Inventory guiInv = Bukkit.createInventory(null, 36, ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("namecolGuiTitle")));

                ItemStack starBold = new ItemStack(Material.NETHER_STAR, 1);
                ItemStack dyeRed = new ItemStack(Material.RED_DYE, 1);
                ItemStack dyeDarkRed = new ItemStack(Material.REDSTONE, 1);
                ItemStack dyeOrange = new ItemStack(Material.ORANGE_DYE, 1);
                ItemStack dyeYellow = new ItemStack(Material.YELLOW_DYE, 1);
                ItemStack dyeLime = new ItemStack(Material.LIME_DYE, 1);
                ItemStack dyeGreen = new ItemStack(Material.GREEN_DYE, 1);
                ItemStack dyeAqua = new ItemStack(Material.DIAMOND, 1);
                ItemStack dyeCyan = new ItemStack(Material.CYAN_DYE, 1);
                ItemStack dyeLightBlue = new ItemStack(Material.LIGHT_BLUE_DYE, 1);
                ItemStack dyeBlue = new ItemStack(Material.BLUE_DYE, 1);
                ItemStack dyePink = new ItemStack(Material.PINK_DYE, 1);
                ItemStack dyeMagenta = new ItemStack(Material.MAGENTA_DYE, 1);
                ItemStack dyePurple = new ItemStack(Material.PURPLE_DYE, 1);
                ItemStack dyeWhite = new ItemStack(Material.WHITE_DYE, 1);
                ItemStack dyeLightGray = new ItemStack(Material.LIGHT_GRAY_DYE, 1);
                ItemStack dyeGray = new ItemStack(Material.GRAY_DYE, 1);
                ItemStack dyeBrown = new ItemStack(Material.BROWN_DYE, 1);
                ItemStack dyeBlack = new ItemStack(Material.BLACK_DYE, 1);
                ItemStack barrier = new ItemStack(Material.BARRIER, 1);
                ItemStack sVoid = new ItemStack(Material.STRUCTURE_VOID, 1);

                ItemMeta voidMeta = sVoid.getItemMeta();
                voidMeta.setDisplayName("Reset");
                sVoid.setItemMeta(voidMeta);
                ArrayList<String> loreList = new ArrayList<String>();
                loreList.add("Unlock this color on the Treebo Store");
                ItemMeta barrierMeta = barrier.getItemMeta();
                barrierMeta.setLore(loreList);
                barrier.setItemMeta(barrierMeta);
                int i = 0;

                for (i = 0; i < 36; i++) {
                    guiInv.setItem(i, new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE));
                }
                guiInv.setItem(4, starBold);
                guiInv.setItem(9, dyeRed);
                guiInv.setItem(10, dyeDarkRed);
                guiInv.setItem(11, dyeOrange);
                guiInv.setItem(12, dyeYellow);
                guiInv.setItem(13, dyeLime);
                guiInv.setItem(14, dyeGreen);
                guiInv.setItem(15, dyeAqua);
                guiInv.setItem(16, dyeCyan);
                guiInv.setItem(17, dyeLightBlue);
                guiInv.setItem(18, dyeBlue);
                //guiInv.setItem(19, dyePink);
                guiInv.setItem(20, dyeMagenta);
                guiInv.setItem(21, dyePurple);
                guiInv.setItem(22, dyeWhite);
                guiInv.setItem(23, dyeLightGray);
                guiInv.setItem(24, dyeGray);
                //guiInv.setItem(25, dyeBrown);
                guiInv.setItem(26, dyeBlack);
                guiInv.setItem(31, sVoid);

                HashMap<Integer, String> colHash = new HashMap<>();
                colHash.putIfAbsent(4, ChatColor.BOLD + "BOLD");
                colHash.putIfAbsent(9, ChatColor.RED + "Red");
                colHash.putIfAbsent(10, ChatColor.DARK_RED + "Dark Red");
                colHash.putIfAbsent(11, ChatColor.GOLD + "Gold");
                colHash.putIfAbsent(12, ChatColor.YELLOW + "Yellow");
                colHash.putIfAbsent(13, ChatColor.GREEN + "Green");
                colHash.putIfAbsent(14, ChatColor.DARK_GREEN + "Dark Green");
                colHash.putIfAbsent(15, ChatColor.AQUA + "Aqua");
                colHash.putIfAbsent(16, ChatColor.DARK_AQUA + "Cyan");
                colHash.putIfAbsent(17, ChatColor.BLUE + "Light Blue");
                colHash.putIfAbsent(18, ChatColor.DARK_BLUE + "Blue");
                colHash.putIfAbsent(20, ChatColor.LIGHT_PURPLE + "Light Purple");
                colHash.putIfAbsent(21, ChatColor.DARK_PURPLE + "Dark Purple");
                colHash.putIfAbsent(22, ChatColor.WHITE + "White");
                colHash.putIfAbsent(23, ChatColor.GRAY + "Gray");
                colHash.putIfAbsent(24, ChatColor.DARK_GRAY + "Dark Gray");
                colHash.putIfAbsent(26, ChatColor.BLACK + "Black");


                for (i = 4; i < 27; i++) {
                    if (i != 19 && i != 25 && (i>4 && i <9)) {
                        ItemStack slotStack = guiInv.getItem(i);
                        ItemMeta slotMeta = slotStack.getItemMeta();
                        slotMeta.setDisplayName(colHash.get(i));
                        slotStack.setItemMeta(slotMeta);
                        guiInv.setItem(i, slotStack);
                    }
                    if (i == 19 || i == 25 || (i>4 && i<9)) {

                    } else if (!sender.hasPermission("name-col." + guiInv.getItem(i).getType().name()) && !sender.hasPermission("treebotalk.boldname")) {
                        guiInv.setItem(i, barrier);
                        ItemStack slotStack = guiInv.getItem(i);
                        ItemMeta slotMeta = slotStack.getItemMeta();
                        slotMeta.setDisplayName(colHash.get(i));
                        slotStack.setItemMeta(slotMeta);
                        guiInv.setItem(i, slotStack);
                    }

                }


                ((Player) sender).openInventory(guiInv);
            }

/*
            else if(sender.hasPermission("treebotalk.hexColor") && args.length == 2){
                pl.getConfig().set("Nickname." + ((Player) sender).getUniqueId().toString(), args[0]);
                Player p = (Player) sender;
                ((Nameable) p).setCustomName(net.md_5.bungee.api.ChatColor.of("#" + args[0]) + args[1]);

                // p.setCustomName(Nameable.setCustomName() + p.getName());
                //p.setPlayerListName(net.md_5.bungee.api.ChatColor.of(args[0]) + p.getName());
                //p.setDisplayName(net.md_5.bungee.api.ChatColor.of(args[0]) + p.getName());
                if(pl.getConfig().getString("Nickname." + p.getUniqueId().toString()) != null){
                    //p.setDisplayName(pl.getConfig().getString("Nickname." + p.getUniqueId().toString()));
                    //p.setDisplayName(net.md_5.bungee.api.ChatColor.of("#" + args[0]) + args[1]);
                    //p.setPlayerListName(net.md_5.bungee.api.ChatColor.of("#" + args[0]) + args[1]);
                    if(pl.getConfig().getString("PlayerColors." + p.getUniqueId().toString()) != null){
                        //p.setDisplayName(ChatColor.valueOf(pl.getConfig().getString("PlayerColors." + p.getUniqueId().toString())) + pl.getConfig().getString("Nickname." + p.getUniqueId().toString()));
                        //p.setPlayerListName(ChatColor.valueOf(pl.getConfig().getString("PlayerColors." + p.getUniqueId().toString())) + pl.getConfig().getString("Nickname." + p.getUniqueId().toString()));
                        //p.setCustomName(ChatColor.valueOf(pl.getConfig().getString("PlayerColors." + p.getUniqueId().toString())) + pl.getConfig().getString("Nickname." + p.getUniqueId().toString()));
                    }
                }
            }

 */
            else if(sender.hasPermission("treebotalk.nickname") && args.length == 1){
                pl.getConfig().set("Nickname." + ((Player) sender).getUniqueId().toString(), args[0]);
                Player p = (Player) sender;
                p.setCustomName(args[0]);
                p.setPlayerListName(args[0]);
                p.setDisplayName(args[0]);
                if(pl.getConfig().getString("Nickname." + p.getUniqueId().toString()) != null){
                    p.setDisplayName(pl.getConfig().getString("Nickname." + p.getUniqueId().toString()));
                    if(pl.getConfig().getString("PlayerColors." + p.getUniqueId().toString()) != null){
                        p.setDisplayName(ChatColor.valueOf(pl.getConfig().getString("PlayerColors." + p.getUniqueId().toString())) + pl.getConfig().getString("Nickname." + p.getUniqueId().toString()));
                        p.setPlayerListName(ChatColor.valueOf(pl.getConfig().getString("PlayerColors." + p.getUniqueId().toString())) + pl.getConfig().getString("Nickname." + p.getUniqueId().toString()));
                        p.setCustomName(ChatColor.valueOf(pl.getConfig().getString("PlayerColors." + p.getUniqueId().toString())) + pl.getConfig().getString("Nickname." + p.getUniqueId().toString()));
                    }
                }
            }
        }
        return true;
    }
}
