package de.kleesup.libraries.gamebase.shared.grid;

import de.kleesup.libraries.gamebase.shared.KleeUtil;
import de.kleesup.libraries.gamebase.shared.exception.GameException;
import de.kleesup.libraries.gamebase.shared.world.grid.ITileLayer;

/**
 * An interfaces which creates the base for classes that are able to hold {@link ITileLayer} objects.
 * <br>Created on 05.02.2023</br>
 * @author KleeSup
 * @version 1.0
 * @since 1.1.4
 */
public interface TileLayerContainer<T, I> {

    ITileLayer<T, I> getTileLayer(I id);

    boolean hasLayer(I id);

    default T getTile(ITileLayer<T, I> layer, float x, float y){
        KleeUtil.paramRequireNonNull(layer, "Layer cannot be null!");
        return layer.getTile(x,y);
    }

    default T getTile(I layerID, float x, float y){
        KleeUtil.paramRequireNonNull(layerID, "ID of the layer cannot be null!");
        if(!hasLayer(layerID))throw new GameException("There is no layer registered with the ID of "+layerID+"!");
        return getTile(getTileLayer(layerID), x, y);
    }

    default T setTile(ITileLayer<T, I> layer, float x, float y, T tile){
        KleeUtil.paramRequireNonNull(layer, "Layer cannot be null!");
        return layer.setTile(x,y,tile);
    }

    default T setTile(I layerID, float x, float y, T tile){
        KleeUtil.paramRequireNonNull(layerID, "ID of the layer cannot be null!");
        if(!hasLayer(layerID))throw new GameException("There is no layer registered with the ID of "+layerID+"!");
        return setTile(getTileLayer(layerID),x,y,tile);
    }





}
