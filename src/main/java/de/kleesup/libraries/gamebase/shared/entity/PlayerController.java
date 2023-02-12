package de.kleesup.libraries.gamebase.shared.entity;

import de.kleesup.libraries.gamebase.shared.KleeUtil;
import de.kleesup.libraries.gamebase.shared.world.Direction;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * <br>Created on 03.02.2023</br>
 *
 * @author KleeSup
 * @version 1.0
 * @since 1.1.4
 */
public class PlayerController {


    private final Map<Direction, Controller> controls;
    private final Map<Direction, Consumer<Float>> inputProcessors;
    public PlayerController(Map<Direction, Controller> controls, Map<Direction, Consumer<Float>> inputProcessors){
        KleeUtil.paramRequireNonNull(controls, "Controls cannot be null!");
        this.controls = controls;
        this.inputProcessors = inputProcessors;
    }

    public PlayerController(){
        this(new HashMap<>(), new HashMap<>());
    }

    public void registerDirectionControl(Direction direction, Controller controller){
        KleeUtil.paramRequireNonNull(direction, "Direction cannot be null!");
        KleeUtil.paramRequireNonNull(controller, "Controller cannot be null!");
        controls.put(direction, controller);
    }

    public void registerInputProcessor(Direction direction, Consumer<Float> processor){
        KleeUtil.paramRequireNonNull(direction, "Direction cannot be null!");
        KleeUtil.paramRequireNonNull(processor, "Processor cannot be null!");
        inputProcessors.put(direction, processor);
    }

    public void process(Direction direction){
        float value = getCurrentControllerValue(direction);
    }

    public float getCurrentControllerValue(Direction direction){
        KleeUtil.paramRequireNonNull(direction, "Direction cannot be null!");
        Controller controller = controls.get(direction);
        if(controller == null)return Controller.NO_MOVEMENT;
        return controller.checkController(direction);
    }

    public boolean hasControllerValue(Direction direction){
        return getCurrentControllerValue(direction) != Controller.NO_MOVEMENT;
    }

    public float applyControllerValue(Direction direction, float movementSpeed){
        return getCurrentControllerValue(direction) * movementSpeed;
    }

    public interface DirectionController{



        float getCurrentControllerValue(Direction direction);

        float getVelocityAcceleration();

    }


}
