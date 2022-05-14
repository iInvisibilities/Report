package me.invis.report.event;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

public class StaffLeaveEvent extends PlayerEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public StaffLeaveEvent(Player player) {
        super(player);
    }

    @Override
    public HandlerList getHandlers() {
        return getHandlerList();
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

}
