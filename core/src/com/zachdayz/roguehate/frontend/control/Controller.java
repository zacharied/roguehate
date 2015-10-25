package com.zachdayz.roguehate.frontend.control;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import com.zachdayz.roguehate.file.yaml.DefinitionMap;
import com.zachdayz.roguehate.log.GameLog;

public class Controller extends ControlReceiver {
    private Map<Key, Action> keymap = new EnumMap<>(Key.class);
    private List<ActionReceiver> targets = new ArrayList<>();

    public Controller(DefinitionMap configFile, String profileName) {
        Map<String, ?> profileMap = configFile.getMap(profileName);

        if (profileMap != null) {
            for (Action action : Action.values()) {
                if (profileMap.get(action.getConfigName()) != null) {
                    Key key = Key.valueOf((String) profileMap.get(action.getConfigName()));
                    GameLog.i("Control", "Mapped key \"" + key.name() + "\" to action \"" + action.name() + "\".");
                    keymap.put(Key.valueOf((String) profileMap.get(action.getConfigName())), action);
                }
            }
        } else {
            throw new IllegalArgumentException("Profile \"" + profileName + "\" not found in the control config.");
        }
    }

    public void addReceiver(ActionReceiver c) {
        targets.add(c);
    }

    @Override
    public boolean onControl(Key key, Key.Event event) {
        boolean handled = false;
        for(ActionReceiver receiver : targets) {
            // Perform the action on every action handler and return true if the action is handled at all.
            if (!keymap.containsKey(key)) {
                return false;
            } else {
                handled = receiver.onControl(keymap.get(key), event) || handled;
            }
        }

        return handled;
    }
}
