package util;

import java.util.HashMap;
import java.util.Map;

public class State {
    private static final Map<String, Object> state = new HashMap<>();

    public static <T> T get(String key) {
        return (T) state.get(key);
    }

    public static void update(String key, Object newValue) {
        state.put(key, newValue);
    }
}
