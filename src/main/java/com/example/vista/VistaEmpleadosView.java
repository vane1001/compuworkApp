package com.example.vista;


import com.example.controlador.SceneManager;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class VistaEmpleadosView {

    private VBox root;

    public VistaEmpleadosView() {
        root = new VBox(15);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);

        Label title = new Label("Gestión de Empleados");

        Button btnAgregar = new Button("Agregar Empleado");
        Button btnEliminar = new Button("Eliminar Empleado");
        Button btnListar = new Button("Listar Empleados");
        Button btnVolver = new Button("Volver al Menú");

        // Acciones básicas por ahora
        btnAgregar.setOnAction(e -> {
            CrearEmpleadoView crearEmpleado = new CrearEmpleadoView();
            crearEmpleado.mostrarVentana();
        });

        btnEliminar.setOnAction(e -> {
            System.out.println("Eliminar empleado (próxima implementación)");
        });

        btnListar.setOnAction(e -> {
            ListarEmpleadosView listarEmpleados = new ListarEmpleadosView();
            listarEmpleados.mostrar(SceneManager.getStagePrincipal());
        });

        btnVolver.setOnAction(e -> {
            MainMenuView menu = new MainMenuView();
            SceneManager.switchScene(new Scene(menu.getView(), 600, 400));
        });

        root.getChildren().addAll(title, btnAgregar, btnEliminar, btnListar, btnVolver);
    }

    public Parent getView() {
        return root;
    }
}
