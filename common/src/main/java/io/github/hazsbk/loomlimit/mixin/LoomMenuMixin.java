package io.github.hazsbk.loomlimit.mixin;

import io.github.hazsbk.loomlimit.platform.Services;
import net.minecraft.world.inventory.LoomMenu;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(LoomMenu.class)
public class LoomMenuMixin {
    @ModifyConstant(method = "slotsChanged", constant = @Constant(intValue = 6))
    private int loomlimit$maxPatterns(int original) {
        return Services.CONFIG.maxPatterns();
    }
}
