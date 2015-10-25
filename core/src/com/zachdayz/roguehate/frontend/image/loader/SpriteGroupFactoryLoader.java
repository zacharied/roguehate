package com.zachdayz.roguehate.frontend.image.loader;

import java.util.Locale;

import com.zachdayz.roguehate.file.yaml.DefinitionMap;
import com.zachdayz.roguehate.frontend.image.SpriteGroupFactory;

public class SpriteGroupFactoryLoader {
    private DefinitionMap file;

    public SpriteGroupFactoryLoader(DefinitionMap file) {
        this.file = file;
    }

    public SpriteGroupFactory load() {
        SpriteGroupFactory spriteGroup = new SpriteGroupFactory();

        file.trySet("type", v -> spriteGroup.setType(SpriteGroupFactory.SpriteGroupType.valueOf(v.toUpperCase(Locale.US))), "ROW");
        file.trySet("cellWidth", spriteGroup::setCellWidth, 0);
        file.trySet("cellHeight", spriteGroup::setCellHeight, 0);
        file.trySet("marginX", spriteGroup::setMarginX, 0);
        file.trySet("marginY", spriteGroup::setMarginY, 0);
        file.trySet("spacing", spriteGroup::setSpacing, 0);

        return spriteGroup;
    }
}
