package de.kleesup.libraries.gamebase.shared.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import de.kleesup.libraries.gamebase.shared.world.Direction;

/**
 * <br>Created on 03.02.2023</br>
 *
 * @author KleeSup
 * @version 1.0
 * @since 1.1.4
 */
public interface Controller {

    static Controller buildGdxMouseButtonController(int button, boolean onlyJustPressed){
        if(onlyJustPressed){
            return direction -> Gdx.input.isButtonJustPressed(button) ? 1 : 0;
        }else{
            return direction -> Gdx.input.isButtonPressed(button) ? 1 : 0;
        }
    }

    static Controller buildGdxKeyboardKeyController(int key, boolean onlyJustPressed){
        if(onlyJustPressed){
            return direction -> Gdx.input.isKeyJustPressed(key) ? 1 : 0;
        }else{
            return direction -> Gdx.input.isKeyPressed(key) ? 1 : 0;
        }
    }

    float NO_MOVEMENT = 0;

    float checkController(Direction direction);

}
