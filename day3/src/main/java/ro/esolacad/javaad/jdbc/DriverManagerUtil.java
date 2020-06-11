package ro.esolacad.javaad.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ro.esol.acad.TestInOtherModule;

public class DriverManagerUtil {

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/java_ad_day_3",
                    "postgres", "postgres");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException("No connection found");
        }

        return connection;
    }
}
