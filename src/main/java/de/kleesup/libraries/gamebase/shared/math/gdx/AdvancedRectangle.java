package de.kleesup.libraries.gamebase.shared.math.gdx;

import com.badlogic.gdx.math.Rectangle;

/**
 * <br>Created on 01.03.2023</br>
 *
 * @author KleeSup
 * @version 1.0
 * @since 1.1.5
 */
public class AdvancedRectangle extends Rectangle  {

    public AdvancedRectangle() {
    }

    public AdvancedRectangle(float x, float y, float width, float height) {
        super(x, y, width, height);
    }

    public AdvancedRectangle(Rectangle rect) {
        super(rect);
    }

    /**
     * Copies this rectangle into a new rectangle object.
     * @return The copied rectangle.
     */
    public AdvancedRectangle copy(){
        return new AdvancedRectangle(x,y,width,height);
    }

    /*
    Non-object required geometrical test
    */
    public boolean contains (float circleX, float circleY, float radius) {
        return (circleX - radius >= x) && (circleX + radius <= x + width) && (circleY - radius >= y)
                && (circleY + radius <= y + height);
    }

    public boolean contains (float rectX, float rectY, float rectWidth, float rectHeight) {
        float xmin = rectX;
        float xmax = xmin + rectWidth;

        float ymin = rectY;
        float ymax = ymin + rectHeight;

        return ((xmin > x && xmin < x + width) && (xmax > x && xmax < x + width))
                && ((ymin > y && ymin < y + height) && (ymax > y && ymax < y + height));
    }

    public boolean overlaps(float rectX, float rectY, float rectWidth, float rectHeight){
        return x < rectX + rectWidth && x + width > rectX && y < rectY + rectHeight && y + height > rectY;
    }

    /*
    Getters
    */
    public float getCenterX(){
        return getX() + (getWidth()/2f);
    }
    public float getCenterY(){
        return getY() + (getHeight()/2f);
    }
    public float getMaxX(){
        return getX() + getWidth();
    }
    public float getMaxY(){
        return getY() + getHeight();
    }

}
