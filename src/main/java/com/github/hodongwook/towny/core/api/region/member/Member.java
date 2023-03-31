package com.github.hodongwook.towny.core.api.region.member;

import com.github.hodongwook.towny.core.api.region.PlayerRegion;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public interface Member {

    /**
     * 오프라인 플레이어 객체를 반환합니다.
     * @return 오프라인 플레이어
     */
    OfflinePlayer getOfflinePlayer();

    /**
     * 유니크 아이디를 얻어옵니다.
     * @return 유니크 아이디
     */
    UUID getUniqueId();

    /**
     * 캐싱 된 닉네임을 얻어옵니다.
     * @return 캐싱 된 닉네임
     */
    String getCachedName();

    /**
     * 해당 플레이어가 온라인인지 확인합니다.
     * @return 온라인 여부
     */
    boolean isOnline();

    /**
     * 온라인 구성원 정보 객체로 변경하여 가져옵니다.
     * 온라인이 아닐 경우, null 값이 리턴됩니다.
     * @return 온라인 구성원 정보
     */
    @Nullable OnlineMember getOnlineMember();

    /**
     * 자신의 마을 정보를 가져옵니다.
     * 머을이 없을 경우, null 값을 리턴합니다.
     * @return 마을 정보
     */
    @Nullable PlayerRegion getRegion();

}
