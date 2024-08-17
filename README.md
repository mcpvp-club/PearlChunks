# PearlChunks
When ender pearls travel to unloaded chunks in Minecraft, they stop and never land until the chunk is loaded by a player.
This Paper plugin loads the chunks that ender pearls are in when they are in unloaded chunks to prevent this issue.

**You MUST set `fixes.disable-unloaded-chunk-enderpearl-exploit` to `false` in your Paper world configuration for this to work.**

This plugin supports 1.19.3 - 1.21.1.
The server must be running [Paper](https://papermc.io/) or a compatible fork.

## Building
`./gradlew build`
The output file will be located in `./build/libs`.
