package org.example.Task_4;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.example.Task_4.ConnectionDB.con;

public class OutputInformation {

    public static void output() throws SQLException {
        String tablename = CreateDB.getTablename();

        Statement stmt = con.createStatement();
        String query = "SELECT * FROM " + tablename;
        ResultSet rs = stmt.executeQuery(query);

        System.out.println("\n");
        System.out.printf("%-5s %-10s %-5s %-10s%n", "ID", "NAME", "AGE", "SALARY");
        System.out.println("------------------------------");
        while (rs.next()) {

            int id = rs.getInt("id");
            String name = rs.getString("name");
            String age = rs.getString("age");
            String salary = rs.getString("salary");

            System.out.printf("%-5d %-10s %-5s %-10s%n", id, name, age, salary);
        }
        System.out.println("\n");
    }

    public static void main(String[] args) throws SQLException {
        output();
    }
}
