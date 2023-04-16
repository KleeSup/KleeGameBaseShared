package de.kleesup.libraries.gamebase.shared.physic;

/**
 * A response which is returned when a swept-AABB collision was tested.
 * <br>Created on 12.02.2023</br>
 * @author KleeSup
 * @version 1.0
 * @since 1.1.4
 */
public class SweptResponse {

    /** The hit time which is calculated by swept collision detection. **/
    public float time;

    /** The side of the AABB that has been hit. **/
    public float normalX, normalY;

    /** Whether a collision was detected or not. **/
    public boolean isHit = false;

    /** The position where the collision occurred. **/
    public float x, y;

    /**
     * Clears all last written data to this response.
     * This method should be called before reusing this response object.
     */
    public void clear(){
        time = 0;
        normalX = 0;
        normalY = 0;
        isHit = false;
        x = 0;
        y = 0;
    }

}
