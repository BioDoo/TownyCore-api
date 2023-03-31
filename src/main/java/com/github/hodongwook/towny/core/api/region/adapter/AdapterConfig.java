package com.github.hodongwook.towny.core.api.region.adapter;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public abstract class AdapterConfig {

    private final String path;
    private final JavaPlugin plugin;

    public AdapterConfig(String path, JavaPlugin plugin) {
        this.plugin = plugin;
        this.path = path;
        reload();
    }

    public final void reload() {
        File file = new File(plugin.getDataFolder(), path);
        if(!file.exists()) plugin.saveResource(path, false);
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        initializing(config);
    }

    protected abstract void initializing(FileConfiguration config);

}
