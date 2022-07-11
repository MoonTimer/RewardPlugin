package me.moontimer.dreampvp.reward.commands;

import me.moontimer.dreampvp.reward.Reward;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class DownloadSongCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        try {
            downloadUsingStream(args[0], Reward.getInstance().getDataFolder() + "/" + args[1]);
            sender.sendMessage("heruntergeladen");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    private static void downloadUsingStream(String urlStr, String file) throws IOException {
        URL url = new URL(urlStr);
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        FileOutputStream fis = new FileOutputStream(file);
        byte[] buffer = new byte[1024];
        int count=0;
        while((count = bis.read(buffer,0,1024)) != -1)
        {
            fis.write(buffer, 0, count);
        }
        fis.close();
        bis.close();
    }
}
