package me.moontimer.dreampvp.reward.inventory;

import me.moontimer.dreampvp.reward.MySQLPlayerManager;
import me.moontimer.dreampvp.reward.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class RewardInventory {

    private final Player player;

    public RewardInventory(Player player) {
        this.player = player;

        openInventory();
    }


    private void openInventory() {
        Inventory inventory = Bukkit.createInventory(null, 9*5, "§aRewards");

        inventory.setItem(0, new ItemBuilder(Material.CHEST_MINECART, "§a1000 Coins").lore("==1000 Coins", "§c5 min Online Time").enchant(Enchantment.CHANNELING, 1).build());
        inventory.setItem(1, new ItemBuilder(Material.CHEST_MINECART, "§a1000 Coins").lore("==1000 Coins", "§c5 min Online Time").enchant(Enchantment.CHANNELING, 1).build());
        inventory.setItem(2, new ItemBuilder(Material.CHEST_MINECART, "§a1000 Coins").lore("==1000 Coins", "§c5 min Online Time").enchant(Enchantment.CHANNELING, 1).build());
        inventory.setItem(3, new ItemBuilder(Material.CHEST_MINECART, "§a1000 Coins").lore("==1000 Coins", "§c5 min Online Time").enchant(Enchantment.CHANNELING, 1).build());
        inventory.setItem(4, new ItemBuilder(Material.CHEST_MINECART, "§a1000 Coins").lore("==1000 Coins", "§c5 min Online Time").enchant(Enchantment.CHANNELING, 1).build());
        inventory.setItem(5, new ItemBuilder(Material.CHEST_MINECART, "§a1000 Coins").lore("==1000 Coins", "§c5 min Online Time").enchant(Enchantment.CHANNELING, 1).build());
        inventory.setItem(6, new ItemBuilder(Material.CHEST_MINECART, "§a1000 Coins").lore("==1000 Coins", "§c5 min Online Time").enchant(Enchantment.CHANNELING, 1).build());

        for (int i = 0; i <= MySQLPlayerManager.getSuccess(player.getUniqueId()); i++) {
            if (!(i == 0))
                inventory.setItem(i, new ItemBuilder(Material.MINECART, "§cAbgeholt").build());
        }

        player.openInventory(inventory);
    }
}
