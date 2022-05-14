package me.invis.report.staff.listener;

import me.invis.report.event.StaffJoinEvent;
import me.invis.report.staff.StaffManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class Join implements Listener {

    @EventHandler
    private void onStaffJoin(StaffJoinEvent event) {
        StaffManager.addNewStaffMember(event.getPlayer());
    }

}
