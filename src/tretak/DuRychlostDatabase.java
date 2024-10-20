package tretak;

import pl.allegro.finance.tradukisto.ValueConverters;

import java.sql.*;
import java.util.concurrent.ThreadLocalRandom;

public class DuRychlostDatabase {
    public static void main(String[] args) throws SQLException {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql:")) {

            // Tvorba tabulky
            vytvorT(conn);

            // Pripad pro 1000 cisel
            for (int i = 0; i <= 1000; i++) {
                vlozCisla(conn, i);
            }

            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += selectCislo(conn, 1000);
            }
            float avg0 = sum / 10;

            sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += selectCisloCZ(conn, 1000);
            }
            float avg1 = sum / 10;


            // Pripad pro 10 000 cisel
            for (int i = 1001; i <= 10000; i++) {
                vlozCisla(conn, i);
            }

            sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += selectCislo(conn, 10000);
            }
            float avg2 = sum / 10;

            sum = 0;
            for (int i = 0; i < 10; i++) {
                selectCisloCZ(conn, 10000);
            }
            float avg3 = sum / 10;

            //Print
            System.out.println(avg0);
            System.out.println(avg1);
            System.out.println(avg2);
            System.out.println(avg3);
        }
    }

    public static long selectCislo(Connection conn, int bound) throws SQLException {
        long vysledek = 0;
        int cislo = ThreadLocalRandom.current().nextInt(0, bound + 1);
        ValueConverters intConverter = ValueConverters.CZECH_INTEGER;
        String jmenoCisla = intConverter.asWords(cislo);
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT cislo FROM cisla WHERE cislo_cz=?");

            ps.setString(1, jmenoCisla);

            long start = System.currentTimeMillis();

            ps.executeQuery();

            long end = System.currentTimeMillis();
            vysledek = end - start;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vysledek;
    }

    public static long selectCisloCZ(Connection conn, int bound) throws SQLException {

        int cislo = ThreadLocalRandom.current().nextInt(0, bound + 1);
        long vysledek = 0;

        try {

            PreparedStatement ps = conn.prepareStatement("SELECT cislo_cz FROM cisla WHERE cislo=?");
            ps.setInt(1, cislo);

            long start = System.currentTimeMillis();

            ps.executeQuery();

            long end = System.currentTimeMillis();
            vysledek = end - start;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vysledek;
    }

    public static void vytvorT(Connection conn) {
        try {
            PreparedStatement ps = conn.prepareStatement("CREATE TABLE cisla (" +
                    "    cislo INT PRIMARY KEY," +
                    "    cislo_cz VARCHAR NOT NULL," +
                    "    cislo_sk VARCHAR" +
                    ")");
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void vlozCisla(Connection conn, int cislo) throws SQLException {
        ValueConverters intConverter = ValueConverters.CZECH_INTEGER;
        String jmenoCisla = intConverter.asWords(cislo);

        PreparedStatement ps = conn.prepareStatement("INSERT INTO cisla VALUES (?, ?)");
        ps.setInt(1, cislo);
        ps.setString(2, jmenoCisla);
        ps.executeUpdate();


    }
}

