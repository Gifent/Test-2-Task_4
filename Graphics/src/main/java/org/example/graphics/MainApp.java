package org.example.graphics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.graphics.Tools.ConnectionDB;
import org.example.graphics.Tools.CreateDB;

import java.sql.SQLException;

public class MainApp extends Application {
    private void showAlert(Alert.AlertType alertType, String tittle, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(tittle);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @Override
    public void start(Stage stage){
        ConnectionDB.connect();
        stage.setTitle("Test №2");

        Button one = new Button("Вывести названия");
        Button two = new Button("Создать таблицу");
        Button three = new Button("Информация о студенте");
        Button four = new Button("Вывести информацию о таблице");
        Button five = new Button("Сохранить");

        VBox layout = new VBox(10, one, two, three, four, five);
        Scene scene = new Scene(layout, 300, 240);
        stage.setScene(scene);
        stage.show();

        two.setOnAction(actionEvent -> {
            try {
                CreateDB.create();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
