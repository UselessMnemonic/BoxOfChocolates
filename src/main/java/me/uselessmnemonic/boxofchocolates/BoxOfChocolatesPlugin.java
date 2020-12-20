package me.uselessmnemonic.boxofchocolates;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import me.uselessmnemonic.boxofchocolates.chocolates.ChocolateCarrotTruffle;
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
    private static BoxOfChocolatesPlugin instance = null;
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
        NamespacedKey categoryKey = BoxOfChocolatesPlugin.getNamespacedKey("category_chocolates");
        CustomItem categoryItem = new CustomItem(Material.COOKIE, ChatColor.WHITE + "Dulces de Chocolate");
        Category chocolateCategory = new Category(categoryKey, categoryItem);

        // create the in-game item
        // DCC
        SlimefunItemStack itemStack = new SlimefunItemStack("DARK_CHOC_CARMEL", Material.COOKIE, "Dark Chocolate Caramel", "Bitter chocolate with a", "gooey caramel center.");
        // CCT
        SlimefunItemStack itemStackCCT = new SlimefunItemStack("CHOC_CARROT_TRUFFLE", Material.COOKIE, "Chocolate Carrot Truffle", "Soft chocolate truffle", "flaky carrot center.");

        // a crafting recipe (3x3) DCC
        ItemStack[] recipe = {
                new ItemStack(Material.COCOA_BEANS), new ItemStack(Material.SUGAR), null,
                null, null, null,
                null, null, null
        };
        // a crafting recipe (3x3) CCT
        ItemStack[] recipeCCT = {
          new ItemStack(Material.COCOA_BEANS), new ItemStack(Material.SUGAR), new ItemStack(Material.CARROT),
                null, null, null,
                null, null, null
        };

        // introduce item into game
        DarkChocolateCaramel darkChocolateCaramel = new DarkChocolateCaramel(chocolateCategory, itemStack, RecipeType.ENHANCED_CRAFTING_TABLE, recipe);
        darkChocolateCaramel.register(this);

        // CCT
        ChocolateCarrotTruffle chocolateCarrotTruffle = new ChocolateCarrotTruffle(chocolateCategory, itemStackCCT, RecipeType.ENHANCED_CRAFTING_TABLE, recipeCCT);
        chocolateCarrotTruffle.register(this);

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