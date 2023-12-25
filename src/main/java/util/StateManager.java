package util;

import java.util.HashMap;
import java.util.Map;

// Static state class, can be accessed and mutated from any class

// Cast data to passed type: .update("key", 1) -> (int) .get("key")
//                           .update("key", new Class()) -> (Class) .get("key")

public class StateManager {
    private static final Map<String, Object> state = new HashMap<>();

    public static Object get(String key) {
        return state.get(key);
    }

    public static void update(String key, Object newValue) {
        state.put(key, newValue);
    }
}
