package com.zachdayz.roguehate.frontend.control;

public interface ActionReceiver {
    boolean onControl(Action action, Key.Event event);
}
