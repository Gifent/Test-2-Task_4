package org.example.Task_4;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.Task_4.ConnectionDB.con;

/**
 * Графическое меню при помощи JavaFX
 */

class Student_info3 {

    private String name;
    private String age;

    public void inf() throws SQLException {}

    public String getName() {
        return name;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    public String getAge() {
        return age;
    }

    public String setAge(String age) {
        this.age = age;
        return age;
    }

    static class Worker extends Student_info3 {
        private String salary;
        private int id = 0;

        public String getSalary() {
            return salary;
        }

        public String setSalary(String salary) {
            this.salary = salary;
            return salary;
        }

        @Override
        public void inf() throws SQLException {
            String tablename = CreateDB.getTablename();

            System.out.println("Введите имя студента: ");
            setName(CheckAll.readValidText());
            System.out.println("Введите возраст студента: ");
            setAge(CheckAll.readValidNumber());
            System.out.println("Введите заработок студента: ");
            setSalary(CheckAll.readValidNumber());

            String query = "INSERT INTO " + tablename + " DEFAULT VALUES RETURNING id";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                id = rs.getInt(1);
            }

            String query_update1 = "UPDATE " + tablename + " SET NAME = ? WHERE ID = ?";
            PreparedStatement ps1 = con.prepareStatement(query_update1);
            ps1.setString(1, getName());
            ps1.setInt(2, id);
            ps1.executeUpdate();

            String query_update2 = "UPDATE " + tablename + " SET AGE = ? WHERE ID = ?";
            PreparedStatement ps2 = con.prepareStatement(query_update2);
            ps2.setString(1, getAge());
            ps2.setInt(2, id);
            ps2.executeUpdate();

            String query_update3 = "UPDATE " + tablename + " SET SALARY = ? WHERE ID = ?";
            PreparedStatement ps3 = con.prepareStatement(query_update3);
            ps3.setString(1, getSalary());
            ps3.setInt(2, id);
            ps3.executeUpdate();

            System.out.println("\nДанные успешно внесены!\n");
        }
    }

    public static void main(String[] args) throws SQLException {
        Worker student = new Worker();
        student.inf();
    }
}

