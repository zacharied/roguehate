package com.zachdayz.roguehate.file.loader;

import com.zachdayz.roguehate.file.yaml.DefinitionMap;
import com.zachdayz.roguehate.game.character.Character;
import com.zachdayz.roguehate.log.GameLog;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.SynchronousAssetLoader;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;

public class CharacterLoader extends SynchronousAssetLoader<Character, AssetLoaderParameters<Character>> {

    public CharacterLoader(FileHandleResolver resolver) {
        super(resolver);
    }

    @Override
    public Character load(AssetManager assetManager, String fileName, FileHandle file, AssetLoaderParameters<Character> parameter) {
        DefinitionMap definitionFile = new DefinitionMap.Loader(fileName).load();

        Character character = new Character();

        definitionFile.trySet("id", character::setId, "ERROR");
        definitionFile.trySet("name", character::setBaseName, "ERROR");
        definitionFile.trySet("health", character::setMaxHealth, 10);

        GameLog.i("Loader", "Character \"" + character.getId() + "\" loaded.");

        return character;
    }

    @Override
    public Array<AssetDescriptor> getDependencies(String fileName, FileHandle file, AssetLoaderParameters<Character> parameter) {
        return null;
    }

    /** Generates a path on the filesystem from a character's ID. */
    public static String getPathFromId(String id) {
        return "assets/data/character/" + id + ".yaml";
    }
}
