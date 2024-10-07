package tretak;

import java.sql.*;
import java.util.HashMap;
import java.util.Scanner;

public class DBpisemka {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        // Close the scanner to prevent resource leak
        scanner.close();

        // Split the input based on the first space occurrence
        String prijmeni = "nic";
        String jmeno_knihy = "nic";
        int firstSpaceIndex = input.indexOf(' ');
        if (firstSpaceIndex != -1) { // Check if space exists
            prijmeni = input.substring(0, firstSpaceIndex);
            jmeno_knihy = input.substring(firstSpaceIndex + 1);
        }
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql:")) {
            System.out.println("pripojeno k databazi");
            int id_uz = najdiIdUzivatele(conn, prijmeni);
            if (id_uz == -1) {
                System.out.println("neznamy uzivatel");
                return;
            }
            int id_knih = najdiIdKnihu(conn, jmeno_knihy);
            if (id_knih == -1) {
                System.out.println("neznama kniha");
                return;
            }
            vypujcit(conn, id_uz, id_knih);
            HashMap<String, Integer> seznam = seznamKnih(conn);
            System.out.println(seznam.toString());
        }
    }

    static int najdiIdUzivatele(Connection conn, String prijmeni) throws SQLException {
        String query = "SELECT id FROM uzivatel WHERE prijmeni = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, prijmeni);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            } else {
                return -1;
            }
        }
    }

    static int najdiIdKnihu(Connection conn, String jmenoKnihy) throws SQLException {
        String query = "SELECT id FROM kniha WHERE jmeno = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, jmenoKnihy);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            } else {
                return -1;
            }
        }
    }

    static void vypujcit(Connection conn, int idUzivatele, int idKnihy) throws SQLException {
        // Kontrola zda kniha již není vypůjčena
        String kontrolaQuery = "SELECT * FROM vypujcka WHERE id_uzivatel = ? AND id_kniha = ? AND vraceno IS NULL";
        try (PreparedStatement kontrolaStmt = conn.prepareStatement(kontrolaQuery)) {
            kontrolaStmt.setInt(1, idUzivatele);
            kontrolaStmt.setInt(2, idKnihy);
            ResultSet rs = kontrolaStmt.executeQuery();
            if (rs.next()) {
                String query = "UPDATE vypujcka SET vraceno = CURRENT_TIMESTAMP WHERE id_uzivatel = ? and id_kniha = ?";
                try (PreparedStatement stmt = conn.prepareStatement(query)) {
                    stmt.setInt(1, idUzivatele);
                    stmt.setInt(2, idKnihy);
                    stmt.executeUpdate();
                }
            }else {
                String query = "INSERT INTO vypujcka (id_uzivatel, id_kniha, vypujceno) VALUES (?, ?, CURRENT_TIMESTAMP)";
                try (PreparedStatement stmt = conn.prepareStatement(query)) {
                    stmt.setInt(1, idUzivatele);
                    stmt.setInt(2, idKnihy);
                    stmt.executeUpdate();
                }
            }
        }
    }
    static HashMap seznamKnih(Connection conn) throws SQLException {
        HashMap<String,Integer> mapa = new HashMap<String,Integer>();
        String query = "SELECT id_kniha FROM vypujcka";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            String key = rs.getString("id_kniha");
            if (mapa.get(key) != null){
                int vlaue = mapa.get(key);
                vlaue++;
                mapa.replace(key,vlaue);
            }else {
                mapa.put(key,1);
            }
        }
        return mapa;
    }
}
