package com.example.vista;

import com.example.controlador.SceneManager;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class MainMenuView {

    private VBox root;
    private Button btnEmpleados;
    private Button btnDepartamentos;
    private Button btnReportes;

    public MainMenuView() {
        root = new VBox(15);
        root.setAlignment(Pos.CENTER);

        btnEmpleados = new Button("Gestionar Empleados");
        btnDepartamentos = new Button("Gestionar Departamentos");
        btnReportes = new Button("Generar Reportes de Desempeño");

        // Eventos de los botones
        btnEmpleados.setOnAction(e -> {
            VistaEmpleadosView empleadosView = new VistaEmpleadosView();
            SceneManager.switchScene(new Scene(empleadosView.getView(), 600, 400));
        });
/*
        btnDepartamentos.setOnAction(e -> {
            VistaDepartamentosView departamentosView = new VistaDepartamentosView();
            SceneManager.switchScene(new Scene(departamentosView.getView(), 600, 400));
        });

        btnReportes.setOnAction(e -> {
            VistaReportesView reportesView = new VistaReportesView();
            SceneManager.switchScene(new Scene(reportesView.getView(), 600, 400));
        });
*/
        root.getChildren().addAll(btnEmpleados, btnDepartamentos, btnReportes);
    }

    public VBox getView() {
        return root;
    }
}
