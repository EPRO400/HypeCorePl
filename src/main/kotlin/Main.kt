package com.minje.hypecore

import com.minje.hypecore.listener.GuiListener
import com.minje.hypecore.listener.JQListener
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    override fun onEnable() {
        plugin = this
        server.pluginManager.registerEvents(GuiListener(), this)
        server.pluginManager.registerEvents(JQListener(), this)
    }

    companion object {
        lateinit var plugin: Main
            private set
    }
}