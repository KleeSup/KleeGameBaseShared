package de.kleesup.libraries.gamebase.shared.math;

/**
 * <br>Created on 16.04.2023</br>
 *
 * @author KleeSup
 * @version 1.0
 * @since 1.1.5
 */
public class AABB3D implements StrucAABB<AABB3D> {

    private float x, y ,z;
    private float width, height, depth;
    public AABB3D(float x, float y, float z, float width, float height, float depth) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.width = width;
        this.height = height;
        this.depth = depth;
    }
    public AABB3D(AABB3D aabb){
        this.x = aabb.x;
        this.y = aabb.y;
        this.z = aabb.z;
        this.width = aabb.width;
        this.height = aabb.height;
        this.depth = aabb.depth;
    }
    public AABB3D(){
        this(0,0,0,0,0,0);
    }

    @Override
    public AABB3D setX(float x) {
        this.x = x;
        return this;
    }

    @Override
    public AABB3D setY(float y) {
        this.y = y;
        return this;
    }

    public AABB3D setZ(float z){
        this.z = z;
        return this;
    }

    @Override
    public AABB3D setWidth(float width) {
        this.width = width;
        return this;
    }

    @Override
    public AABB3D setHeight(float height) {
        this.height = height;
        return this;
    }

    public AABB3D setDepth(float depth){
        this.depth = depth;
        return this;
    }

    @Override
    public AABB3D setZero() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.width = 0;
        this.height = 0;
        this.depth = 0;
        return this;
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    public float getDepth() {
        return depth;
    }

    @Override
    public float getWidth() {
        return width;
    }

    @Override
    public float getHeight() {
        return height;
    }
}
