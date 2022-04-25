package com.github.siroio.commandlog.clogger.Inventory.impl;

import com.github.siroio.commandlog.clogger.Inventory.GUI;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class testGUI extends GUI {

    public testGUI() {
        InventoryTitle = "testGUI クリックで閉じる";
        InventorySize = 9;
        initInventory();
        initGUI();
    }

    @Override
    protected void initGUI() {
        //Center
        ItemStack item;
        item = createItem(Material.BOOK, "§b§lTestDisplayItemName" ,"TestItemLore");
        inventory.setItem(4, item);
    }
}
