package com.zachdayz.roguehate.game.zone;

import java.util.ArrayList;
import java.util.List;

public class Zone {
    private List<Spawn> spawns = new ArrayList<>();

    public void addSpawn(Spawn spawn) {
        spawns.add(spawn);
    }
}
