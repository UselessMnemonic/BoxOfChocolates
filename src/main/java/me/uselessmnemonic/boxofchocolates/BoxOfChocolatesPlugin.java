package me.uselessmnemonic.boxofchocolates;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import me.uselessmnemonic.boxofchocolates.chocolates.DarkChocolateCaramel;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class BoxOfChocolatesPlugin extends JavaPlugin implements SlimefunAddon {

    /**
     * Singleton access
     */
    private static BoxOfChocolatesPlugin instance;
    public static BoxOfChocolatesPlugin getInstance() {
        return instance;
    }

    public BoxOfChocolatesPlugin() {
        if (instance == null) instance = this;
    }

    /**
     * Creates a NamespacedKey under this plugin.
     * @param key Name of the key
     * @return A NamespacedKey
     */
    public static NamespacedKey getNamespacedKey(String key) {
        return new NamespacedKey(instance, key);
    }

    @Override
    public void onEnable() {

        // create our chocolate category
        NamespacedKey categoryKey = BoxOfChocolatesPlugin.getNamespacedKey("Chocolates");
        CustomItem categoryItem = new CustomItem(Material.COCOA, ChatColor.WHITE + "Dulces de chocolate!");
        Category chocolateCategory = new Category(categoryKey, categoryItem);

        // create the in-game item
        SlimefunItemStack itemStack = new SlimefunItemStack("DARK_CHOC_CARMEL", Material.COCOA, "Dark Chocolate Caramel", "Bitter chocolate with a", "gooey caramel center.");

        // a crafting recipe (3x3)
        ItemStack[] recipe = {
                new ItemStack(Material.COCOA_BEANS), new ItemStack(Material.SUGAR), null,
                null, null, null,
                null, null, null
        };

        // introduce item into game
        DarkChocolateCaramel darkChocolateCaramel = new DarkChocolateCaramel(chocolateCategory, itemStack, RecipeType.NULL, recipe);
        darkChocolateCaramel.register(this);
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