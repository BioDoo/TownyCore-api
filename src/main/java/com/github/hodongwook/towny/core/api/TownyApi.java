package com.github.hodongwook.towny.core.api;

import com.github.hodongwook.towny.core.api.manager.RegionManager;
import com.github.hodongwook.towny.core.api.registry.RegionAdapterRegistry;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * Towny 시스템의 대부분의 기능을 이 곳에서 수행할 수 있습니다.
 */
public interface TownyApi {

    default String getGlobalPrefix() { return ""; }

    /**
     * 마을 관리 매니저를 얻어옵니다.
     * @return RegionManager
     */
    RegionManager getRegionManager();

    /**
     * 마을에 커스텀으로 어댑터를 등록할 수 있는
     * 레지스트리를 얻어옵니다.
     * @return RegionAdapterRegistry
     */
    RegionAdapterRegistry getRegionAdapterRegistry();

    /**
     * 해당 플레이어가 마을에 소속 되어있는지 확인합니다.
     * @param player 플레이어
     * @return 마을 소속 여부
     */
    default boolean hasRegion(Player player) { return getRegionManager().getRegion(player) != null; }

    /**
     * 해당 (오프라인)플레이어가 마을에 소속 되어있는지 확인합니다.
     * @param offlinePlayer (오프라인)플레이어
     * @return 마을 소속 여부
     */
    default boolean hasRegion(OfflinePlayer offlinePlayer) { return getRegionManager().getRegion(offlinePlayer) != null; }

    /**
     * 유니크 아이디 값을 통해 마을 소속 여부를 확인합니다.
     * @param uniqueId 마인크래프트 유니크 아이디
     * @return 마을 소속 여부
     */
    default boolean hasRegion(UUID uniqueId) { return getRegionManager().getRegion(uniqueId) != null; }

}
