package org.example.Task_4;

import java.sql.SQLException;

public class run_4 {
    protected static boolean Tableon = false;
    public static void run() throws SQLException {

        ConnectionDB.connect();

        boolean running = true;

        while (running) {

            System.out.println("1) Вывести название таблиц");
            System.out.println("2) Создать таблицу");
            System.out.println("3) Информация о студенте");
            System.out.println("4) Вывести информацию о таблице");
            System.out.println("5) Сохранить");
            System.out.println("0) Выход");

            System.out.print("Введите номер: ");
            String number = CheckAll.readValidInput();

            if (number.equals("1")) {
                InsertTableName.show_names();
            }

            if (number.equals("2")) {
                CreateDB.create();
                Tableon = true;
            }

            if (number.equals("3")) {
                if (!Tableon) {
                    System.out.println("Ошибка! Создайте таблицу.");
                    continue;
                }
                Student_info3.Worker student = new Student_info3.Worker();
                student.inf();
            }

            if (number.equals("4")) {
                if (!Tableon) {
                    System.out.println("Ошибка! Создайте таблицу.");
                    continue;
                }
                OutputInformation.output();
            }

            if (number.equals("5")) {
                if (!Tableon) {
                    System.out.println("Ошибка! Создайте таблицу.");
                    continue;
                }
                SaveDB.save();
            }

            if (number.equals("0")) {
                running = false;

            }
        }
    }

    public static void main(String[] args) throws SQLException {
        run_4.run();
    }
}
