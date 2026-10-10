package io.github.hazsbk.loomlimit;

import net.neoforged.fml.config.ModConfig;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(LoomLimit.MODID)
public class LoomLimit {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "loomlimit";

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public LoomLimit(IEventBus modEventBus, ModContainer modContainer) {
        modContainer.registerConfig(ModConfig.Type.SERVER, ServerConfig.SPEC);
    }

    public static int maxPatterns() {
        // Reading a config value before it loads throws, so fall back to the default.
        return ServerConfig.SPEC.isLoaded() ? ServerConfig.MAX_PATTERNS.get() : ServerConfig.MAX_PATTERNS.getDefault();
    }
}
