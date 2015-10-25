package com.zachdayz.roguehate.game.character;

public class CharacterInstance {
    private Character character;
    private String uniqueName;

    public CharacterInstance(Character character) {
        this.character = character;
    }

    public String getName() {
        return uniqueName != null ? uniqueName : character.getBaseName();
    }
}
