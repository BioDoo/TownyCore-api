package com.github.hodongwook.towny.core.api.region;

import org.bukkit.ChatColor;

/**
 * 서버 전체 적용되는 마을
 * 해당 마을의 고유 아이디는 -1 로 고정되어 있습니다.
 */
public interface ServerRegion extends Region {

    @Override default long getId() { return -1; }
    @Override default String getName() { return ChatColor.RED + "서버 마을"; }

}
