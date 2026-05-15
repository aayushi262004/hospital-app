package hospital;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL =
        "jdbc:postgresql://hospitaldb_4hvp_user:WqQXjg2C6bt1fRMdbJVKEzQQ4N6ZjNCI@dpg-d83ebhjrjlhs73ef8reg-a.oregon-postgres.render.com/hospitaldb_4hvp";

    public static Connection getConnection() {

        Connection conn = null;

        try {

            Class.forName("org.postgresql.Driver");

            conn = DriverManager.getConnection(URL);

            System.out.println("Connected!");

        } catch (Exception e) {

            e.printStackTrace();
        }

        return conn;
    }
}