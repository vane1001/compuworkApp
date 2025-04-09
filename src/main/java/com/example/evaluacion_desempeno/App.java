package com.example.evaluacion_desempeno;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import com.example.CargaDatosTemporales;
import com.example.Excepciones.EmpleadoInvalidoException;
import com.example.Excepciones.ReporteInvalidoException;
import com.example.controlador.SceneManager;
import com.example.vista.MainMenuView;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage primaryStage) throws EmpleadoInvalidoException, ReporteInvalidoException {
        CargaDatosTemporales.cargar();
        
        try {
            SceneManager.setStage(primaryStage); // REGISTRO
            MainMenuView menu = new MainMenuView();
            Scene scene = new Scene(menu.getView(), 600, 400);
            primaryStage.setTitle("CompuWork - Gestión de Recursos Humanos");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}