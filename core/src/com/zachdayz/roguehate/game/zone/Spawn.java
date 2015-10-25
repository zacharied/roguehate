package com.zachdayz.roguehate.game.zone;

/**
 * A relationship between a {@link Zone} and a {@link Character} that defines the conditions under which a character can appear in that zone.
 */
public class Spawn {
    private String characterId;

    public Spawn(String characterId) {
        this.characterId = characterId;
    }
}
