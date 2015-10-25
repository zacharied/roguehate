package com.zachdayz.roguehate.frontend.control;

import com.badlogic.gdx.Input;

/**
 * A key able to be mapped to an input which will be sent to a {@link ActionReceiver}.
 */
public enum Key {
    W(Input.Keys.W),
    A(Input.Keys.A),
    S(Input.Keys.S),
    D(Input.Keys.D);

    private int key;

    Key(int key) {
        this.key = key;
    }

    /**
     * Gets the appropriate {@code Key} value for the {@code int}-based keycode sent.
     * @see com.badlogic.gdx.Input.Keys
     * @param keycode The keycode of the key that was pressed.
     */
    public static Key byKeycode(int keycode) {
        for (Key key : values()) {
            if (key.key == keycode) {
                return key;
            }
        }

        return null;
    }

    public enum Event {
        UP,
        DOWN;
    }
}
