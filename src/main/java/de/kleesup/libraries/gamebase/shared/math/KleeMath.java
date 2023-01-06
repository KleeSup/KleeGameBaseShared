package de.kleesup.libraries.gamebase.shared.math;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 17.10.2022
 *
 * A class that contains some simple mathematical functions.
 * @since 1.1
 */
public final class KleeMath {

    /**
     * Checks the given value and retrieves it when it is between its max and min bounds. Otherwise, those boundaries are returned.
     * @param min The min value.
     * @param value The value to clamp.
     * @param max The max value.
     * @return The value if it lies in between of max and min.
     *          If it is smaller than min, min gets returned.
     *          If it is bigger than max, max gets returned.
     */
    public static byte clamp(byte min, byte value, byte max){
        return value < min ? min : value > max ? max : value;
    }

    /**
     * Checks the given value and retrieves it when it is between its max and min bounds. Otherwise, those boundaries are returned.
     * @param min The min value.
     * @param value The value to clamp.
     * @param max The max value.
     * @return The value if it lies in between of max and min.
     *          If it is smaller than min, min gets returned.
     *          If it is bigger than max, max gets returned.
     */
    public static short clamp(short min, short value, short max){
        return value < min ? min : value > max ? max : value;
    }

    /**
     * Checks the given value and retrieves it when it is between its max and min bounds. Otherwise, those boundaries are returned.
     * @param min The min value.
     * @param value The value to clamp.
     * @param max The max value.
     * @return The value if it lies in between of max and min.
     *          If it is smaller than min, min gets returned.
     *          If it is bigger than max, max gets returned.
     */
    public static int clamp(int min, int value, int max){
        return value < min ? min : value > max ? max : value;
    }

    /**
     * Checks the given value and retrieves it when it is between its max and min bounds. Otherwise, those boundaries are returned.
     * @param min The min value.
     * @param value The value to clamp.
     * @param max The max value.
     * @return The value if it lies in between of max and min.
     *          If it is smaller than min, min gets returned.
     *          If it is bigger than max, max gets returned.
     */
    public static long clamp(long min, long value, long max){
        return value < min ? min : value > max ? max : value;
    }

    /**
     * Checks the given value and retrieves it when it is between its max and min bounds. Otherwise, those boundaries are returned.
     * @param min The min value.
     * @param value The value to clamp.
     * @param max The max value.
     * @return The value if it lies in between of max and min.
     *          If it is smaller than min, min gets returned.
     *          If it is bigger than max, max gets returned.
     */
    public static float clamp(float min, float value, float max){
        return value < min ? min : value > max ? max : value;
    }

    /**
     * Checks the given value and retrieves it when it is between its max and min bounds. Otherwise, those boundaries are returned.
     * @param min The min value.
     * @param value The value to clamp.
     * @param max The max value.
     * @return The value if it lies in between of max and min.
     *          If it is smaller than min, min gets returned.
     *          If it is bigger than max, max gets returned.
     */
    public static double clamp(double min, double value, double max){
        return value < min ? min : value > max ? max : value;
    }



}
