import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class MojeDB {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:sample.db")) {
            /* kód používající conn */
            try (Statement stmt = conn.createStatement()) {
                stmt.executeUpdate("CREATE TABLE cislo IF NOT EXISTS cislno (n INT)");

            }
            }catch (SQLException e) {

        }
    }
}