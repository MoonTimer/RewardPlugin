package me.moontimer.dreampvp.reward;

import me.moontimer.dreampvp.reward.commands.DownloadSongCommand;
import me.moontimer.dreampvp.reward.commands.PlaySongs;
import me.moontimer.dreampvp.reward.commands.RewardCommand;
import me.moontimer.dreampvp.reward.inventory.RewardInventoryListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Reward extends JavaPlugin {

    private static Reward instance;
    private MySQL mySQL;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        mySQL = new MySQL("localhost", "test", "test", "test", "3306");
        mySQL.connect();

        boolean NoteBlockAPI = true;
        if (!Bukkit.getPluginManager().isPluginEnabled("NoteBlockAPI")){
            getLogger().severe("*** NoteBlockAPI is not installed or not enabled. ***");
            NoteBlockAPI = false;
            return;
        }

        getCommand("reward").setExecutor(new RewardCommand());
        getCommand("playsong").setExecutor(new PlaySongs());
        getCommand("download").setExecutor(new DownloadSongCommand());
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new RewardInventoryListener(), this);

        if (!getDataFolder().exists()) {
            getDataFolder().mkdirs();
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Reward getInstance() {
        return instance;
    }

    public MySQL getMySQL() {
        return mySQL;
    }
}
