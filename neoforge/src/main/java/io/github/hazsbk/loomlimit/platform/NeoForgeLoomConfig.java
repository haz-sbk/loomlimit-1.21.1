package io.github.hazsbk.loomlimit.platform;

import io.github.hazsbk.loomlimit.ClientConfig;
import io.github.hazsbk.loomlimit.ServerConfig;
import io.github.hazsbk.loomlimit.platform.services.ILoomConfig;

public class NeoForgeLoomConfig implements ILoomConfig {
    private static final int HARD_MAX = 64;

    @Override
    public int maxPatterns() {
        // Reading a config value before it loads throws, so fall back to the default.
        return ServerConfig.SPEC.isLoaded()
                ? ServerConfig.MAX_PATTERNS.get()
                : ServerConfig.MAX_PATTERNS.getDefault();
    }

    @Override
    public int renderLimit() {
        if (!ClientConfig.SPEC.isLoaded()) {
            return HARD_MAX;
        }
        return switch (ClientConfig.CONFIG.renderMode.get()) {
            case MAX -> HARD_MAX;
            case LIMIT -> maxPatterns();
            case CUSTOM -> ClientConfig.CONFIG.customRenderLimit.get();
        };
    }
}
