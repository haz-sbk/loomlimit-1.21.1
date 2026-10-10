package io.github.hazsbk.loomlimit;

import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public final class ClientConfig {

    public enum RenderMode {
        MAX,     // always draw up to the hard ceiling (64)
        LIMIT,   // follow the server's max_patterns
        CUSTOM   // use custom_render_limit
    }

    public final ModConfigSpec.EnumValue<RenderMode> renderMode;
    public final ModConfigSpec.IntValue customRenderLimit;

    private ClientConfig(ModConfigSpec.Builder builder) {
        renderMode = builder
                .comment("How many banner layers to draw.\n",
                        "MAX = draw everything up to 64\n",
                        "LIMIT = follow the server's max_patterns\n",
                        "CUSTOM = use custom_render_limit")
                .translation("loomlimit.configuration.render_mode")
                .defineEnum("render_mode", RenderMode.MAX);

        customRenderLimit = builder
                .comment("Only used when render_mode is CUSTOM.")
                .translation("loomlimit.configuration.custom_render_limit")
                .defineInRange("custom_render_limit", 32, 6, 64);
    }

    public static final ClientConfig CONFIG;
    public static final ModConfigSpec SPEC;

    static {
        Pair<ClientConfig, ModConfigSpec> pair =
                new ModConfigSpec.Builder().configure(ClientConfig::new);
        CONFIG = pair.getLeft();
        SPEC = pair.getRight();
    }
}