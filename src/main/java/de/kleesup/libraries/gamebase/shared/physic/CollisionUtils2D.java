package de.kleesup.libraries.gamebase.shared.physic;

import com.badlogic.gdx.math.Vector2;
import de.kleesup.libraries.gamebase.shared.math.AABB2D;

/**
 * Source taken from <a href="https://github.com/Falconerd/engine-from-scratch/blob/06.1/src/engine/physics/physics.c">...</a>.
 * Remember that the C-code from Falconerd uses AABB.position as the center of the AABB not the bottom left corner!!
 * <br>Created on 12.02.2023</br>
 * @author KleeSup
 * @version 1.0
 * @since 1.1.4
 */
public class CollisionUtils2D {

    public static boolean doesPointIntersectAABB(Vector2 point, AABB2D aabb2D){
        return point.x >= aabb2D.getX() &&
                point.x <= aabb2D.getMaxX() &&
                point.y >= aabb2D.getY() &&
                point.y <= aabb2D.getMaxY();
    }

    public static AABB2D getMinkowskiDifference(AABB2D a, AABB2D b){
        return new AABB2D(
          a.getX() - b.getX(),
          a.getY() - b.getY(),
                a.getMaxX() - b.getMaxX(),
                a.getMaxY() - b.getMaxY()
        );
    }

    public SweptResponse doesRayIntersectAABB(float x, float y, float goalX, float goalY, AABB2D aabb, SweptResponse responseWriteTo){
        Vector2 magnitude = new Vector2(goalX - aabb.getCenterX(), goalY - aabb.getCenterY());
        return doesRayIntersectAABB(x,y,magnitude,aabb,responseWriteTo);
    }
    public SweptResponse doesRayIntersectAABB(float x, float y, float goalX, float goalY, AABB2D aabb){
        return doesRayIntersectAABB(x,y,goalX,goalY,aabb,null);
    }

    public SweptResponse doesRayIntersectAABB(float x, float y, Vector2 magnitude, AABB2D aabb, SweptResponse responseWriteTo){
        SweptResponse response = responseWriteTo != null ? responseWriteTo : new SweptResponse();

        float lastEntry = Float.NEGATIVE_INFINITY;
        float firstExit = Float.POSITIVE_INFINITY;

        if(magnitude.x != 0){
            float t1 = (aabb.getX() - x) / magnitude.x;
            float t2 = (aabb.getMaxX() - x) / magnitude.x;
            lastEntry = Math.max(lastEntry, Math.min(t1, t2));
            firstExit = Math.min(firstExit, Math.max(t1, t2));
        }else if (x <= aabb.getX() || x >= aabb.getMaxX()){
            return response;
        }
        if(magnitude.y != 0){
            float t1 = (aabb.getY() - y) / magnitude.y;
            float t2 = (aabb.getMaxY() - y) / magnitude.y;
            lastEntry = Math.max(lastEntry, Math.min(t1, t2));
            firstExit = Math.min(firstExit, Math.max(t1, t2));
        }else if (y <= aabb.getY() || y >= aabb.getMaxY()){
            return response;
        }

        if(firstExit > lastEntry && firstExit > 0 && lastEntry < 1){
            response.x = x + magnitude.x * lastEntry;
            response.y = y + magnitude.y * lastEntry;

            response.isHit = true;
            response.time = lastEntry;

            float dx = response.x - aabb.getX();
            float dy = response.y - aabb.getY();
            float px = (aabb.getWidth()/2) - Math.abs(dx);
            float py = (aabb.getHeight()/2) - Math.abs(dy);

            if(px < py){
                response.normalX = (dx > 0 ? 1 : 0) - (dx < 0 ? 1 : 0);
            }else{
                response.normalY = (dy > 0 ? 1 : 0) - (dy < 0 ? 1 : 0);
            }
        }
        return response;
    }
    public SweptResponse doesRayIntersectAABB(float x, float y, Vector2 magnitude, AABB2D aabb){
        return doesRayIntersectAABB(x,y,magnitude,aabb,null);
    }


}
