package com.github.hodongwook.towny.core.api.region;

import com.github.hodongwook.towny.core.api.region.member.Member;
import com.github.hodongwook.towny.core.api.region.member.OnlineMember;
import com.github.hodongwook.towny.core.api.result.member.MemberAddResult;
import com.github.hodongwook.towny.core.api.result.member.MemberRemoveResult;
import com.github.hodongwook.towny.core.api.result.member.OwnerChangeResult;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.UUID;

/**
 * 플레이어가 생성한 마을
 */
public interface PlayerRegion extends Region {

    /**
     * 마을의 주인을 얻어옵니다.
     * @return 마을 주인 유니크 아이디
     */
    UUID getOwner();

    /**
     * 마을 주인을 변경합니다.
     * @param uniqueId 새로운 주인 유니크 아이디
     * @return 결과
     */
    OwnerChangeResult setOwner(UUID uniqueId);

    /**
     * 마을 구성원을 추가합니다.
     * @param player 대상
     * @return 결과
     */
    MemberAddResult addMember(Player player);

    /**
     * 마을 구성원에서 삭제합니다.
     * @param offlinePlayer 대상
     * @return 결과
     */
    MemberRemoveResult removeMember(OfflinePlayer offlinePlayer);

    /**
     * 마을 구성원들을 얻어옵니다.
     * 오프라인 플레이어도 포함됩니다.
     * @return 마을 구성원
     */
    Collection<Member> getMembers();

    /**
     * 마을 구성원들을 얻어옵니다.
     * 온라인 플레이어만 포함되어 있습니다.
     * @return 온라인 마을 구성원
     */
    Collection<OnlineMember> getOnlineMembers();

    /**
     * 닉네임을 통해 마을 구성원 정보를 얻어옵니다.
     * 온라인이 아닐 경우, null 값이 리턴됩니다.
     * @param name 닉네임
     * @return 온라인 마을 구성원
     */
    @Nullable default OnlineMember getMember(String name) {
        return getOnlineMembers().stream()
                .filter(it-> it.getCachedName().equals(name)).findFirst().orElse(null);
    }

    /**
     * 유니크 아이디를 통해 마을 구성원 정보를 얻어옵니다.
     * 온라인이 아닐 경우, null 값이 리턴됩니다.
     * @param uniqueId 유니크 아이디
     * @return 온라인 마을 구성원
     */
    @Nullable default OnlineMember getMember(UUID uniqueId) {
        return getOnlineMembers().stream()
                .filter(it->it.getUniqueId().equals(uniqueId)).findFirst().orElse(null);
    }

    default int getMaxCount() { return 10; }
    default void setMaxCount(int count) {}

    default int getMaxMemberCount() { return 10; }
    default void setMaxMemberCount(int count) {}

    /**
     * 플레이어 객체를 통해 마을 구성원 정보를 얻어옵니다.
     * 온라인이 아닐 경우, null 값이 리턴됩니다.
     * @param player 플레이어
     * @return 온라인 마을 구성원
     */
    @Nullable default OnlineMember getMember(Player player) {
        return getMember(player.getUniqueId());
    }

    /**
     * 닉네임을 통해 마을 구성원 정보를 얻어옵니다.
     * @param name 닉네임
     * @return 마을 구성원
     */
    @Nullable @Deprecated default Member getOfflineMember(String name) {
        return getMembers().stream()
                .filter(it->it.getCachedName().equals(name)).findFirst().orElse(null);
    }

    /**
     * 유니크 아이디를 통해 마을 구성원 정보를 얻어옵니다.
     * @param uniqueId 유니크 아이디
     * @return 마을 구성원
     */
    @Nullable default Member getOfflineMember(UUID uniqueId) {
        return getMembers().stream().filter(it->it.getUniqueId().equals(uniqueId)).findFirst().orElse(null);
    }

    /**
     * 오프라인 플레이어 객체를 통해 마을 구성원 정보를 얻어옵니다.
     * @param offlinePlayer 오프라인 플레이어
     * @return 마을 구성원
     */
    @Nullable default Member getOfflineMember(OfflinePlayer offlinePlayer) {
        return getOfflineMember(offlinePlayer.getUniqueId());
    }

    /**
     * 해당 플레이어가 이 마을의 구성원인지 확인합니다.
     * @param player 플레이어
     * @return 마을 구성원에 포함되어 있는지에 대한 결과
     */
    default boolean isMember(Player player) { return isMember(player.getUniqueId()); }

    /**
     * 해당 오프라인 플레이어가 이 마을의 구성원인지 확인합니다.
     * @param offlinePlayer 오프라인 플레이어
     * @return 마을 구성원에 포함되어 있는지에 대한 결과
     */
    default boolean isMember(OfflinePlayer offlinePlayer) { return isMember(offlinePlayer.getUniqueId()); }

    /**
     * 해당 유니크 아이디가 이 마을의 구성원인지 확인합니다.
     * @param uniqueId 유니크 아이디
     * @return 마을 구성원에 포함되어 있는지에 대한 결과
     */
    default boolean isMember(UUID uniqueId) { return getOfflineMember(uniqueId) != null; }

}
