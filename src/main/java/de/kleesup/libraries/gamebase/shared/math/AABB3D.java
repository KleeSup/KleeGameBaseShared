package de.kleesup.libraries.gamebase.shared.math;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 13.10.2022
 *
 * 3D implementation of {@link AABB2D}.
 * @since 1.1
 */
public class AABB3D extends AABB2D {

    private float z;
    private float length;
    public AABB3D(float x, float y, float z, float width, float height, float length) {
        super(x, y, width, height);
        this.z = z;
        this.length = length;
    }

    public float getCenterZ(){
        return z + (length/2f);
    }

    public float getMaxZ(){
        return z + length;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }
}
