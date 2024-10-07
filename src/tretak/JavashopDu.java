package tretak;

import java.sql.*;
import java.util.Scanner;

public class JavashopDu {
    public static void main(String[] args) throws SQLException {
        System.out.println("program jede");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().strip();

        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/db1372",
                "db1372",
                "ooXiete2aiHe3eeko6Ee")) {
            System.out.println("pripojeno k databazi");
            String sql = "SELECT  id  FROM zbozi WHERE jmeno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            System.out.println(sql);
            ps.setString(1, input); // dosadi za prvni otaznik input
            PreparedStatement ps2 = conn.prepareStatement("SELECT kusu FROM sklad WHERE id_zbozi = ?");
            int id_zbozi = dej_cislo(ps);
            ps2.setInt(1, id_zbozi);
            int pocet_kusu = dej_cislo(ps2);

            System.out.println("pocet kusu je:" + pocet_kusu);
        }
    }

    private static int dej_cislo(PreparedStatement ps) throws SQLException {
        int id_zbozi;
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                id_zbozi = rs.getInt(1);
                System.out.println(rs.getInt(1));
                return  id_zbozi;
            }
        } return -1; //neni v tabulce
    }
}
