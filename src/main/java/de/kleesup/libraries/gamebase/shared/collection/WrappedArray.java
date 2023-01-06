package de.kleesup.libraries.gamebase.shared.collection;

import de.kleesup.libraries.gamebase.shared.KleeUtil;

import java.lang.reflect.Array;
import java.util.Objects;

/**
 * <br>Created on 06.01.2023</br>
 *
 * @author KleeSup
 * @version 1.0
 */
public class WrappedArray<T> {

    public static final int INDEX_NO_ENTRY_FOUND = -1;

    com.badlogic.gdx.utils.Array

    private T[] elements;

    public WrappedArray(T[] elements){
        KleeUtil.paramRequireNonNull(elements, "Default elements cannot be null!");
        this.elements = elements;
    }

    @SuppressWarnings("unchecked")
    public WrappedArray(Class<T> clazz, int capacity){
        this((T[]) Array.newInstance(clazz,capacity));
    }

    @SuppressWarnings("unchecked")
    public WrappedArray(int capacity){
        this((T[]) new Object[capacity]);
    }

    public T get(int i){
        return elements[i];
    }

    public T set(int i, T value){
        T old = get(i);
        elements[i] = value;
        return old;
    }

    public int firstIndexOf(T obj){
        for(int i = 0; i < length(); i++){
            if(Objects.equals(obj, get(i)))return i;
        }
        return INDEX_NO_ENTRY_FOUND;
    }

    public int lastIndexOf(T obj){
        for(int i = length()-1; i >= 0; i--){
            if(Objects.equals(obj, get(i)))return i;
        }
        return INDEX_NO_ENTRY_FOUND;
    }

    @SuppressWarnings("unchecked")
    public void expand(final int amount){
        T[] copied = (T[]) new Object[length() + amount];
        System.arraycopy(elements, 0, copied, 0, length());
        this.elements = copied;
    }

    public int length(){
        return elements.length;
    }

}
