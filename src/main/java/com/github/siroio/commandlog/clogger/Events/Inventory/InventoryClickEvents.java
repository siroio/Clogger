package com.github.siroio.commandlog.clogger.Events.Inventory;

import com.github.siroio.commandlog.clogger.Inventory.GUI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.ItemStack;

public class InventoryClickEvents implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if(e.getClickedInventory() == null) return;
        if(!(e.getClickedInventory().getHolder() instanceof GUI)) return;
        e.setCancelled(true);
        if(e.isLeftClick()) {
            Player player = (Player) e.getWhoClicked();
            ItemStack itemStack = e.getCurrentItem();
            onClickedItem(player, itemStack);
        }
    }

    public void onClickedItem(Player player, ItemStack itemStack) {
        if(player == null) return;
        if(itemStack == null) return;

        if(itemStack.getType() == Material.BOOK)
            player.closeInventory();
    }

    @EventHandler
    public void onDrag(InventoryDragEvent e) {
        if(!(e.getInventory().getHolder() instanceof GUI)) return;
        e.setCancelled(true);
    }
}
