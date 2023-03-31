package com.github.hodongwook.towny.core.api.registry;

import com.github.hodongwook.towny.core.api.region.adapter.AdapterConfig;
import com.github.hodongwook.towny.core.api.region.adapter.CommandExecutable;
import com.github.hodongwook.towny.core.api.region.adapter.RegionAdapter;

public interface RegionAdapterRegistry {

    /**
     * 커스텀으로 제작한 어댑터를 등록합니다.
     * @param adapterClass 어댑터를 상속받은 클래스
     * @param <T> 해당 어댑터의 타입
     */
    <T extends RegionAdapter> void register(Class<T> adapterClass);
    <T extends RegionAdapter> void register(Class<T> adapterClass, CommandExecutable command);
    <T extends RegionAdapter> void register(Class<T> adapterClass, AdapterConfig config);
    <T extends RegionAdapter> void register(Class<T> adapterClass, CommandExecutable command, AdapterConfig config);

    <T extends RegionAdapter> CommandExecutable getCommand(Class<T> adapterClass);
    <T extends RegionAdapter> AdapterConfig getConfig(Class<T> adapterClass);

}
