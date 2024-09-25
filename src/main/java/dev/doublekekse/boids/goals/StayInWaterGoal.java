package dev.doublekekse.boids.goals;

import dev.doublekekse.boids.util.utilMethods;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.phys.Vec3;

public class StayInWaterGoal extends Goal {
    private final Mob mob;

    public StayInWaterGoal(Mob mob) {
        this.mob = mob;
    }

    @Override
    public boolean canUse() {
        return true;
    }

    @Override
    public void tick() {
        var blockPos = mob.blockPosition();
        var blockAbove = mob.getLevel().getBlockState(blockPos.above(2));
        var blockBelow = mob.getLevel().getBlockState(blockPos.below(1));
        var amount = amount();

        if(blockAbove.getFluidState().isEmpty()) {
            utilMethods.addDeltaMovement(mob, new Vec3(0, -amount, 0));
        }

        if(blockBelow.getFluidState().isEmpty()) {
            utilMethods.addDeltaMovement(mob, new Vec3(0, amount, 0));
        }
    }

    float amount() {
        var amount = 0.1f;
        var dY = Mth.abs((float) mob.getDeltaMovement().y);

        if (dY > amount) {
            amount = dY;
        }

        return amount;
    }
}
