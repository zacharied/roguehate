package com.zachdayz.roguehate.frontend.screen;

import com.zachdayz.roguehate.frontend.RoguehateGraphicalSession;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public abstract class Screen {
    private Stage uiStage = new Stage(new ScreenViewport());

    public Screen(RoguehateGraphicalSession session) {
        onCreate();
        onLoad(session.getAssetManager());
    }

    public final void draw() {
        onDraw();
        uiStage.draw();
    }

    protected abstract void onDraw();

    protected void onCreate() { }

    protected void onLoad(AssetManager manager) { }
}
