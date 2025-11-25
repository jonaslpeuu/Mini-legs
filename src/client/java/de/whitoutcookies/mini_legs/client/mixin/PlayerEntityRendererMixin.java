package de.whitoutcookies.mini_legs.client.mixin;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntityRenderer.class)
public class PlayerEntityRendererMixin {
    @Inject(method = "scale", at = @At("TAIL"))
    private void scale(AbstractClientPlayerEntity abstractClientPlayerEntity, MatrixStack matrixStack, float f,
            CallbackInfo ci) {
        matrixStack.scale(0.5F, 0.5F, 0.5F);
    }
}
