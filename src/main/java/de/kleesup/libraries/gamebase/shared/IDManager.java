package de.kleesup.libraries.gamebase.shared;

import java.util.UUID;

public interface IDManager {

    default UUID generateNew(Object o){
        UUID id;
        do{
            id = UUID.randomUUID();
        }while (isTaken(id));
        return id;
    }

    boolean isTaken(UUID id);



}
