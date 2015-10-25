package com.zachdayz.roguehate.game.zone;

import com.zachdayz.roguehate.game.character.CharacterInstance;

/**
 * A character currently present in a zone.
 */
public class ZoneActor {
    private CharacterInstance characterInstance;

    private int x, y;
    private Direction direction = Direction.DOWN;

    public ZoneActor(CharacterInstance characterInstance) {
        this.characterInstance = characterInstance;
    }

    public CharacterInstance getCharacterInstance() {
        return characterInstance;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
