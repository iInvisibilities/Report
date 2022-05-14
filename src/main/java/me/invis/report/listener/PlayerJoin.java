package me.invis.report.listener;

import me.invis.report.event.StaffJoinEvent;
import me.invis.report.staff.StaffManager;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    private void onPlayerJoin(PlayerJoinEvent event) {
        if(StaffManager.isStaff(event.getPlayer())) Bukkit.getPluginManager().callEvent(new StaffJoinEvent(event.getPlayer()));
    }

}
