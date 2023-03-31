package com.github.hodongwook.towny.core.api.location;

import org.bukkit.Chunk;

import java.util.Collection;

public interface Range {

    /**
     * 청크 전체를 가져옵니다.
     * @return 청크 목록
     */
    Collection<Chunk> getChunks();

    /**
     * 해당 청크가 범위에 포함되는지 확인합니다.
     * @param chunk 청크
     * @return 포함 여부
     */
    default boolean inRange(Chunk chunk) { return getChunks().stream().anyMatch(it->it.equals(chunk)); }

}
