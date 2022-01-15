package com.github.siroio.commandlog.clogger.Events.Inventory;

import com.github.siroio.commandlog.clogger.Inventory.GUI;
import com.github.siroio.commandlog.clogger.Inventory.InvGUIs.testGUI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class InventoryClickEvents implements Listener {

    HashMap<String, GUI> guimap = new HashMap<>();

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if(!(e.getClickedInventory() == null)) return;
        if(!(e.getClickedInventory().getHolder() instanceof GUI)) return;
        e.setCancelled(true);
        Player player = (Player) e.getWhoClicked();
        ItemStack itemStack = e.getCurrentItem();
        onClickedItem(player, itemStack);
    }

    public void onClickedItem(Player player, ItemStack itemStack) {
        if(player == null) return;
        if(itemStack == null) return;

    }
}
