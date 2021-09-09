package Main;

import java.sql.DriverManager;
import java.sql.Connection;
//import com.ddtek.jdbc.postgresql.PostgreSQLdriver;

public class Database {

    public static final String url = "jdbc:postgresql://localhost:5434/nickcliffel";
    public static final String password = "";
    public static final String username = "";

    public static String getUrl() {
        return url;
    }

    public static String getPassword() {
        return password;
    }

    public static String getUsername() {
        return username;
    }
}
