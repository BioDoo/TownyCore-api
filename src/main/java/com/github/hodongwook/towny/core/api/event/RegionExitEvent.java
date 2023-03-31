package com.github.hodongwook.towny.core.api.event;

import com.github.hodongwook.towny.core.api.region.Region;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

public class RegionExitEvent extends RegionEvent implements Cancellable {

    public static enum Cause {
        QUIT,
        MOVE,
        TELEPORT,
        DEATH
    }

    private final static HandlerList HANDLER_LIST = new HandlerList();
    private final Player player;
    private final Cause cause;
    private boolean cancelled;

    public RegionExitEvent(Region region, Player player, Cause cause) {
        super(region);
        this.player = player;
        this.cause = cause;
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
    public Cause getCause() { return cause; }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        cancelled = b;
    }
}
