package com.zachdayz.roguehate.file.loader;

import com.zachdayz.roguehate.file.yaml.DefinitionMap;
import com.zachdayz.roguehate.game.zone.Spawn;
import com.zachdayz.roguehate.game.zone.Zone;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.SynchronousAssetLoader;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;

public class ZoneLoader extends SynchronousAssetLoader<Zone, AssetLoaderParameters<Zone>> {
    public ZoneLoader(FileHandleResolver resolver) {
        super(resolver);
    }

    @Override
    public Zone load(AssetManager assetManager, String fileName, FileHandle file, AssetLoaderParameters<Zone> parameter) {
        DefinitionMap yaml = new DefinitionMap.Loader(fileName).load();

        Zone zone = new Zone();

        yaml.getCollection("spawns").forEach(v -> zone.addSpawn(new Spawn((String) v)));

        return zone;
    }

    @Override
    public Array<AssetDescriptor> getDependencies(String fileName, FileHandle file, AssetLoaderParameters<Zone> parameter) {
        return null;
    }
}
