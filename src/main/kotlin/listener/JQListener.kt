package com.minje.hypecore.listener

import com.minje.hypecore.Main
import net.kyori.adventure.text.Component
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

class JQListener : Listener {

    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        event.joinMessage(Component.empty())
        val p = event.player
        val count = Main.plugin.server.onlinePlayers.size
        for (player in Main.plugin.server.onlinePlayers) {
            player.sendActionBar(Component.text("§a[+] §f${p.name} 님이 접속하셨습니다. §7( ${count}명 )"))
        }
    }
    @EventHandler
    fun onQuit(event: PlayerQuitEvent) {
        event.quitMessage(Component.empty())
    }
}