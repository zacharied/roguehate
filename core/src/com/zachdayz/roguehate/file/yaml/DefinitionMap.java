package com.zachdayz.roguehate.file.yaml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collection;
import java.util.Map;
import java.util.function.Consumer;

import com.zachdayz.roguehate.log.GameLog;

import org.yaml.snakeyaml.Yaml;

@SuppressWarnings("unchecked")
public class DefinitionMap {
    private Map<String, ?> data;

    public DefinitionMap(Map<String, ?> data) {
        this.data = data;
    }

    public Object get(String key) {
        return data.get(key);
    }

    public String getString(String key) {
        return (String) data.get(key);
    }

    public Map<String, ?> getMap() {
        return data;
    }

    public Map<String, ?> getMap(String key) {
        return (Map<String, ?>) data.get(key);
    }

    public Collection<?> getCollection(String key) {
        return (Collection<?>) data.get(key);
    }

    public <T> void trySet(String key, Consumer<T> setter, T fallback) {
        if (data.containsKey(key)) {
            setter.accept((T) get(key));
        } else {
            GameLog.e("YAML", "Error attempting to set a value from the YAML map: could not find property " + key + " in map. Using fallback value of \"" + fallback + "\".");
            setter.accept(fallback);
        }
    }

    /** Creates a {@link Map} from the designated YAML file. */
    public static class Loader {
        private FileReader configFileReader;

        /** @param configFileName The name of the configuration file to load. Must not have an extension. */
        public Loader(String configFileName) {
            try {
                configFileReader = new FileReader(new File(configFileName));
            } catch (FileNotFoundException e) {
                GameLog.e("File", "File " + configFileName + " not found in config directory.");
            }
        }

        @SuppressWarnings("unchecked")
        public DefinitionMap load() {
            Yaml yaml = YamlPool.getYaml(Thread.currentThread());
            return new DefinitionMap(yaml.loadAs(configFileReader, Map.class));
        }
    }
}
