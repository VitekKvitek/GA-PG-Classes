package tretak;

import java.sql.*;
import java.util.*;

public class DUKnihovna {
    public static void main(String[] args) throws SQLException {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql:")) {
            System.out.println("pripojeno k databazi");
            HashMap<Integer, Integer> knihyUdaje = vsechnyVypujcky(conn);
            int nejVyskyt = Integer.MIN_VALUE;
            int nejID = 0;
            for (Map.Entry<Integer, Integer> entry :
                    knihyUdaje.entrySet()) {
                int key = entry.getKey();
                int value = entry.getValue();
                if (value > nejVyskyt) {
                    nejVyskyt = value;
                    nejID = key;
                }
            }
            HashSet<Integer> idPujcovatelu = getSeznamID(conn, nejID);
            ArrayList<String> seznamPrij = new ArrayList<String>();
            for (int userId :
                    idPujcovatelu) {
                String prijmeni = getPrijmeni(conn, userId);
                seznamPrij.add(prijmeni);
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(nejVyskyt);
            for (String prijmeni :
                    seznamPrij) {
                stringBuffer.append(" ");
                stringBuffer.append(prijmeni);
            }
            System.out.println(stringBuffer);
        }
    }

    public static HashMap<Integer, Integer> vsechnyVypujcky(Connection conn) throws SQLException {
        HashMap<Integer, Integer> knihyUdaje = new HashMap<Integer, Integer>();
        String query = "SELECT id_kniha FROM vypujcka";
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            int userID = rs.getInt("id_kniha");
            if (knihyUdaje.containsKey(userID)) {
                int pocet = knihyUdaje.get(userID);
                knihyUdaje.put(userID, pocet + 1);
            } else {
                knihyUdaje.put(userID, 1);
            }
        }
        return knihyUdaje;
    }
    public static HashSet<Integer> getSeznamID(Connection conn, int idKnihy) throws SQLException {
        HashSet<Integer> idPujcovatelu = new HashSet<Integer>();

        String query = "SELECT id_uzivatel FROM vypujcka WHERE id_kniha = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idKnihy); // TADY MUSI BYT setInt
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                idPujcovatelu.add(rs.getInt("id_uzivatel"));
            }
        }
        return idPujcovatelu;
    }

    public static String getPrijmeni(Connection conn, int idUzivatel) throws SQLException {

        String query = "SELECT prijmeni FROM uzivatel WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idUzivatel);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("prijmeni");
            } else {
                return "nikdo";
            }
        }
    }
}
