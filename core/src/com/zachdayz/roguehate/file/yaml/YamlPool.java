package com.zachdayz.roguehate.file.yaml;

import java.util.HashMap;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

/**
 * Manages different YAML parser instances per thread.
 */
public class YamlPool {
    private static Map<Thread, Yaml> pool = new HashMap<>();

    public static Yaml getYaml(Thread thread) {
        Yaml yaml = pool.get(thread);

        if (yaml == null) {
            yaml = new Yaml();
            pool.put(thread, yaml);
        }

        return yaml;
    }
}
