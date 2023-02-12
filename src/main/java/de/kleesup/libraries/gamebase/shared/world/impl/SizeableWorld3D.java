package de.kleesup.libraries.gamebase.shared.world.impl;

import de.kleesup.libraries.gamebase.shared.world.ISizedWorld3D;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 08.10.2022
 *
 * A simple implementation of {@link ISizedWorld3D} which takes in the final world sizes by its constructor.
 * @since 1.0
 */
public abstract class SizeableWorld3D implements ISizedWorld3D {

    private final float minWorldX, minWorldY, minWorldZ, maxWorldX, maxWorldY, maxWorldZ;
    public SizeableWorld3D(float minWorldX, float minWorldY, float minWorldZ, float maxWorldX, float maxWorldY, float maxWorldZ) {
        this.minWorldX = minWorldX;
        this.minWorldY = minWorldY;
        this.minWorldZ = minWorldZ;
        this.maxWorldX = maxWorldX;
        this.maxWorldY = maxWorldY;
        this.maxWorldZ = maxWorldZ;
    }

    @Override
    public float getMaxWorldX() {
        return maxWorldX;
    }

    @Override
    public float getMaxWorldY() {
        return maxWorldY;
    }

    @Override
    public float getMinWorldX() {
        return minWorldX;
    }

    @Override
    public float getMinWorldY() {
        return minWorldY;
    }

    @Override
    public float getMinWorldZ() {
        return minWorldZ;
    }

    @Override
    public float getMaxWorldZ() {
        return maxWorldZ;
    }
}
