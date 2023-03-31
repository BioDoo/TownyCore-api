package com.github.hodongwook.towny.core.api.manager;

import org.jetbrains.annotations.Nullable;

import java.util.Collection;

public interface Manager<K, V> {

    /**
     * 해당 키 값이 포함 되어있는지 확인합니다.
     * @param key 키
     * @return 포함 여부
     */
    boolean containsKey(K key);

    /**
     * 해당 키 값에 대응하는 값을 가져옵니다.
     * @param key 키
     * @return Value
     */
    @Nullable V get(K key);

    /**
     * 전체 Key 를 가져옵니다.
     * @return Keys
     */
    Collection<? extends K> getKeys();

    /**
     * 전체 Value 를 가져옵니다.
     * @return Values
     */
    Collection<? extends V> getValues();

}
