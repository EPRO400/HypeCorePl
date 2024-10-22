package com.minje.hypecore.listener

import com.minje.hypecore.abstract.gui
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent
import org.bukkit.inventory.InventoryView

class GuiListener : Listener {

    @EventHandler
    fun onInventoryClick(event: InventoryClickEvent) {
        val abstractContainer = getAbstractContainer(event.view) ?: return
        event.isCancelled = abstractContainer.isCancelled
        abstractContainer.onClick(event)
    }

    @EventHandler
    fun onInventoryClose(event: InventoryCloseEvent) {
        val abstractContainer = getAbstractContainer(event.view) ?: return
        abstractContainer.onClose(event)
    }

    private fun getAbstractContainer(inventoryView: InventoryView): gui? {
        val inventoryHolder = inventoryView.topInventory.holder ?: return null
        return if (inventoryHolder is gui) {
            inventoryHolder
        } else {
            null
        }
    }
}