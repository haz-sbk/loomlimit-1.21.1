package io.github.hazsbk.loomlimit.mixin;

import io.github.hazsbk.loomlimit.platform.Services;
import net.minecraft.client.gui.screens.inventory.LoomScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(LoomScreen.class)
public class LoomScreenMixin {
    @ModifyConstant(method = "containerChanged", constant = @Constant(intValue = 6))
    private int loomlimit$maxPatterns(int original) {
        return Services.CONFIG.maxPatterns();
    }
}
