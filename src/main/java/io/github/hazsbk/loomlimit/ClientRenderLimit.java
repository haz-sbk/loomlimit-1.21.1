package io.github.hazsbk.loomlimit;

public final class ClientRenderLimit {

    public static final int HARD_MAX = 64;

    private ClientRenderLimit() {}

    public static int get() {
        if (!ClientConfig.SPEC.isLoaded()) {
            return HARD_MAX;
        }

        return switch (ClientConfig.CONFIG.renderMode.get()) {
            case MAX -> HARD_MAX;
            case LIMIT -> LoomLimit.maxPatterns();
            case CUSTOM -> ClientConfig.CONFIG.customRenderLimit.get();
        };
    }
}