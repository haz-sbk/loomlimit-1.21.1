# Loom Limit

Raises the banner pattern limit on the loom. Vanilla caps banners at 6 pattern layers. With Loom Limit you can go up to 64 (default: 16), and choose how many layers your client actually draws.

<!-- Add a screenshot of a banner with many layers in the loom here, e.g. ![Loom with 20+ layers](docs/loom.png) -->

## Features

- **Configurable layer limit** from 6 to 64 (default 16), enforced by the loom on the server side
- **Loom screen follows the limit**: the pattern picker and result preview stay available past 6 layers
- **Client render option**: draw every layer up to 64, follow the server's limit, or set your own cap. Handy if lots of layers hurt your FPS.
- **In-game config screen**

## Supported versions

| Loader   | Minecraft |
| -------- | --------- |
| NeoForge | 1.21.1    |
| Fabric   | ~~1.21.1~~  soon implemented  |

Fabric needs [Fabric API](https://modrinth.com/mod/fabric-api).

## Installation

1. Download the jar for your loader from [Modrinth](#) / [CurseForge](#) / the [Releases](../../releases) page.
2. Put it in your `mods` folder.

**Install on both the client and the server.** The server decides what the loom can produce, and the client decides what the loom screen shows. A client without the mod is still capped at 6 layers in the UI.

## Configuration

### Server config: `config/loomlimit-server.toml`

Synced from the server to connected clients. You can override it per world with `saves/<world>/serverconfig/loomlimit-server.toml` (on a dedicated server: `<server folder>/world/serverconfig/`).

| Option         | Default | Range | Description                                  |
| -------------- | ------- | ----- | -------------------------------------------- |
| `max_patterns` | 16      | 6-64  | Maximum pattern layers a banner can have     |

Banners that already have more layers than the current limit keep them, but you can't add more.

### Client config: `config/loomlimit-client.toml`

Local to each player. It only affects how many layers are **drawn**, not what the loom allows.

| Option                | Default | Range | Description                                                  |
| --------------------- | ------- | ----- | ------------------------------------------------------------ |
| `render_mode`         | `MAX`   | -     | `MAX` draws every layer up to 64, `LIMIT` follows the server's `max_patterns`, `CUSTOM` uses `custom_render_limit` |
| `custom_render_limit` | 32      | 6-64  | Only used when `render_mode` is `CUSTOM`                     |

## Building

Requires Java 21.

```
./gradlew build
```

The jars are written to:

```
neoforge/build/libs/loomlimit-neoforge-<minecraft version>-<mod version>.jar
fabric/build/libs/loomlimit-fabric-<minecraft version>-<mod version>.jar
```

Upload the jar without a `-sources` or `-javadoc` suffix.

### Project layout

The project is based on the [MultiLoader Template](https://github.com/jaredlll08/MultiLoader-Template).

```
common/     Mixins and loader-independent code (vanilla only)
neoforge/   NeoForge entry point and metadata
fabric/     Fabric entry point and metadata
```

The mixins in `common` ask for the limits through a small service interface (`ILoomConfig`), and each loader provides its own implementation.

## Contributing

Bug reports and pull requests are welcome. Please include your Minecraft version, loader version and the log (`logs/latest.log`) when reporting a problem.

## License

[MIT](LICENSE) © haz-sbk
