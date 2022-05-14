package me.invis.report.listener;

import me.invis.report.event.StaffLeaveEvent;
import me.invis.report.staff.StaffManager;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeave implements Listener {

    @EventHandler
    private void onPlayerLeave(PlayerQuitEvent event) {
        if(StaffManager.isStaff(event.getPlayer())) Bukkit.getPluginManager().callEvent(new StaffLeaveEvent(event.getPlayer()));
    }

}
