package tretak;

import pl.allegro.finance.tradukisto.ValueConverters;

import java.sql.*;
import java.util.concurrent.ThreadLocalRandom;

public class UniqueCisla {
    public static void main(String[] args) throws SQLException {
        System.out.println("program jede");

        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/db1372",
                "db1372",
                "ooXiete2aiHe3eeko6Ee")) {
            System.out.println("pripojeno k databazi");
            for (int i = 0; i < 1000; i++){
                int cislo = ThreadLocalRandom.current().nextInt(0, 2000 + 1);
                while (isInDB(cislo, conn) == true){
                    cislo = ThreadLocalRandom.current().nextInt(0, 2000 + 1);
                }
                putInDB(cislo,conn);
            }
        }
    }

    public static boolean isInDB(int cislo, Connection conn) throws SQLException {
        System.out.println("Zkouska" + cislo);
        try (PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) from cislo where i = ?")) {
            stmt.setInt(1, cislo);
            try (ResultSet rs = stmt.executeQuery()) {
                rs.next();
                int out = rs.getInt(1);
                return out > 0;
            }
        }
    }

    public static void putInDB(int cislo, Connection conn) throws SQLException {
        System.out.println(cislo);
        ValueConverters intConverter = ValueConverters.RUSSIAN_INTEGER;
        String czech = intConverter.asWords(cislo);
        try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO cislo VALUES (?,?)")) {
            stmt.setInt(1, cislo);
            stmt.setString(2, czech);
            stmt.executeUpdate();
            System.out.println(cislo + "," + czech);
        }
    }
}

