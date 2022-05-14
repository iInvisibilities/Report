package me.invis.report.staff;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class StaffManager {

    private static final List<Player> currentStaff = new ArrayList<>();

    public static List<Player> getCurrentStaff() {
        return currentStaff;
    }

    public static void addNewStaffMember(Player staffMember) {
        currentStaff.add(staffMember);
    }

    public static void removeNewStaffMember(Player staffMember) {
        currentStaff.remove(staffMember);
    }

    public static boolean isStaff(Player player) {
        return player.hasPermission("report.permission.staff");
    }

}
