package util;

import app.Configuration;
import models.User;
import java.sql.*;

// SQLite Java ->
// https://www.tutorialspoint.com/sqlite/sqlite_java.htm

public class DBManager {
    private static Connection _conn = null;

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(Configuration.Database.driver + DBManager.class.getResource(Configuration.Database.location).toExternalForm());
    }

    public static void authUser(String login, String password) {
        Statement _statement;

        try {
            if (_conn == null) {
                _conn = getConnection();
            }

            _statement = _conn.createStatement();
            String SQL = "SELECT * FROM Users;";

            ResultSet set = _statement.executeQuery(SQL);

            while (set.next()) {
                int setID = set.getInt("ID");
                String setLogin = set.getString("LOGIN");
                String setPassword = set.getString("PASSWORD");

                if (setLogin.equals(login) && setPassword.equals(password)) {
                    User user = new User(setID, setLogin);
                    State.update("user", user);

                    return;
                }

                User user = new User(-1, "");
                State.update("user", user);
            }

            set.close();
            _statement.close();

        } catch (SQLException ignored) {
            System.out.println(ignored.getMessage());
        }
    }

    public static void createUser(String login, String password) {
        Statement _statement;

        try {
            if (_conn == null) {
                _conn = getConnection();
            }

            String SQL = String.format("INSERT INTO Users (LOGIN, PASSWORD) VALUES ('%s', '%s')", login, password);

            _statement = _conn.createStatement();
            _statement.executeUpdate(SQL);
            _statement.close();

            State.update("user_registered", true);

        } catch (SQLException ignored) {
            State.update("user_registered", false);
            System.out.println(ignored.getMessage());
        }
    }

    public static void initTables() {
        Statement _statement;

        try {
            if (_conn == null) {
                _conn = getConnection();
            }

            _statement = _conn.createStatement();

            for (String tableSQL : Configuration.Database.InitialTables.tableSQLs) {
                _statement.executeUpdate(tableSQL);
            }

            _statement.close();

        } catch (SQLException ignored) {}
    }
}
