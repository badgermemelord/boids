package dev.doublekekse.boids.util;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.phys.Vec3;

public class utilMethods {
    public static void addDeltaMovement(Mob mob, Vec3 addend) {
        mob.setDeltaMovement(mob.getDeltaMovement().add(addend));
    }
}
