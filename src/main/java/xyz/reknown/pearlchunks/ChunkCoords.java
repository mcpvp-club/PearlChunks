/*
 * Copyright (C) 2024 Jyguy
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */

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
