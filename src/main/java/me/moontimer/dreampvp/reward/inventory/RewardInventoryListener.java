package me.moontimer.dreampvp.reward.inventory;

import me.moontimer.dreampvp.reward.MySQLPlayerManager;
import me.moontimer.dreampvp.reward.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class RewardInventoryListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        try {
            if (event.getView().getTitle().equals("§aRewards")) {
                event.setCancelled(true);
                switch (event.getCurrentItem().getItemMeta().getDisplayName()) {
                    case "§a1000 Coins":
                        if (enoughTime(player, 5, 0)) {
                            player.getInventory().addItem(new ItemBuilder(Material.GOLD_BLOCK).build());
                        }
                        break;
                    case "§a2000 Coins":
                        if (enoughTime(player, 10, 1)) {
                            player.getInventory().addItem(new ItemBuilder(Material.GOLD_BLOCK).build());
                        }
                        break;
                    case "§a3000 Coins":
                        if (enoughTime(player, 15, 2)) {
                            player.getInventory().addItem(new ItemBuilder(Material.GOLD_BLOCK).build());
                        }
                        break;
                    case "§a4000 Coins":
                        if (enoughTime(player, 20,3)) {
                            player.getInventory().addItem(new ItemBuilder(Material.GOLD_BLOCK).build());
                        }
                        break;
                    default:
                        break;
                }

            }
        } catch (NullPointerException ignored) {

        }
    }

    private boolean enoughTime(Player player, int min, int abgeholt) {
        if (MySQLPlayerManager.getTime(player.getUniqueId()) >= min && MySQLPlayerManager.getSuccess(player.getUniqueId()) == abgeholt) {
            MySQLPlayerManager.addSuccess(player.getUniqueId());
            player.sendMessage("§aDu hast die Belohnung erfolgreich abgeholt");
            return true;
        }
        player.sendMessage("§cDu musst zuerst die " + (MySQLPlayerManager.getSuccess(player.getUniqueId())+1) + " Belohnung abholen / Du hast zu wenig OnlineZeit");
        return false;
    }
}
