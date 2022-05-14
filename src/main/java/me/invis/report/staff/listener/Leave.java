package me.invis.report.staff.listener;

import me.invis.report.event.StaffLeaveEvent;
import me.invis.report.staff.StaffManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class Leave implements Listener {

    @EventHandler
    private void onLeave(StaffLeaveEvent event) {
        StaffManager.removeNewStaffMember(event.getPlayer());
    }

}
