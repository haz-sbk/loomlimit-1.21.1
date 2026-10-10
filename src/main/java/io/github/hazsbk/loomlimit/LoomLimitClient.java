package io.github.hazsbk.loomlimit;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = LoomLimit.MODID, dist = Dist.CLIENT)
public class LoomLimitClient {

    private static final int HARD_MAX = 64;

    public LoomLimitClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
        container.registerConfig(ModConfig.Type.CLIENT, ClientConfig.SPEC);
    }

    public static int resolveRenderLimit() {
        if (!ClientConfig.SPEC.isLoaded()) {
            return HARD_MAX; // safe fallback
        }
        return switch (ClientConfig.CONFIG.renderMode.get()) {
            case MAX -> HARD_MAX;
            case LIMIT -> LoomLimit.maxPatterns();
            case CUSTOM -> ClientConfig.CONFIG.customRenderLimit.get();
        };
    }
}