package com.github.hodongwook.towny.core.api.location;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.jetbrains.annotations.Nullable;

public interface LazyWorld {

    /**
     * 버킷 api 의 월드 객체로 가져옵니다.
     * @return Bukkit World
     */
    @Nullable World getBukkitWorld();

    /**
     * 해당 월드의 이름을 가져옵니다.
     * @return 월드 이름
     */
    String getName();

    static LazyWorld from(World world) {
        return new LazyWorld() {
            @Override public World getBukkitWorld() { return world; }
            @Override public String getName() { return world.getName(); }
        };
    }

    static LazyWorld from(String worldName) {
        return new LazyWorld() {
            private World world = null;
            @Override public World getBukkitWorld() {
                if(world == null) world = Bukkit.getWorld(worldName);
                return world;
            }
            @Override public String getName() { return worldName; }
        };
    }

}
