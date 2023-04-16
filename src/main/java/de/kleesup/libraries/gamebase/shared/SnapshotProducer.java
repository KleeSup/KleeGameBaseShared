package de.kleesup.libraries.gamebase.shared;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * An interface for classes which require the functionality to create objects from snapshots of the class.
 * Snapshots can be useful if you want to have an object which contains only the most necessary information of an object.
 * The snapshots can be used in several ways and also to load the full object.
 * NOTE: Classes implementing this interface are REQUIRED to have a constructor that accepts the created snapshot type
 * or else {@link SnapshotProducer#fromSnapshot(Class, Object)} will fail!
 * <br>Created on 24.02.2023</br>
 * @author KleeSup
 * @version 1.0
 * @since 1.1.5
 */
public interface SnapshotProducer<T> {

    /**
     * Loads a full object from a given snapshot.
     * NOTE: All classes that implement {@link SnapshotProducer} need to have a default constructor accepting the snapshot received from {@link SnapshotProducer#toSnapshot()}!
     * @param clazz The class of the object to be loaded.
     * @param snapshot The snapshot to load the object from.
     * @return The loaded object which was created with the given snapshot.
     */
    static <S extends SnapshotProducer<?>> S fromSnapshot(Class<S> clazz, Object snapshot){
        KleeUtil.paramRequireNonNull(clazz, "Class to construct instance for cannot be null!");
        KleeUtil.paramRequireNonNull(snapshot, "Snapshot to build instance from cannot be null!");
        try {
            Constructor<S> constructor = clazz.getConstructor(snapshot.getClass());
            return constructor.newInstance(snapshot);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Unable to build "+clazz.getName()+
                    " instance from snapshot, as the class does not have a default constructor accepting the snapshot instance! [new MyClass(myClassSnapshot) not available]", e);
        }
    }

    /**
     * @return A created snapshot of this class containing minimal essential information to load this object.
     *          The snapshot can be used to save this object into files or sent it via packets.
     */
    T toSnapshot();

}
