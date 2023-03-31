package com.github.hodongwook.towny.core.api.region.adapter;


import com.github.hodongwook.towny.core.api.TownyCore;
import com.github.hodongwook.towny.core.api.region.Region;

/**
 * 확장 클래스는 반드시 비어있는 생성자를 포함해야합니다.
 */
public abstract class RegionAdapter {
    public RegionAdapter() {}
    public String info(Region region) { return ""; }

    public final AdapterConfig getConfig() { return TownyCore.getApi().getRegionAdapterRegistry().getConfig(this.getClass()); }
    public final CommandExecutable getCommand() { return TownyCore.getApi().getRegionAdapterRegistry().getCommand(this.getClass()); }
}