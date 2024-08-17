package xyz.reknown.pearlchunks.listeners;

import org.bukkit.entity.EnderPearl;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.reknown.pearlchunks.PearlChunks;

import java.util.HashSet;

public class EntitySpawnListener implements Listener {
    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent event) {
        if (!(event.getEntity() instanceof EnderPearl pearl)) return;

        PearlChunks plugin = JavaPlugin.getPlugin(PearlChunks.class);
        plugin.pearls().put(pearl, new HashSet<>());
        // do not add current chunk since we want to add a ticket in the task
    }
}
