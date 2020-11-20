package me.uselessmnemonic.boxofchocolates;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

public class BoxOfChocolatesPlugin extends JavaPlugin implements SlimefunAddon {

    private static BoxOfChocolatesPlugin instance;
    public static BoxOfChocolatesPlugin getInstance() {
        return instance;
    }

    public BoxOfChocolatesPlugin() {
        if (instance == null) instance = this;
    }

    public static NamespacedKey getNamespacedKey(String key) {
        return new NamespacedKey(instance, key);
    }

    @Override
    public void onEnable() {
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

    @Override
    public String getBugTrackerURL() {
        return "https://github.com/UselessMnemonic/BoxOfChocolates/issues";
    }
}