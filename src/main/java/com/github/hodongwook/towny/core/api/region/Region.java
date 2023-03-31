package com.github.hodongwook.towny.core.api.region;

import com.github.hodongwook.towny.core.api.location.LazyLocation;
import com.github.hodongwook.towny.core.api.location.LazyWorld;
import com.github.hodongwook.towny.core.api.location.Range;
import com.github.hodongwook.towny.core.api.region.adapter.RegionAdapter;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.Collection;

public interface Region {

    /**
     * 마을의 고유 아이디 값
     * @return 고유 아이디
     */
    long getId();

    /**
     * 마을이 존재하는 월드
     * @return 월드
     */
    LazyWorld getWorld();

    /**
     * 마을 스폰
     * @return 스폰
     */
    LazyLocation getSpawn();

    /**
     * 해당 로케이션을 마을 스폰으로 등록합니다.
     * 해당 위치가 마을 내부에 있는지는 체크하지 않습니다.
     * @param location 새로운 스폰
     */
    default void setSpawn(Location location) { setSpawn(LazyLocation.from(location)); }

    /**
     * 해당 LazyLocation 을 마을 스폰으로 등록합니다.
     * 해당 위치가 마을 내부에 있는지는 체크하지 않습니다.
     * @param location 새로운 스폰
     */
    void setSpawn(LazyLocation location);

    /**
     * 마을의 이름을 얻어옵니다.
     * @return 마을 이름
     */
    String getName();

    /**
     * 마을 구성원들에게 메세지를 보냅니다.
     * @param message 전송 할 메세지
     */
    void sendMessage(String message);

    /**
     * 마을 구성원들에게 메세지를 보냅니다.
     * @param message 전송 할 메세지
     */
    void sendMessage(String... message);

    /**
     * 마을의 커스텀 데이터를 얻어옵니다.
     * @param adapterClass 어댑터를 상속받은 클래스
     * @return 데이터 인스턴스
     * @param <T> 해당 클래스 타입
     */
    <T extends RegionAdapter> T getData(Class<T> adapterClass);

    /**
     * 마을의 범위를 얻어옵니다.
     * @return 마을 범위
     */
    Range getRange();

    /**
     * 해당 청크가 마을 안에 위치하는지 확인합니다.
     * @param chunk 청크
     * @return 마을 안에 있는지 여부
     */
    boolean isInner(Chunk chunk);

    /**
     * 해당 블록이 마을 안에 위치하는지 확인합니다.
     * @param block 블록
     * @return 마을 안에 있는지 여부
     */
    default boolean isInner(Block block) { return isInner(block.getChunk()); }

    /**
     * 해당 플레이어가 마을 안에 위치하는지 확인합니다.
     * @param player 플레이어
     * @return 마을 안에 있는지 여부
     */
    default boolean isInner(Player player) { return isInner(player.getLocation()); }

    /**
     * 해당 로케이션이 마을 안에 위치하는지 확인합니다.
     * @param location 로케이션
     * @return 마을 안에 있는지 여부
     */
    default boolean isInner(Location location) { return isInner(location.getChunk()); }

    /**
     * 플레이어를 마을의 스폰으로 텔레포트 시킵니다.
     * @param player 플레이어
     * @return 텔레포트 성공 여부
     */
    default boolean teleportHere(Player player) {
        LazyLocation center = getSpawn();
        if(center == null) return false;
        return center.teleportHere(player);
    }

    /**
     * 마을 안에 있는 플레이어들을 얻어옵니다.
     * @return 마을 안에 위치한 플레이어들
     */
    Collection<Player> getPlayers();

}
