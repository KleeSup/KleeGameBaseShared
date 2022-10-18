package de.kleesup.libraries.gamebase.shared;

import java.util.Objects;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 17.10.2022
 *
 * A simple utility class containing some helpful methods.
 * @since 1.1
 */
public final class KleeUtil {

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
            e.printStackTrace();
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

}
