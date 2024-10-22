package com.minje.hypecore.abstract

import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.InventoryHolder

abstract class gui(row: Int, val title: String, val isCancelled: Boolean) : InventoryHolder {

    private var baseInventory: Inventory? = null
    val size: Int = row * 9

    protected abstract fun onCreate(inventory: Inventory)

    open fun onOpen(player: Player) {}

    open fun onClick(event: InventoryClickEvent) {}

    open fun onClose(event: InventoryCloseEvent) {}

    fun open(player: Player) {
        player.openInventory(inventory)
        onOpen(player)
    }
    fun close(player: Player) {
        player.closeInventory()
    }
    override fun getInventory(): Inventory {
        if (baseInventory == null) {
            baseInventory = Bukkit.createInventory(this, size, Component.text(title))
            onCreate(baseInventory!!)
        }
        return baseInventory!!
    }
}