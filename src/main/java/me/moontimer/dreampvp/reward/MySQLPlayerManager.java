package me.moontimer.dreampvp.reward;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class MySQLPlayerManager {
    public static int getTime(UUID uuid) {
        try {
            ResultSet rs = Reward.getInstance().getMySQL().executeQuery("SELECT * FROM PlayerTimes WHERE UUID = '" + uuid.toString() + "'");
            if (rs.next())
                return rs.getInt("PlayTime");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int getSuccess(UUID uuid) {
        try {
            ResultSet rs = Reward.getInstance().getMySQL().executeQuery("SELECT * FROM PlayerTimes WHERE UUID = '" + uuid.toString() + "'");
            if (rs.next())
                return rs.getInt("Abgeholt");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void addSuccess(UUID uuid) {
        Reward.getInstance().getMySQL().execute("UPDATE PlayerTimes SET Abgeholt = '" + (getSuccess(uuid) + 1) + "' WHERE UUID = '" + uuid.toString() + "'");
    }
}
