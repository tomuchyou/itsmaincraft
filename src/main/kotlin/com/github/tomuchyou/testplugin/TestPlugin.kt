package com.github.tomuchyou.testplugin

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.DyeColor
import org.bukkit.Material
import org.bukkit.entity.EntityType
import org.bukkit.entity.Sheep
import org.bukkit.entity.Zombie
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.java.JavaPlugin

class TestPlugin : JavaPlugin(), Listener {
    override fun onEnable() {
        println("Плагин запущен")
        server.pluginManager.registerEvents(this, this)
    }

    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        val textComponent = Component.text("Привет", NamedTextColor.GREEN)
        event.player.sendMessage(textComponent)
    }
    @EventHandler
    fun onJoin(event: BlockBreakEvent) {
        val entity= event.player.world.spawnEntity(event.block.location.toCenterLocation(),EntityType.SHEEP)

        entity as Sheep
        entity.color = DyeColor.PURPLE
    }
    @EventHandler
    fun onnJoin(event: BlockBreakEvent) {
        val entity= event.player.world.spawnEntity(event.block.location.toCenterLocation(),EntityType.ZOMBIE)

        entity as Zombie
        entity.equipment.boots= ItemStack(Material.NETHERITE_BOOTS)
        entity.equipment.chestplate= ItemStack(Material.NETHERITE_CHESTPLATE)
        entity.equipment.leggings=ItemStack(Material.NETHERITE_LEGGINGS)
        entity.equipment.helmet=ItemStack(Material.NETHERITE_HELMET)


    }
}