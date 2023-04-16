package de.kleesup.libraries.gamebase.shared.math;

/**
 * A basic construct of what an AABB (here just 2D) could look like.
 * <br>Created on 16.04.2023</br>
 * @author KleeSup
 * @version 1.0
 * @since 1.1.5
 */
public interface StrucAABB<T extends StrucAABB<T>> {

    T setX(float x);
    T setY(float y);
    T setWidth(float width);
    T setHeight(float height);

    T setZero();

    default float getCenterX(){
        return getX() + (getWidth()/2f);
    }
    default float getCenterY(){
        return getY() + (getHeight()/2f);
    }
    default float getMaxX(){
        return getX() + getWidth();
    }

    default float getMaxY(){
        return getY() + getHeight();
    }


    float getX();
    float getY();
    float getWidth();
    float getHeight();


}
