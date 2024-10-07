package tretak;

import java.sql.*;

public class MojeDB {
    public static void main(String[] args) {
        String[] data = {"jedna", "dva", "tri", "ctyri", "pet", "sest"};
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/db1372",
                "db1372",
                "ooXiete2aiHe3eeko6Ee")) {
            /* kód používající conn */
            try (Statement stmt = conn.createStatement()) {
                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS cislo3 (n INT, popis VARCHAR)");
                for (int i = 0; i < data.length; i++) {
                    stmt.executeUpdate("INSERT INTO cislo3 VALUES (" + (i +1) + ",'" + data[i] + "')");
                }
            }
            try (Statement stmt = conn.createStatement()) {
                try (ResultSet rs = stmt.executeQuery("SELECT * FROM cislo3")) {
                    while (rs.next()) {
                        int n = rs.getInt(1);
                        String p = rs.getString(2);

                        System.out.println(n + " " + p);
                    }
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}