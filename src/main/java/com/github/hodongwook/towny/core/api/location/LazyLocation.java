package com.github.hodongwook.towny.core.api.location;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.Nullable;

public interface LazyLocation {

    LazyWorld getWorld();

    @Nullable default World getBukkitWorld() { return getWorld().getBukkitWorld(); }
    @Nullable default Location getBukkitLocation() {
        World bukkitWorld = getBukkitWorld();
        if(bukkitWorld == null) return null;
        return new Location(bukkitWorld, getX(), getY(), getZ());
    }

    double getX();
    double getY();
    double getZ();
    default float getYaw() { return 0f; }
    default float getPitch() { return 0f; }

    default boolean teleportHere(Entity entity) {
        Location location = getBukkitLocation();
        if(location == null) return false;
        entity.teleport(location);
        return true;
    }

    default int getBlockX() { return (int) getX(); }
    default int getBlockY() { return (int) getY(); }
    default int getBlockZ() { return (int) getZ(); }

    static LazyLocation from(Location location) {
        final LazyWorld lazyWorld = LazyWorld.from(location.getWorld());
        return from(lazyWorld, location.getX(), location.getY(), location.getZ());
    }

    static LazyLocation from(String worldName, double x, double y, double z) {
        final LazyWorld lazyWorld = LazyWorld.from(worldName);
        return from(lazyWorld, x, y, z);
    }

    static LazyLocation from(World world, double x, double y, double z) {
        final LazyWorld lazyWorld = LazyWorld.from(world);
        return from(lazyWorld, x, y, z);
    }

    static LazyLocation from(LazyWorld world, double x, double y, double z) {
        return new LazyLocation() {
            @Override public LazyWorld getWorld() { return world; }
            @Override public double getX() { return x; }
            @Override public double getY() { return y; }
            @Override public double getZ() { return z; }
        };
    }

}
