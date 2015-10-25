package com.zachdayz.roguehate.frontend.image;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SpriteGroup {
    private List<TextureRegion> textures = new ArrayList<>();

    public void addTexture(TextureRegion textureRegion) {
        textures.add(textureRegion);
    }

    public TextureRegion getFrame(int index) {
        return textures.get(index);
    }

    public Animation toAnimation(float frameTime) {
        return new Animation(frameTime, textures.toArray(new TextureRegion[textures.size()]));
    }
}
