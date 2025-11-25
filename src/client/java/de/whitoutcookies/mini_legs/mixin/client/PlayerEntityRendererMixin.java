package de.whitoutcookies.mini_legs.mixin.client;

import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.command.OrderedRenderCommandQueue; // Assuming this exists based on error
import net.minecraft.client.render.state.CameraRenderState; // Assuming this exists based on error
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntityRenderer.class)
public abstract class PlayerEntityRendererMixin {

    private static final float BODY_OFFSET = 0.25f;

    @Inject(method = "render", at = @At("HEAD"))
    private void adjustBodyPosition(LivingEntityRenderState state, MatrixStack matrixStack,
            OrderedRenderCommandQueue commandQueue, CameraRenderState cameraState,
            CallbackInfo ci) {
        // Check if this renderer is a PlayerEntityRenderer
        if ((Object) this instanceof PlayerEntityRenderer) {
            matrixStack.translate(0.0, -BODY_OFFSET, 0.0);
        }
    }
}
