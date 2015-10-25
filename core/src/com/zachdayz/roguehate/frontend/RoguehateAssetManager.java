package com.zachdayz.roguehate.frontend;

import com.zachdayz.roguehate.file.loader.CharacterLoader;
import com.zachdayz.roguehate.file.loader.ZoneLoader;
import com.zachdayz.roguehate.frontend.image.SpriteSheet;
import com.zachdayz.roguehate.frontend.image.loader.SpriteSheetLoader;
import com.zachdayz.roguehate.game.character.Character;
import com.zachdayz.roguehate.game.zone.Zone;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;

public class RoguehateAssetManager extends AssetManager {
    public RoguehateAssetManager() {
        super();

        FileHandleResolver customClassResolver = new InternalFileHandleResolver();
        setLoader(Character.class, new CharacterLoader(customClassResolver));
        setLoader(SpriteSheet.class, new SpriteSheetLoader(customClassResolver));
        setLoader(Zone.class, new ZoneLoader(customClassResolver));
    }
}
