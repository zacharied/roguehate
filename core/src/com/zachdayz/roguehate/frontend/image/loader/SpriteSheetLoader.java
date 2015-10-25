package com.zachdayz.roguehate.frontend.image.loader;

import java.util.Map;

import com.zachdayz.roguehate.file.yaml.DefinitionMap;
import com.zachdayz.roguehate.frontend.image.SpriteSheet;
import com.zachdayz.roguehate.log.GameLog;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import org.apache.commons.lang3.StringUtils;

public class SpriteSheetLoader extends AsynchronousAssetLoader<SpriteSheet, AssetLoaderParameters<SpriteSheet>> {
    private SpriteSheet spriteSheet = new SpriteSheet();

    private AssetDescriptor<Texture> textureFile;

    public SpriteSheetLoader(FileHandleResolver resolver) {
        super(resolver);
    }

    @Override
    public void loadAsync(AssetManager manager, String fileName, FileHandle file, AssetLoaderParameters<SpriteSheet> parameter) {
        DefinitionMap map = new DefinitionMap.Loader(fileName).load();

        try {
            map.getMap().forEach((k, v) -> {
                spriteSheet.addGroup(k, new SpriteGroupFactoryLoader(new DefinitionMap((Map) v)).load().toSpriteGroup(manager.get(textureFile)));
            });
        } catch (ClassCastException e) {
            e.printStackTrace();
        }

        GameLog.i("Loader", "Spritesheet \"" + file.parent().name() + "/" + StringUtils.substringBeforeLast(file.name(), ".spritesheet.yaml") + "\" loaded.");
    }

    @Override
    public SpriteSheet loadSync(AssetManager manager, String fileName, FileHandle file, AssetLoaderParameters<SpriteSheet> parameter) {
        return spriteSheet;
    }

    @Override
    public Array<AssetDescriptor> getDependencies(String fileName, FileHandle file, AssetLoaderParameters<SpriteSheet> parameter) {
        Array<AssetDescriptor> array = new Array<>();
        textureFile = new AssetDescriptor<>(new FileHandle(StringUtils.substringBeforeLast(file.path(), ".spritesheet.yaml") + ".png"), Texture.class);
        array.add(textureFile);

        return array;
    }
}
