package de.whitoutcookies.mini_legs.client.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class PlayerEntityMixin {
    @Inject(method = "getEyeHeight", at = @At("RETURN"), cancellable = true)
    private void getEyeHeight(EntityPose pose, EntityDimensions dimensions, CallbackInfoReturnable<Float> cir) {
        if ((Object) this instanceof PlayerEntity) {
            cir.setReturnValue(cir.getReturnValue() * 0.5F);
        }
    }
}
