package com.github.hodongwook.towny.core.api.event;

import com.github.hodongwook.towny.core.api.region.Region;
import org.bukkit.event.Event;

public abstract class RegionEvent extends Event {

    private final Region region;

    public RegionEvent(Region region) {
        this.region = region;
    }

    public Region getRegion() { return region; }

}
