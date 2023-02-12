package de.kleesup.libraries.gamebase.shared.math;

import com.badlogic.gdx.math.Rectangle;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 13.10.2022
 *
 * Class for storing a 2D axis aligned bounding box (rectangle).
 * These bounding boxes can only be moved on their axis and not rotated or whatsoever.
 * @since 1.1
 */
public class AABB2D {

    private float x, y, width, height;
    public AABB2D(float x, float y, float width, float height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public AABB2D copy(){
        return new AABB2D(x,y,width,height);
    }

    /*
    Determine if other AABB is overlapped/contained.
    */

    public boolean contains (AABB2D other) {
        float xmin = other.x;
        float xmax = xmin + other.width;

        float ymin = other.y;
        float ymax = ymin + other.height;

        return ((xmin > x && xmin < x + width) && (xmax > x && xmax < x + width))
                && ((ymin > y && ymin < y + height) && (ymax > y && ymax < y + height));
    }

    public boolean overlaps (AABB2D other) {
        return x < other.x + other.width && x + width > other.x && y < other.y + other.height && y + height > other.y;
    }

    /*
    Setter
    */

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    /*
    Getter
    */

    public float getCenterX(){
        return x + (width/2f);
    }

    public float getCenterY(){
        return y + (height/2f);
    }

    public float getMaxX(){
        return x + width;
    }

    public float getMaxY(){
        return y + height;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
}
