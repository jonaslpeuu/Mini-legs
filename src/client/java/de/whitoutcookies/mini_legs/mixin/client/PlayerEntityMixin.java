package de.whitoutcookies.mini_legs.mixin.client;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class PlayerEntityMixin {

    private static final float EYE_HEIGHT_SCALE = 0.5f; // 50% eye height

    @Inject(method = "getStandingEyeHeight", at = @At("RETURN"), cancellable = true)
    private void adjustEyeHeight(CallbackInfoReturnable<Float> cir) {
        if ((Object) this instanceof PlayerEntity) {
            float originalHeight = cir.getReturnValue();
            cir.setReturnValue(originalHeight * EYE_HEIGHT_SCALE);
        }
    }
}
