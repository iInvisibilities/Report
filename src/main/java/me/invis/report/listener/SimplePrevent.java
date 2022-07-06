package me.invis.report.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class SimplePrevent implements Listener {

    @EventHandler
    private void onInventoryClickEvent(InventoryClickEvent event) {
        if(event.getClickedInventory().getName().equalsIgnoreCase("Current reports:")) event.setCancelled(true);
    }

}
