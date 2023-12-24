package app;

import java.util.HashMap;
import java.util.Map;

public class Configuration {
    public static class Database {
        public static String location = "";
    }

    public static class WindowTitle {
        public static String start = "Reg/Auth window";
        public static String main = "Main window";
    }

    public static class Fragments {
        public static Map<String, String> fragments = new HashMap<>();

        static {
            fragments.put("home", "/fragments/home-fragment.fxml");
            fragments.put("second", "/fragments/second-fragment.fxml");
        }
    }
}