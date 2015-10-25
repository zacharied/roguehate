package com.zachdayz.roguehate.frontend.image;

import java.util.HashMap;
import java.util.Map;

public class SpriteSheet {
    private Map<String, SpriteGroup> groups = new HashMap<>();

    public void addGroup(String name, SpriteGroup group) {
        groups.put(name, group);
    }

    public SpriteGroup getGroup(String name) {
        return groups.get(name);
    }
}
