package com.zachdayz.roguehate.frontend.screen.zone;

import java.util.EnumMap;

import com.zachdayz.roguehate.frontend.image.SpriteSheet;
import com.zachdayz.roguehate.game.zone.Direction;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ZoneScreenActorSpriteSet {
    private static final float ANIMATION_TIME = 0.1f;

    private EnumMap<Direction, Animation> moveAnimations = new EnumMap<>(Direction.class);

    public ZoneScreenActorSpriteSet(SpriteSheet spriteSheet) {
        moveAnimations.put(Direction.UP, spriteSheet.getGroup("up").toAnimation(ANIMATION_TIME));
        moveAnimations.put(Direction.DOWN, spriteSheet.getGroup("down").toAnimation(ANIMATION_TIME));
        moveAnimations.put(Direction.RIGHT, spriteSheet.getGroup("right").toAnimation(ANIMATION_TIME));
        moveAnimations.put(Direction.LEFT, spriteSheet.getGroup("left").toAnimation(ANIMATION_TIME));
    }

    public TextureRegion getKeyFrame(Direction direction, float stateTime) {
        return moveAnimations.get(direction).getKeyFrame(stateTime, true);
    }

    public float getWidth() {
        return moveAnimations.get(Direction.UP).getKeyFrames()[0].getRegionWidth();
    }

    public float getHeight() {
        return moveAnimations.get(Direction.UP).getKeyFrames()[0].getRegionHeight();
    }
}
