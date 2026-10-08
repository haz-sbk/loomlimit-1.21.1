package io.github.hazsbk.loomlimit;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.IntValue MAX_PATTERNS = BUILDER
            .comment("Maximum number of pattern layers a banner can have (vanilla is 6).")
            .translation("loomlimit.configuration.max_patterns")
            .defineInRange("max_patterns", 16, 6, 64);

    public static final ModConfigSpec SPEC = BUILDER.build();

    private Config() {}
}
