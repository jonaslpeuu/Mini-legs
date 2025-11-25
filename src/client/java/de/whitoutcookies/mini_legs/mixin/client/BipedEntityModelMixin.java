package de.whitoutcookies.mini_legs.mixin.client;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BipedEntityModel.class)
public abstract class BipedEntityModelMixin<T extends LivingEntity> {

    @Shadow
    public ModelPart leftLeg;

    @Shadow
    public ModelPart rightLeg;

    private static final float LEG_SCALE = 0.5f; // Scale legs to 50% size

    @Inject(method = "setAngles", at = @At("RETURN"))
    private void onSetAngles(CallbackInfo ci) {
        // Scale the legs down after all other animations are applied
        if (leftLeg != null) {
            leftLeg.xScale = LEG_SCALE;
            leftLeg.yScale = LEG_SCALE;
            leftLeg.zScale = LEG_SCALE;
        }

        if (rightLeg != null) {
            rightLeg.xScale = LEG_SCALE;
            rightLeg.yScale = LEG_SCALE;
            rightLeg.zScale = LEG_SCALE;
        }
    }
}
