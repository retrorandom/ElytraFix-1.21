package lol.retrorandom.elytrafix.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {
// this probably does not work.
    @Inject(method = "tick", at = @At("TAIL"))
    private void modifyElytraDescent(CallbackInfo ci) {
        if (((PlayerEntity) (Object) this).isFallFlying()) {
            PlayerEntity player = (PlayerEntity) (Object) this;
            Vec3d vel = player.getVelocity();
            player.setVelocity(vel.x, -0.08, vel.z);
        }
    }
}
