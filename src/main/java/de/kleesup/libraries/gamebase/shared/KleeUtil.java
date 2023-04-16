package de.kleesup.libraries.gamebase.shared;

import java.util.Objects;
import java.util.function.Consumer;

/**
 * @author KleeSup
 * @version 1.2
 * Class created on 17.10.2022
 * <p>
 * A simple utility class containing some helpful methods.
 * @since 1.1
 */
public final class KleeUtil {

    /*
    Methods for each numeric type that check if a coordinate is within a 2D-grid.
    */
    public static boolean inBounds(byte x, byte y, byte width, byte height){
        return x >= 0 && x < width && y >= 0 && y < height;
    }
    public static boolean inBounds(short x, short y, short width, short height){
        return x >= 0 && x < width && y >= 0 && y < height;
    }
    public static boolean inBounds(int x, int y, int width, int height){
        return x >= 0 && x < width && y >= 0 && y < height;
    }
    public static boolean inBounds(long x, long y, long width, long height){
        return x >= 0 && x < width && y >= 0 && y < height;
    }
    public static boolean inBounds(float x, float y, float width, float height){
        return x >= 0 && x < width && y >= 0 && y < height;
    }
    public static boolean inBounds(double x, double y, double width, double height){
        return x >= 0 && x < width && y >= 0 && y < height;
    }
    /*
    Methods for each numeric type that check if a coordinate is within a 3D-grid.
    */
    public static boolean inBounds(byte x, byte y, byte z, byte width, byte height, byte length){
        return x >= 0 && x < width && y >= 0 && y < height && z >= 0 && z < length;
    }
    public static boolean inBounds(short x, short y, short z, short width, short height, short length){
        return x >= 0 && x < width && y >= 0 && y < height && z >= 0 && z < length;
    }
    public static boolean inBounds(int x, int y, int z, int width, int height, int length){
        return x >= 0 && x < width && y >= 0 && y < height && z >= 0 && z < length;
    }
    public static boolean inBounds(long x, long y, long z, long width, long height, long length){
        return x >= 0 && x < width && y >= 0 && y < height && z >= 0 && z < length;
    }
    public static boolean inBounds(float x, float y, float z, float width, float height, float length){
        return x >= 0 && x < width && y >= 0 && y < height && z >= 0 && z < length;
    }
    public static boolean inBounds(double x, double y, double z, double width, double height, double length){
        return x >= 0 && x < width && y >= 0 && y < height && z >= 0 && z < length;
    }

    /**
     * Determines if a specific code part is throwing certain exceptions.
     * @param runnable The part of the code to check.
     * @param exceptions The exceptions that might occur.
     * @return {@code true} if any of the given exceptions did occur, {@code false} otherwise.
     */
    @SafeVarargs
    public static boolean isThrowing(Runnable runnable, Class<? extends Exception>... exceptions){
        paramRequireNonNull(runnable, "Runnable cannot be null");
        if(exceptions == null || exceptions.length == 0)return false;
        try {
            runnable.run();
        }catch (Exception e){
            for(Class<? extends Exception> i : exceptions){
                if(e.getClass().equals(i))return true;
            }
        }
        return false;
    }

    /**
     * Determines if a given string is a valid byte.
     * See also: {@link Byte#parseByte(String)}
     * @param str The string to check for.
     * @return {@code true} if the given string is a valid byte, {@code false} otherwise.
     */
    public static boolean isByte(String str){
        if(str == null)return false;
        try {
            Byte.parseByte(str);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    /**
     * Determines if a given string is a valid short.
     * See also: {@link Short#parseShort(String)}
     * @param str The string to check for.
     * @return {@code true} if the given string is a valid short, {@code false} otherwise.
     */
    public static boolean isShort(String str){
        if(str == null)return false;
        try {
            Short.parseShort(str);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    /**
     * Determines if a given string is a valid integer.
     * See also: {@link Integer#parseInt(String)}
     * @param str The string to check for.
     * @return {@code true} if the given string is a valid integer, {@code false} otherwise.
     */
    public static boolean isInt(String str){
        if(str == null)return false;
        try {
            Integer.parseInt(str);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    /**
     * Determines if a given string is a valid long.
     * See also: {@link Long#parseLong(String)}
     * @param str The string to check for.
     * @return {@code true} if the given string is a valid long, {@code false} otherwise.
     */
    public static boolean isLong(String str){
        if(str == null)return false;
        try {
            Long.parseLong(str);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    /**
     * Determines if a given string is a valid float.
     * See also: {@link Float#parseFloat(String)}
     * @param str The string to check for.
     * @return {@code true} if the given string is a valid float, {@code false} otherwise.
     */
    public static boolean isFloat(String str){
        if(str == null)return false;
        try {
            Float.parseFloat(str);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    /**
     * Determines if a given string is a valid double.
     * See also: {@link Double#parseDouble(String)}
     * @param str The string to check for.
     * @return {@code true} if the given string is a valid double, {@code false} otherwise.
     */
    public static boolean isDouble(String str) {
        if (str == null) return false;
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Easy and quick method to determine chances.
     * Range: 1.0 is equal to 100%
     * @param chance The chance that is checked to occur.
     * @return {@code true} when the chance has occurred, {@code false} otherwise.
     */
    public static boolean chanceOf(double chance){
        return Math.random() <= chance;
    }

    /**
     * Determines whether a string is a valid enum (name) of an enum.
     * @param name The name of one of the enums bodies.
     * @param enumClass The class of the enum.
     * @return {@code true} if the given string is a valid body of an enum, {@code false} otherwise.
     */
    public static <T extends Enum<T>> boolean isValidEnum(String name, Class<T> enumClass){
        paramRequireNonNull(enumClass, "Class cannot be null!");
        if(name == null)return false;
        try {
            Enum.valueOf(enumClass, name);
        } catch (IllegalArgumentException e) {
            return false;
        }

        return true;
    }

    /**
     * Checks if a specified object is null. If yes an {@link IllegalArgumentException} is thrown, otherwise the object gets returned.
     * This method differs to {@link Objects#requireNonNull(Object, String)} because it accordingly throws an {@link IllegalArgumentException}
     * instead of an {@link NullPointerException} so its usage is rather made for method parameters and will therefore not return the object.
     * @param obj The object to check for.
     * @param message The message that should be printed with the {@link IllegalArgumentException}.
     * @param <T> The objects custom type.
     * @throws IllegalArgumentException In case the specified object is null.
     */
    public static <T> void paramRequireNonNull(T obj, String message){
        if(obj == null)throw new IllegalArgumentException(message);
    }

    /**
     * Determines whether a cooldown as worn of or not.
     * @param currentTime The current timestamp.
     * @param cooldownStartTime The timestamp the cooldown started.
     * @param cooldownTime The length of the cooldown.
     * @return {@code true} if the cooldown has worn off, {@code false} otherwise.
     */
    public static boolean hasCooldownWornOff(long currentTime, long cooldownStartTime, long cooldownTime){
        return currentTime - cooldownStartTime >= cooldownTime;
    }

    /**
     * Runs a code part for each element of an array.
     * @param array The array to execute for.
     * @param consumer The consumer that accepts the elements of the array.
     */
    public static <T> void arrayForEach(T[] array, Consumer<T> consumer){
        KleeUtil.paramRequireNonNull(array, "Array cannot be null!");
        KleeUtil.paramRequireNonNull(consumer, "Consumer cannot be null!");
        for(T t : array){
            consumer.accept(t);
        }
    }

}
