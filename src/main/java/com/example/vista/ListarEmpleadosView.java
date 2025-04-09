package com.example.vista;

import com.example.DataStore;
import com.example.controlador.SceneManager;
import com.example.entidades.*;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListarEmpleadosView {

    public static void mostrar(Stage stagePrincipal) {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));

        TextArea areaEmpleados = new TextArea();
        areaEmpleados.setEditable(false);
        areaEmpleados.setPrefHeight(400);

        StringBuilder listado = new StringBuilder();

        listado.append("=== EMPLEADOS PERMANENTES ===\n");
        for (EmpleadoPermanente emp : DataStore.empleadosPermanentes) {
            if (emp != null) {
                listado.append(emp.getId())
                        .append(" - ")
                        .append(emp.getNombre()).append(" ").append(emp.getApellido())
                        .append(" | Salario: ").append(emp.getSalarioMensual())
                        .append(" | Antigüedad: ").append(emp.getAñosAntiguedad())
                        .append(" | Departamento: ")
                        .append(emp.getDepartamento() != null ? emp.getDepartamento().getNombre() : "Sin asignar")
                        .append("\n");
            }
        }

        listado.append("\n=== EMPLEADOS TEMPORALES ===\n");
        for (EmpleadoTemporal emp : DataStore.empleadosTemporales) {
            if (emp != null) {
                listado.append(emp.getId())
                        .append(" - ")
                        .append(emp.getNombre()).append(" ").append(emp.getApellido())
                        .append(" | Contrato: ").append(emp.getMesesContrato()).append(" meses")
                        .append(" | Pago por hora: ").append(emp.getPagoPorHora())
                        .append(" | Departamento: ")
                        .append(emp.getDepartamento() != null ? emp.getDepartamento().getNombre() : "Sin asignar")
                        .append("\n");
            }
        }

        areaEmpleados.setText(listado.toString());

        Button btnVolver = new Button("Volver al Menú");
        btnVolver.setOnAction(e -> {
            MainMenuView menu = new MainMenuView();
            SceneManager.switchScene(new Scene(menu.getView(), 600, 400));
        });

        layout.getChildren().addAll(areaEmpleados, btnVolver);

        Scene scene = new Scene(layout, 600, 500);
        stagePrincipal.setScene(scene);
        stagePrincipal.setTitle("Listado de Empleados");
        stagePrincipal.show();
    }
}
