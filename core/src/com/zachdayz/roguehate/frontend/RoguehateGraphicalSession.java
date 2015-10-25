package com.zachdayz.roguehate.frontend;

import java.util.Map;

import com.zachdayz.roguehate.file.loader.CharacterLoader;
import com.zachdayz.roguehate.file.yaml.DefinitionMap;
import com.zachdayz.roguehate.frontend.control.Controller;
import com.zachdayz.roguehate.frontend.image.SpriteSheet;
import com.zachdayz.roguehate.frontend.screen.Screen;
import com.zachdayz.roguehate.frontend.screen.zone.ZoneScreen;
import com.zachdayz.roguehate.game.character.Character;
import com.zachdayz.roguehate.game.zone.ZoneInstance;
import com.zachdayz.roguehate.log.GameLog;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;

/**
 * Represents an instance of the game running graphically.
 */
public class RoguehateGraphicalSession extends ApplicationAdapter {
    private AssetManager assetManager = new RoguehateAssetManager();

    private DefinitionMap graphicsConfig = new DefinitionMap.Loader("config/graphics.yaml").load();
    private DefinitionMap controlsConfig = new DefinitionMap.Loader("config/controls.yaml").load();

    private Screen currentScreen;

    private Controller mainController;

    @Override
    public void create() {
        GameLog.initializeForDesktop();

        assetManager.load(CharacterLoader.getPathFromId("test"), Character.class);
        assetManager.load("assets/graphics/character/test/walk.spritesheet.yaml", SpriteSheet.class);
        assetManager.finishLoading();

        mainController = new Controller(controlsConfig, "default");

        Gdx.input.setInputProcessor(mainController);

        currentScreen = new ZoneScreen(this, new ZoneInstance());
    }

    @Override
    public void render() {
        Map<String, Double> clearColors = (Map<String, Double>) graphicsConfig.getMap("clearColor");

        Gdx.gl.glClearColor((float) clearColors.get("red").doubleValue(),
                (float) clearColors.get("blue").doubleValue(),
                (float) clearColors.get("green").doubleValue(),
                (float) clearColors.get("alpha").doubleValue()
        );

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        currentScreen.draw();
    }

    public AssetManager getAssetManager() {
        return assetManager;
    }

    public Controller getMainController() {
        return mainController;
    }
}
