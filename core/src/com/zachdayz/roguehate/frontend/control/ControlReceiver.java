package com.zachdayz.roguehate.frontend.control;

import com.badlogic.gdx.InputProcessor;

public abstract class ControlReceiver implements InputProcessor {
    @Override
    public final boolean keyDown(int keycode) {
        return onControl(Key.byKeycode(keycode), Key.Event.DOWN);
    }

    @Override
    public final boolean keyUp(int keycode) {
        return onControl(Key.byKeycode(keycode), Key.Event.UP);
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    public abstract boolean onControl(Key key, Key.Event event);
}
