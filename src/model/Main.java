package model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Main extends Application {
    public static Stage mainStage;

    public static void main(String[] args) {
        LanceurDePartie.INSTANCE.menuPrincipal();
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../ihm/lanceurDePartie.fxml"));
        primaryStage.setTitle("Football Manager");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        mainStage=primaryStage;
    }

}
