package org.example.graphics.Tools;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.sql.Statement;

import static org.example.graphics.Tools.ConnectionDB.con;

public class CreateDB {
    private static String tablename;

    private static void showAlert(Alert.AlertType alertType, String tittle, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(tittle);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void create() throws SQLException {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);

        window.setTitle("Создание таблицы");
        TextField text = new TextField();
        Button save = new Button("Сохранить");

        VBox layout = new VBox(10, text, save);
        Scene scene = new Scene(layout, 300, 250);

        save.setOnAction(actionEvent -> {
            String tablename = text.getText();

            String query = "CREATE TABLE IF NOT EXISTS " + tablename +
                    " (ID SERIAL PRIMARY KEY, " +
                    "NAME VARCHAR(1000), " +
                    "AGE VARCHAR(1000), " +
                    "SALARY VARCHAR(1000))";

            try (Statement stmt = con.createStatement()) {
                stmt.executeUpdate(query);
                showAlert(Alert.AlertType.INFORMATION, "Успех", "Таблица успешно создана!");
                window.close();
            } catch (SQLException e) {
                showAlert(Alert.AlertType.ERROR, "Ошибка", "Некорректные символы!");
            }
        });

        window.setScene(scene);
        window.showAndWait();
    }

    public static String getTablename() {
        return tablename;
    }
}
