package com.zachdayz.roguehate.frontend.screen.zone;

import java.util.Stack;

import com.zachdayz.roguehate.frontend.control.Action;
import com.zachdayz.roguehate.frontend.control.ActionReceiver;
import com.zachdayz.roguehate.frontend.control.Key;
import com.zachdayz.roguehate.frontend.image.SpriteSheet;
import com.zachdayz.roguehate.game.zone.Direction;
import com.zachdayz.roguehate.game.zone.ZoneActor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * A graphical representation of a {@link ZoneActor}.
 */
public class ZoneScreenActor extends Actor implements ActionReceiver {
    private static final float MOVESPEED = 5;

    private ZoneActor zoneActor;

    private ZoneScreenActorSpriteSet spriteSet;

    private Stack<Direction> movementKeys = new Stack<>();

    float stateTime = 0;

    public ZoneScreenActor(ZoneActor zoneActor) {
        this.zoneActor = zoneActor;
        updatePosition();
    }

    public void setTexture(SpriteSheet spriteSheet) {
        spriteSet = new ZoneScreenActorSpriteSet(spriteSheet);
        setSize(spriteSet.getWidth(), spriteSet.getHeight());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        stateTime += Gdx.graphics.getDeltaTime();

        batch.draw(spriteSet.getKeyFrame(zoneActor.getDirection(), stateTime), getX(), getY());

        if (!movementKeys.isEmpty()) {
            zoneActor.setX(zoneActor.getX() + (int) (movementKeys.peek().getX() * MOVESPEED));
            zoneActor.setY(zoneActor.getY() + (int) (movementKeys.peek().getY() * MOVESPEED));
        }

        updatePosition();
    }

    @Override
    public boolean onControl(Action action, Key.Event event) {

        // Movement is handled separately from all other actions due to the way in which the user can hold down multiple movement keys.
        if (action.getDirection() != null) {
            if (event == Key.Event.DOWN) {
                movementKeys.push(action.getDirection());
            } else {
                movementKeys.remove(action.getDirection());
            }

            if (!movementKeys.isEmpty()) {
                zoneActor.setDirection(movementKeys.peek());
            }

            return true;
        }

        // Handle other actions...

        return false;
    }

    private void updatePosition() {
        setPosition(zoneActor.getX(), zoneActor.getY());
    }
}
