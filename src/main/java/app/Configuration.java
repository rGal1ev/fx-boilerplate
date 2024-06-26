package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Configuration {
    public static class Database {
        public static String driver = "jdbc:sqlite:";
        public static String location = "/database/store.db";

        public static class InitialTables {
            public static ArrayList<String> tableSQLs = new ArrayList<>();

            static {
                tableSQLs.add("""
                        CREATE TABLE IF NOT EXISTS Users (
                            ID INTEGER PRIMARY KEY AUTOINCREMENT,
                            LOGIN TEXT UNIQUE NOT NULL,
                            PASSWORD TEXT NOT NULL
                        );
                        """);
            }
        }
    }

    public static class WindowTitle {
        public static String start = "Reg/Auth window";
        public static String main = "Main window";
    }

    public static class Windows {
        public static Map<String, String> windows = new HashMap<>();

        static {
            windows.put("start", "/views/start-view.fxml");
            windows.put("main", "/views/main-view.fxml");
        }
    }
}