package com.example.vista;

import com.example.entidades.EmpleadoPermanente;
import com.example.entidades.EmpleadoTemporal;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class CrearEmpleadoView {

    public void mostrarVentana() {
        Stage ventana = new Stage();
        ventana.setTitle("Crear Empleado");

        // Campos comunes
        TextField txtId = new TextField();
        TextField txtNombre = new TextField();
        TextField txtApellido = new TextField();

        // Selección de tipo
        ComboBox<String> comboTipo = new ComboBox<>();
        comboTipo.getItems().addAll("Permanente", "Temporal");

        // Contenedor para campos dinámicos
        VBox camposDinamicos = new VBox(10);

        // Campos para empleado permanente
        TextField txtSalarioMensual = new TextField();
        TextField txtAniosAntiguedad = new TextField();

        // Campos para empleado temporal
        TextField txtMesesContrato = new TextField();
        TextField txtPagoPorHora = new TextField();

        comboTipo.setOnAction(e -> {
            camposDinamicos.getChildren().clear();
            if (comboTipo.getValue().equals("Permanente")) {
                txtSalarioMensual.setPromptText("Salario mensual");
                txtAniosAntiguedad.setPromptText("Años de antigüedad");
                camposDinamicos.getChildren().addAll(txtSalarioMensual, txtAniosAntiguedad);
            } else if (comboTipo.getValue().equals("Temporal")) {
                txtMesesContrato.setPromptText("Meses de contrato");
                txtPagoPorHora.setPromptText("Pago por hora");
                camposDinamicos.getChildren().addAll(txtMesesContrato, txtPagoPorHora);
            }
        });

        // Botón para guardar
        Button btnGuardar = new Button("Guardar");
        btnGuardar.setOnAction(e -> {
            String id = txtId.getText();
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();
            String tipo = comboTipo.getValue();

            if (tipo == null || id.isEmpty() || nombre.isEmpty() || apellido.isEmpty()) {
                mostrarAlerta("Por favor complete todos los campos obligatorios.");
                return;
            }

            if (tipo.equals("Permanente")) {
                try {
                    double salario = Double.parseDouble(txtSalarioMensual.getText());
                    int anios = Integer.parseInt(txtAniosAntiguedad.getText());
                    EmpleadoPermanente emp = new EmpleadoPermanente(id, nombre, apellido, salario, anios);
                    // Aquí podrías agregarlo a tu arreglo de empleados
                    mostrarAlerta("Empleado permanente creado con éxito.");
                } catch (Exception ex) {
                    mostrarAlerta("Error al crear empleado permanente: verifica los datos.");
                }
            } else if (tipo.equals("Temporal")) {
                try {
                    int meses = Integer.parseInt(txtMesesContrato.getText());
                    double pago = Double.parseDouble(txtPagoPorHora.getText());
                    EmpleadoTemporal emp = new EmpleadoTemporal(id, nombre, apellido, meses, pago);
                    // Aquí podrías agregarlo a tu arreglo de empleados
                    mostrarAlerta("Empleado temporal creado con éxito.");
                } catch (Exception ex) {
                    mostrarAlerta("Error al crear empleado temporal: verifica los datos.");
                }
            }
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(
            new Label("ID:"), txtId,
            new Label("Nombre:"), txtNombre,
            new Label("Apellido:"), txtApellido,
            new Label("Tipo de Empleado:"), comboTipo,
            camposDinamicos,
            btnGuardar
        );

        Scene escena = new Scene(layout, 350, 500);
        ventana.setScene(escena);
        ventana.show();
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
