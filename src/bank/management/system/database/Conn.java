package bank.management.system.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {

    public static Connection getConnection() {

        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bank_system",
                    "root",
                    "trisha123"
            );
        }

        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}