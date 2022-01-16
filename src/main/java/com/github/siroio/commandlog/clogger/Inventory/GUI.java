package com.github.siroio.commandlog.clogger.Inventory;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.Objects;

public abstract class GUI implements InventoryHolder {
    protected Inventory inventory;
    protected String InventoryTitle = "";
    protected int InventorySize = 0;

    protected void initInventory() {
        inventory = Bukkit.createInventory(this, InventorySize, InventoryTitle);
    }

    protected abstract void initGUI();

    protected ItemStack createItem(Material item, String name, String... lore) {
        // make item data
        ItemStack itemStack = new ItemStack(item, 1);
        ItemMeta meta = itemStack.getItemMeta();

        // set data
        Objects.requireNonNull(meta).setDisplayName(name);
        meta.setLore(Arrays.asList(lore));
        itemStack.setItemMeta(meta);

        return itemStack;
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }
}
