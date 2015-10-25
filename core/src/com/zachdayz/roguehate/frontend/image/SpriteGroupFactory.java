package com.zachdayz.roguehate.frontend.image;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SpriteGroupFactory {
    private SpriteGroupType type;

    private int cellWidth, cellHeight;
    private int marginX, marginY;
    private int spacing;

    public SpriteGroup toSpriteGroup(Texture texture) {
        SpriteGroup spriteGroup = new SpriteGroup();

        switch (type) {
            case ROW:
                for (int x = marginX; x < texture.getWidth(); x += cellWidth + spacing) {
                    spriteGroup.addTexture(new TextureRegion(texture, x, marginY, cellWidth, cellHeight));
                }

                break;
            case COLUMN:
                break;
        }

        return spriteGroup;
    }

    public void setType(SpriteGroupType type) {
        this.type = type;
    }

    public void setCellWidth(int cellWidth) {
        this.cellWidth = cellWidth;
    }

    public void setCellHeight(int cellHeight) {
        this.cellHeight = cellHeight;
    }

    public void setMarginX(int marginX) {
        this.marginX = marginX;
    }

    public void setMarginY(int marginY) {
        this.marginY = marginY;
    }

    public void setSpacing(int spacing) {
        this.spacing = spacing;
    }

    public enum SpriteGroupType {
        ROW,
        COLUMN;
    }
}
