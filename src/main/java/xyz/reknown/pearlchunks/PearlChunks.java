package xyz.reknown.pearlchunks;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.entity.EnderPearl;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.reknown.pearlchunks.listeners.EntitySpawnListener;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CompletableFuture;

public class PearlChunks extends JavaPlugin {
    private Map<EnderPearl, Set<ChunkCoords>> pearls; // should hold Locations instead of Chunks to prevent hard references

    @Override
    public void onEnable() {
        this.pearls = new WeakHashMap<>();

        Bukkit.getScheduler().runTaskTimer(this, () -> {
            Iterator<Map.Entry<EnderPearl, Set<ChunkCoords>>> iter = pearls.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<EnderPearl, Set<ChunkCoords>> entry = iter.next();
                EnderPearl pearl = entry.getKey();
                Set<ChunkCoords> coordsList = entry.getValue();

                if (pearl.isDead()) {
                    coordsList.forEach(coords -> {
                        pearl.getWorld().removePluginChunkTicket(coords.x(), coords.z(), this);
                    });

                    iter.remove();
                } else {
                    Location location = pearl.getLocation();
                    int chunkX = (int) Math.floor(location.getX() / 16);
                    int chunkZ = (int) Math.floor(location.getZ() / 16);

                    ChunkCoords coords = new ChunkCoords(chunkX, chunkZ);
                    if (!coordsList.add(coords)) return;

                    CompletableFuture<Chunk> future = pearl.getWorld().getChunkAtAsyncUrgently(chunkX, chunkZ);
                    future.thenAccept(chunk -> chunk.addPluginChunkTicket(this));
                }
            }
        }, 1L, 1L);

        getServer().getPluginManager().registerEvents(new EntitySpawnListener(), this);
    }

    public Map<EnderPearl, Set<ChunkCoords>> pearls() {
        return this.pearls;
    }
}
