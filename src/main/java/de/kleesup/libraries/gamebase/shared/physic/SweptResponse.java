package de.kleesup.libraries.gamebase.shared.physic;

/**
 *
 * <br>Created on 12.02.2023</br>
 * @author KleeSup
 * @version 1.0
 * @since 1.1.4
 */
public class SweptResponse {

    /** The hit time which is calculated by swept-AABB collision detection. **/
    public float time;

    /** The side of the AABB that has been hit. **/
    public float normalX, normalY;

    /** Whether a AABB was hit or not. **/
    public boolean isHit = false;

    /** The position the AABB was hit at. **/
    public float x, y;

}
