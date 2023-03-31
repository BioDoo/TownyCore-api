package com.github.hodongwook.towny.core.api.manager;

import com.github.hodongwook.towny.core.api.region.PlayerRegion;
import com.github.hodongwook.towny.core.api.region.Region;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public interface RegionManager extends Manager<Long, Region> {

    /**
     * 마을 고유 아이디를 통해 마을 정보를 얻어옵니다.
     * @param regionId 마을 고유 아이디
     * @return 마을 정보
     */
    @Nullable Region getRegion(Long regionId);

    /**
     * 마을 이름을 통해 마을 정보를 얻어옵니다.
     * @param regionName 마을 이름
     * @return 마을 정보
     */
    @Nullable Region getRegion(String regionName);

    /**
     * 청크를 통해 마을 정보를 얻어옵니다.
     * @param chunk 청크
     * @return 마을 정보
     */
    @Nullable Region getRegion(Chunk chunk);

    /**
     * 로케이션을 통해 마을 정보를 얻어옵니다.
     * @param location 로케이션
     * @return 마을 정보
     */
    @Nullable Region getRegion(Location location);

    /**
     * 유니크 아이디를 통해 해당 유저가 소속 된 마을을 얻어옵니다.
     * @param uniqueId 유니크 아이디
     * @return 플레이어 마을 정보
     */
    @Nullable PlayerRegion getRegion(UUID uniqueId);

    /**
     * 플레이어 객체를 통해 해당 유저가 소속 된 마을을 얻어옵니다.
     * @param player 플레이어
     * @return 플레이어 마을 정보
     */
    @Nullable PlayerRegion getRegion(Player player);

    /**
     * 오프라인 플레이어 객체를 통해 해당 유저가 소속 된 마을을 얻어옵니다.
     * @param offlinePlayer 오프라인 플레이어
     * @return 플레이어 마을 정보
     */
    @Nullable PlayerRegion getRegion(OfflinePlayer offlinePlayer);

}
