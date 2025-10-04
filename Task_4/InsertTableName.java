package org.example.Task_4;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.example.Task_4.ConnectionDB.con;

public class InsertTableName {

    public static void show_names() throws SQLException {
        String query = "SELECT table_name FROM information_schema.tables WHERE table_schema = 'public'";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        System.out.println("\n");
        while (rs.next()) {
            System.out.println(rs.getString("table_name"));
        }
        System.out.println("\n");
    }

    public static void main(String[] args) throws SQLException {
       show_names();
    }
}
