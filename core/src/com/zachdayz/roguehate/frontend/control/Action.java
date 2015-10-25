package com.zachdayz.roguehate.frontend.control;

import com.zachdayz.roguehate.game.zone.Direction;

public enum Action {
    MOVE_UP("up", Direction.UP),
    MOVE_DOWN("down", Direction.DOWN),
    MOVE_RIGHT("right", Direction.RIGHT),
    MOVE_LEFT("left", Direction.LEFT);

    private String configName;
    private Direction direction;

    Action(String configName) {
        this.configName = configName;
    }

    Action(String configName, Direction direction) {
        this.configName = configName;
        if (direction != null) {
            this.direction = direction;
        }
    }

    public String getConfigName() {
        return configName;
    }

    public Direction getDirection() {
        return direction;
    }
}
