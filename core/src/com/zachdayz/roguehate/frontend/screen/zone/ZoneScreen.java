package com.zachdayz.roguehate.frontend.screen.zone;

import com.zachdayz.roguehate.file.loader.CharacterLoader;
import com.zachdayz.roguehate.frontend.RoguehateGraphicalSession;
import com.zachdayz.roguehate.frontend.image.SpriteSheet;
import com.zachdayz.roguehate.frontend.screen.Screen;
import com.zachdayz.roguehate.game.character.CharacterInstance;
import com.zachdayz.roguehate.game.zone.ZoneActor;
import com.zachdayz.roguehate.game.zone.ZoneInstance;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class ZoneScreen extends Screen {
    private ZoneInstance zone;

    private Stage zoneStage;

    private ZoneScreenActor mainActor;

    public ZoneScreen(RoguehateGraphicalSession session, ZoneInstance zone) {
        super(session);
        this.zone = zone;
        session.getMainController().addReceiver(mainActor);
    }

    @Override
    protected void onDraw() {
        zoneStage.draw();
    }

    @Override
    protected void onCreate() {
        super.onCreate();
        zoneStage = new Stage(new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
    }

    @Override
    protected void onLoad(AssetManager manager) {
        super.onLoad(manager);

        ZoneScreenActor actor = new ZoneScreenActor(new ZoneActor(new CharacterInstance(manager.get(CharacterLoader.getPathFromId("test")))));
        actor.setTexture(manager.get("assets/graphics/character/test/walk.spritesheet.yaml", SpriteSheet.class));
        zoneStage.addActor(actor);
        mainActor = actor;
    }
}
