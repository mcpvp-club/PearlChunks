package xyz.reknown.pearlchunks;

import java.util.Objects;

public record ChunkCoords(int x, int z) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChunkCoords)) return false;

        return this.x == ((ChunkCoords) o).x && this.z == ((ChunkCoords) o).z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.z);
    }
}
