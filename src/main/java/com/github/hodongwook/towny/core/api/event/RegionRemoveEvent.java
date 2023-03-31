package com.github.hodongwook.towny.core.api.event;

import com.github.hodongwook.towny.core.api.region.Region;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

public class RegionRemoveEvent extends RegionEvent implements Cancellable {

    private final static HandlerList HANDLER_LIST = new HandlerList();
    private final Player player;
    private boolean cancelled;

    public RegionRemoveEvent(Region region, Player player) {
        super(region);
        this.player = player;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        cancelled = b;
    }
}
