# Loom Limit

Raises the banner pattern limit on the loom. Vanilla caps banners at 6 pattern layers. With Loom Limit you can go up to 64 (default: 16).

## Features

- Configurable maximum number of pattern layers per banner (6 to 64)
- Works in the loom GUI: the pattern picker and result preview stay available past 6 layers
- In-game config screen (Mods → Loom Limit → Config)

## Requirements

- Minecraft [1.21.x]
- NeoForge [version]
- **Install on both client and server.** The server decides what the loom can produce, and the client decides what the loom screen shows. A client without the mod is still capped at 6 in the UI.

## Configuration

The config file is `config/loomlimit-server.toml`. It's a server config, so its value is synced to clients when they join a world or server.

| Option         | Default | Range | Description                                  |
| -------------- | ------- | ----- | -------------------------------------------- |
| `max_patterns` | 16      | 6-64  | Maximum pattern layers a banner can have     |

## Known limitations

- Banners with many layers cost more to render, on the ground, in item frames, in your hand, and on shields. Keep the limit reasonable on low-end machines or busy servers.
- If you lower `max_patterns` after making banners above the new limit, those banners are still valid items, but you can't add more layers to them.

## Building

```
./gradlew build
```

The jar is written to `build/libs/`.

## License

MIT License. See [LICENSE](LICENSE.txt).