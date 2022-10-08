package de.kleesup.libraries.gamebase.shared.world.impl;

import de.kleesup.libraries.gamebase.shared.world.ISizeableWorld2D;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 08.10.2022
 *
 * A simple implementation of {@link ISizeableWorld2D} which takes in the final world sizes by its constructor.
 * @since 1.0
 */
public class SizeableWorld2D implements ISizeableWorld2D {

    private final float minX, minY, maxX, maxY;
    public SizeableWorld2D(float minWorldX, float minWorldY, float maxWorldX, float maxWorldY) {
        this.minX = minWorldX;
        this.minY = minWorldY;
        this.maxX = maxWorldX;
        this.maxY = maxWorldY;
    }

    @Override
    public float getMaxWorldX() {
        return maxX;
    }

    @Override
    public float getMaxWorldY() {
        return maxY;
    }

    @Override
    public float getMinWorldX() {
        return minX;
    }

    @Override
    public float getMinWorldY() {
        return minY;
    }
}
