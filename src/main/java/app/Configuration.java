package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// App configuration

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

                // tableSQLs.add(""" CREATE ... """);
            }
        }
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

            // fragments.put("my-fragment", "/path/to/fragment.fxml");
        }
    }
}