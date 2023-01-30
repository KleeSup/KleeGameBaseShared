package de.kleesup.libraries.gamebase.shared;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * A simple reflection util to access non-accessible fields and methods of classes.
 * <br>Created on 30.01.2023</br>
 * @author KleeSup
 * @version 1.0
 * @since 1.1.3
 */
public class ReflectionUtil {

    /**
     * Tries to access a declared field of a given class.
     * @param clazz The class which contains the declared field.
     * @param fieldName The name of the field.
     * @param instance An instance of the class (can be null for static access).
     * @return The value of the accessed field.
     */
    public static Object getDeclaredFieldValue(Class<?> clazz, String fieldName, Object instance){
        try {
            Field field = clazz.getDeclaredField(fieldName);
            boolean accessible = field.isAccessible();
            if(!accessible)field.setAccessible(true);
            Object obj = field.get(instance);
            if(!accessible)field.setAccessible(false);
            return obj;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Tries to invoke a declared method of a given class.
     * @param clazz The class which contains the declared method.
     * @param methodName The name of the method.
     * @param instance An instance of the class.
     * @param parameters The set of parameters which are required to invoke the method.
     * @return The result of the invocation (what the method itself returns).
     */
    public static Object invokeDeclaredMethod(Class<?> clazz, String methodName, Object instance, Object... parameters){
        try {
            Class<?>[] paramClasses = new Class[parameters.length];
            for(int i = 0; i < paramClasses.length; i++){
                paramClasses[i] = parameters[i].getClass();
            }
            Method method = clazz.getDeclaredMethod(methodName, paramClasses);
            boolean accessible = method.isAccessible();
            if(!accessible)method.setAccessible(true);
            Object result = method.invoke(instance, parameters);
            if(!accessible)method.setAccessible(false);
            return result;
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }



}
