package io.github.hazsbk.loomlimit.mixin;

import io.github.hazsbk.loomlimit.platform.Services;
import net.minecraft.client.renderer.blockentity.BannerRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(BannerRenderer.class)
public class BannerRendererMixin {

    @ModifyConstant(
            method = "renderPatterns(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;IILnet/minecraft/client/model/geom/ModelPart;Lnet/minecraft/client/resources/model/Material;ZLnet/minecraft/world/item/DyeColor;Lnet/minecraft/world/level/block/entity/BannerPatternLayers;Z)V",
            constant = @Constant(intValue = 16))
    private static int loomlimit$maxRenderedPatterns(int original) {
        return Services.CONFIG.renderLimit();
    }
}