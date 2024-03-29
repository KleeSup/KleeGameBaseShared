package de.kleesup.libraries.gamebase.shared.physic;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import de.kleesup.libraries.gamebase.shared.KleeUtil;
import de.kleesup.libraries.gamebase.shared.math.gdx.AABB2D;

/**
 * Source taken from <a href="https://github.com/Falconerd/engine-from-scratch/blob/06.1/src/engine/physics/physics.c">engine from scratch</a>.
 * Note for authors: Remember that the C-code from Falconerd uses AABB.position as the center of the AABB not the bottom left corner!!
 * <br>Created on 12.02.2023</br>
 * @author KleeSup
 * @version 1.3
 * @since 1.1.4
 */
public class CollisionUtils2D {

    /**
     * Checks if a point intersects an AABB.
     * @param pointX The x-coordinate of the point.
     * @param pointY The x-coordinate of the point.
     * @param aabb The AABB which might contain the point.
     * @return {@code true} if the AABB contains the given point, {@code false} otherwise.
     */
    public static boolean doesPointIntersectAABB(float pointX, float pointY, AABB2D aabb){
        return pointX >= aabb.getX() &&
                pointX <= aabb.getMaxX() &&
                pointY >= aabb.getY() &&
                pointY <= aabb.getMaxY();
    }

    /**
     * Checks if a point intersects an AABB.
     * @param point The point which might be contained in the AABB.
     * @param aabb The AABB which might contain the point.
     * @return {@code true} if the AABB contains the given point, {@code false} otherwise.
     */
    public static boolean doesPointIntersectAABB(Vector2 point, AABB2D aabb){
        return doesPointIntersectAABB(point.x, point.y, aabb);
    }

    /**
     * Checks if a circle is contained in an AABB.
     * @param circleX The x-coordinate of the circle.
     * @param circleY The y-coordinate of the circle.
     * @param radius The radius of the circle.
     * @param aabb The AABB to check for.
     * @return {@code true} if the circle is contained in the AABB, {@code false} otherwise.
     */
    public static boolean doesAABBContainCircle(float circleX, float circleY, float radius, AABB2D aabb){
        return (circleX - radius >= aabb.getX()) && (circleX + radius <= aabb.getX() + aabb.getWidth()) && (circleY - radius >= aabb.getY())
                && (circleY + radius <= aabb.getY() + aabb.getHeight());
    }

    /**
     * Checks if a circle is contained in an AABB.
     * @param circle The circle which might be contained in the AABB.
     * @param aabb The AABB to check for.
     * @return {@code true} if the circle is contained in the AABB, {@code false} otherwise.
     */
    public static boolean doesAABBContainCircle(Circle circle, AABB2D aabb){
        return doesAABBContainCircle(circle.x, circle.y, circle.radius, aabb);
    }

    /**
     * Checks if an AABB contains another AABB.
     * @param aabb The AABB which might contain another AABB.
     * @param other The AABB that might be contained in the first AABB.
     * @return {@code true} if the other AABB is contained in the first AABB, {@code false} otherwise.
     */
    public static boolean doesAABBContainAABB(AABB2D aabb, AABB2D other){
        return ((other.getX() > aabb.getX() && other.getX() < aabb.getX() + aabb.getWidth()) &&
                (other.getMaxX() > aabb.getX() && other.getMaxX() < aabb.getX() + aabb.getWidth()))
                && ((other.getY() > aabb.getY() && other.getY() < aabb.getX() + aabb.getHeight()) &&
                (other.getMaxY() > aabb.getX() && other.getMaxY() < aabb.getX() + aabb.getHeight()));
    }

    /**
     * Checks if an AABB overlaps another AABB.
     * @param aabb The AABB that might overlap another AABB.
     * @param other The AABB that might be overlapped by the first AABB.
     * @return {@code true} if the first AABB overlaps the other AABB, {@code false} otherwise.
     */
    public static boolean doesAABBOverlapAABB(AABB2D aabb, AABB2D other){
        return aabb.getX() < other.getX() + other.getWidth() && aabb.getX() + aabb.getWidth() > other.getX() &&
                aabb.getY() < other.getY() + other.getHeight() && aabb.getY() + aabb.getHeight() > other.getY();
    }

    /**
     * Returns the minkowski difference based on two AABBs.
     * @param a The first AABB.
     * @param b The second AABB.
     * @return An AABB that represents the minkowski difference.
     */
    public static AABB2D getMinkowskiDifference(AABB2D a, AABB2D b){
        return new AABB2D(
          a.getX() - b.getX(),
          a.getY() - b.getY(),
                a.getMaxX() - b.getMaxX(),
                a.getMaxY() - b.getMaxY()
        );
    }

    /**
     * Calculates the magnitude between two points.
     * @param x The x-coordinate of the start-position.
     * @param y The y-coordinate of the start-position.
     * @param goalX The x-coordinate of the goal-position.
     * @param goalY The y-coordinate of the goal-position.
     * @param vecWriteTo A temp response object where the outcome can be written into (Useful when less object creation is desired).
     * @return The calculated magnitude between the two points.
     */
    public static Vector2 calculateMagnitude(float x, float y, float goalX, float goalY, Vector2 vecWriteTo){
        return (vecWriteTo != null ? vecWriteTo : new Vector2()).set(goalX,goalY).sub(x,y);
    }
    public static Vector2 calculateMagnitude(float x, float y, float goalX, float goalY){
        return calculateMagnitude(x,y,goalX,goalY,null);
    }

    /*
    Swept - AABB vs AABB
     */

    /**
     * This method checks for collisions DIRECTLY between two AABBs.
     * NOTE: this method does not solve the tunneling problem, so it will not detect certain collisions.
     * If this is an issue, use {@link #sweptAABBvsAABB(AABB2D, AABB2D, float, float, AABB2D)})}.
     * @param aabb The first AABB (this could be the one moving into the other).
     * @param other The other AABB (could be the one which the first one moves into).
     * @param goalX The x-coordinate of the goal position where the first AABB is supposed to be.
     * @param goalY The y-coordinate of the goal position where the first AABB is supposed to be.
     * @param responseWriteTo A temp response object where the outcome can be written into (Useful when less object creation is desired).
     * @return The result of the AABB collision test.
     */
    public static SweptResponse quickAABBvsAABB(AABB2D aabb, AABB2D other, float goalX, float goalY, SweptResponse responseWriteTo, boolean useTempVec){
        KleeUtil.paramRequireNonNull(aabb, "First AABB cannot be null!");
        KleeUtil.paramRequireNonNull(other, "Second AABB cannot be null!");
        return doesRayIntersectAABB(aabb.getCenterX(), aabb.getCenterY(), goalX, goalY, other, responseWriteTo, useTempVec);
    }
    public static SweptResponse quickAABBvsAABB(AABB2D aabb, AABB2D other, float goalX, float goalY, boolean useTempVec){
        return quickAABBvsAABB(aabb,other,goalX,goalY,null,useTempVec);
    }
    public static SweptResponse quickAABBvsAABB(AABB2D aabb, AABB2D other, float goalX, float goalY){
        return quickAABBvsAABB(aabb,other,goalX,goalY,null,false);
    }

    /**
     * Does a quick collision test between two AABBs. However, this method expects that the first AABB has already been moved.
     * @param aabb The first AABB (this could be the one moving into the other).
     * @param other The other AABB (could be the one which the first one moves into).
     * @return The result of the collision test.
     */
    public static SweptResponse quickAABBvsAABB(AABB2D aabb, AABB2D other){
        return quickAABBvsAABB(aabb,other,aabb.getCenterX(),aabb.getCenterY());
    }

    /**
     * Does a swept collision test between two AABBs.
     * NOTE: The way how the math behind all this fixes the tunneling problem is by creating a summed AABB (centering the <b>other</b> one and adding both sizes).
     * Therefore, the returned x and y values of the {@link SweptResponse} do no longer represent the hit position at the original <b>other</b> AABB
     * but the hit position of the <b>aabb</b> at the <b>sumWriteTo</b>.
     * Keep this in mind when doing collision resolution (See {@link #sweptAABBvsAABBResolution(AABB2D, SweptResponse)}).
     * @param aabb The first AABB (this could be the one moving into the other).
     * @param other The other AABB (could be the one which the first one moves into).
     * @param goalX The x-coordinate of the goal position where the first AABB is supposed to be.
     * @param goalY The y-coordinate of the goal position where the first AABB is supposed to be.
     * @param sumWriteTo A temp AABB object where the sum between the first and the second can be written into (Useful when less object creation is desired).
     * @param responseWriteTo A temp response object where the outcome can be written into (Useful when less object creation is desired).
     * @param useTempVec Determines whether a temp {@link Vector2} object is supposed to be used
     *                   (Useful when less object creation is desired but also disables multithreading for this method at the same time).
     * @return The result of the swept collision test.
     */
    public static SweptResponse sweptAABBvsAABB(AABB2D aabb, AABB2D other, float goalX, float goalY, AABB2D sumWriteTo, SweptResponse responseWriteTo, boolean useTempVec){
        KleeUtil.paramRequireNonNull(aabb, "First AABB cannot be null!");
        KleeUtil.paramRequireNonNull(other, "Second AABB cannot be null!");
        if(sumWriteTo == null)sumWriteTo = new AABB2D();
        //calculating the sum of both AABBs by adding their width and height together.
        float width = aabb.getWidth() + other.getWidth();
        float height = aabb.getHeight() + other.getHeight();
        sumWriteTo.setSize(width, height);
        sumWriteTo.setCenter(other.getX(), other.getY());
        return doesRayIntersectAABB(aabb.getCenterX(), aabb.getCenterY(), goalX, goalY, sumWriteTo, responseWriteTo, useTempVec);
    }
    public static SweptResponse sweptAABBvsAABB(AABB2D aabb, AABB2D other, float goalX, float goalY, AABB2D sumWriteTo, SweptResponse responseWriteTo){
        return sweptAABBvsAABB(aabb,other,goalX,goalY,sumWriteTo,responseWriteTo,false);
    }
    public static SweptResponse sweptAABBvsAABB(AABB2D aabb, AABB2D other, float goalX, float goalY, AABB2D sumWriteTo){
        return sweptAABBvsAABB(aabb, other, goalX, goalY, sumWriteTo, null);
    }
    public static SweptResponse sweptAABBvsAABB(AABB2D aabb, AABB2D other, float goalX, float goalY){
        return sweptAABBvsAABB(aabb,other,goalX,goalY,null);
    }

    /**
     * Does a swept collision test between two AABBs. However, this method expects that the first AABB has already been moved.
     * NOTE: Since the AABB has already been moved, the swept test isn't really necessary so rather use {@link #quickAABBvsAABB(AABB2D, AABB2D)}.
     * @param aabb The first AABB (this could be the one moving into the other).
     * @param other The other AABB (could be the one which the first one moves into).
     * @return The result of the swept collision test.
     */
    public static SweptResponse sweptAABBvsAABB(AABB2D aabb, AABB2D other){
        return sweptAABBvsAABB(aabb,other,aabb.getCenterX(),aabb.getCenterY());
    }

    /*
    Swept - Ray vs AABB
    */

    private static final Vector2 tempMag = new Vector2();

    /**
     * Does a swept collision test between a ray and an AABB.
     * @param x The x-coordinate of the ray (starting) position.
     * @param y The y-coordinate of the ray (starting) position.
     * @param goalX The x-coordinate of the goal position where the ray is supposed to end.
     * @param goalY The y-coordinate of the goal position where the ray is supposed to end.
     * @param aabb The AABB to test against.
     * @param responseWriteTo A temp response object where the outcome can be written into (Useful when less object creation is desired).
     * @param useTempVec Determines whether a temp {@link Vector2} object is supposed to be used
     *                   (Useful when less object creation is desired but also disables multithreading for this method at the same time).
     * @return The result of the swept collision test.
     */
    public static SweptResponse doesRayIntersectAABB(float x, float y, float goalX, float goalY, AABB2D aabb, SweptResponse responseWriteTo, boolean useTempVec){
        Vector2 magnitude = useTempVec ? tempMag : new Vector2();
        calculateMagnitude(x,y,goalX,goalY,magnitude);
        return doesRayIntersectAABB(x,y,magnitude,aabb,responseWriteTo);
    }
    public static SweptResponse doesRayIntersectAABB(float x, float y, float goalX, float goalY, AABB2D aabb, SweptResponse responseWriteTo){
        return doesRayIntersectAABB(x,y,goalX,goalY,aabb,responseWriteTo,false);
    }
    public static SweptResponse doesRayIntersectAABB(float x, float y, float goalX, float goalY, AABB2D aabb){
        return doesRayIntersectAABB(x,y,goalX,goalY,aabb,null);
    }

    /**
     * Does a swept collision test between a ray and an AABB.
     * @param x The x-coordinate of the ray (starting) position.
     * @param y The y-coordinate of the ray (starting) position.
     * @param magnitude The magnitude (direction) of the ray.
     * @param aabb The AABB to test against.
     * @param responseWriteTo A temp response object where the outcome can be written into (Useful when less object creation is desired).
     * @return The result of the swept collision test.
     */
    public static SweptResponse doesRayIntersectAABB(float x, float y, Vector2 magnitude, AABB2D aabb, SweptResponse responseWriteTo){
        KleeUtil.paramRequireNonNull(magnitude, "Magnitude cannot be null!");
        KleeUtil.paramRequireNonNull(aabb, "AABB cannot be null!");
        SweptResponse response = responseWriteTo != null ? responseWriteTo : new SweptResponse();

        float lastEntry = Float.NEGATIVE_INFINITY;
        float firstExit = Float.POSITIVE_INFINITY;

        //magnitude should not be zero to avoid dividing by zero
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

        //condition for a collision
        if(firstExit > lastEntry && firstExit > 0 && lastEntry < 1){
            response.x = x + magnitude.x * lastEntry;
            response.y = y + magnitude.y * lastEntry;

            response.isHit = true;
            response.time = lastEntry;

            //calculating hit normal
            float dx = response.x - aabb.getCenterX();
            float dy = response.y - aabb.getCenterY();
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
    public static SweptResponse doesRayIntersectAABB(float x, float y, Vector2 magnitude, AABB2D aabb){
        return doesRayIntersectAABB(x,y,magnitude,aabb,null);
    }

    /*
    Resolution
    */

    /**
     * Calculates a goal-AABB which represents the original AABB moved away from the AABB it collided with.
     * NOTE: This method expects that the response was created between the two AABBs directly and no summed AABB
     * (like in {@link #sweptAABBvsAABB(AABB2D, AABB2D, float, float, AABB2D)}) is involved.
     * @param aabb The aabb which was tested for collision with another one.
     * @param response The response that was returned by that test.
     * @param goalWriteTo The goal-AABB to write to (Useful when less object creation is desired).
     * @return The goal-AABB representing the moved  <b>aabb</b> to no longer collide.
     */
    public static AABB2D quickAABBvsAABBResolution(AABB2D aabb, SweptResponse response, AABB2D goalWriteTo){
        goalWriteTo.setSize(aabb.getWidth(), aabb.getHeight());

        //response
        float halfWidth = aabb.getWidth()/2f;
        float halfHeight = aabb.getHeight()/2f;

        float moveOutX = halfWidth * response.normalX;
        float moveOutY = halfHeight * response.normalY;

        goalWriteTo.setCenter(response.x + moveOutX, response.y + moveOutY);
        return goalWriteTo;
    }
    public static AABB2D quickAABBvsAABBResolution(AABB2D aabb, SweptResponse response){
        return quickAABBvsAABBResolution(aabb, response, new AABB2D());
    }

    /**
     * Calculates a goal-AABB which represents the original AABB moved away from the AABB it collided with.
     * NOTE: This method expects that the response was created by a swept test that utilises a summed AABB of both sizes to
     * fix the tunneling problem.
     * @param aabb The aabb which was tested for collision with another one.
     * @param response The response that was returned by that test.
     * @param goalWriteTo The goal-AABB to write to (Useful when less object creation is desired).
     * @return The goal-AABB representing the moved <b>aabb</b> to no longer collide.
     */
    public static AABB2D sweptAABBvsAABBResolution(AABB2D aabb, SweptResponse response, AABB2D goalWriteTo){
        goalWriteTo.setSize(aabb.getWidth(), aabb.getHeight());
        goalWriteTo.setCenter(response.x, response.y); //response-x and y are no longer the
        return goalWriteTo;
    }
    public static AABB2D sweptAABBvsAABBResolution(AABB2D aabb, SweptResponse response){
        return sweptAABBvsAABBResolution(aabb,response,new AABB2D());
    }

}
