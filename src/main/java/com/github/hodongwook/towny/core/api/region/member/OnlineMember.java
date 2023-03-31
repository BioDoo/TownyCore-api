package com.github.hodongwook.towny.core.api.region.member;

import com.github.hodongwook.towny.core.api.region.Region;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public interface OnlineMember extends Member {

    /**
     * 플레이어 객체를 가져옵니다.
     * @return 플레이어
     */
    Player getPlayer();

    /**
     * 메세지를 보냅니다.
     * @param message 메세지
     */
    default void sendMessage(String message) { getPlayer().sendMessage(message); }

    /**
     * 메세지를 보냅니다.
     * @param message 메세지
     */
    default void sendMessage(String... message) { getPlayer().sendMessage(message); }

    /**
     * 다른 위치로 텔레포트 시킵니다.
     * @param location 로케이션
     */
    default void teleport(Location location) { getPlayer().teleport(location); }

    /**
     * 해당 엔티티가 있는 위치로 텔레포트 시킵니다.
     * @param entity 엔티티
     */
    default void teleport(Entity entity) { getPlayer().teleport(entity); }

    /**
     * 해당 마을의 스폰으로 텔레포트 시킵니다.
     * @param region 마을
     * @return 텔레포트 성공 여부
     */
    default boolean teleport(Region region) { return region.teleportHere(getPlayer()); }

    @Override default OnlineMember getOnlineMember() { return this; }

}
