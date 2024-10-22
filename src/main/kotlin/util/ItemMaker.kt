package com.minje.hypecore.util

import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

fun ItemMaker(
    material: Material,
    displayName: String = "",
    lore: List<String> = emptyList(),
    customModelData: Int = 0,
    replace: (String) -> String = { it }
): ItemStack {
    return ItemStack(material).apply {
        itemMeta = itemMeta?.apply {
            if (displayName.isNotEmpty()) {
                this.displayName(Component.text(replace(displayName)))
            }
            if (lore.isNotEmpty()) {
                this.lore(lore.map { Component.text(replace(it)) })
            }
            if (customModelData != 0) {
                setCustomModelData(customModelData)
            }
        }
    }
}