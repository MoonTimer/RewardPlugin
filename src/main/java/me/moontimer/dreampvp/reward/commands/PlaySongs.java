package me.moontimer.dreampvp.reward.commands;

import com.xxmicloxx.NoteBlockAPI.model.Song;
import com.xxmicloxx.NoteBlockAPI.songplayer.RadioSongPlayer;
import com.xxmicloxx.NoteBlockAPI.songplayer.SongPlayer;
import com.xxmicloxx.NoteBlockAPI.utils.NBSDecoder;
import me.moontimer.dreampvp.reward.Reward;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.File;

public class PlaySongs implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 1) {
            Song song = NBSDecoder.parse(new File(Reward.getInstance().getDataFolder(), args[0]));

            SongPlayer sp = new RadioSongPlayer(song);

            sp.addPlayer((Player) sender);

            sp.setPlaying(true);

            sender.sendMessage("§aDer song wird abgespielt");
        }


        return false;
    }
}
