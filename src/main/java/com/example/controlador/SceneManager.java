package com.example.controlador;


import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneManager {

    private static Stage stage;

    public static void setStage(Stage mainStage) {
        stage = mainStage;
    }

    public static Stage getStagePrincipal() {
        return stage;
    }


    public static void switchScene(Scene scene) {
        if (stage != null) {
            stage.setScene(scene);
        }
    }
}
