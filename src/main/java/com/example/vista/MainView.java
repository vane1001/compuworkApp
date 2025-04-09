package com.example.vista;


import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

import com.example.Excepciones.EmpleadoInvalidoException;
import com.example.Excepciones.ReporteInvalidoException;
import com.example.entidades.*;

import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;


public class MainView {

    private VBox root;

    private Departamento[] departamentos = new Departamento[5];
    private EmpleadoPermanente[] permanentes = new EmpleadoPermanente[10];
    private EmpleadoTemporal[] temporales = new EmpleadoTemporal[10];
    private ReporteDesempeno[] reportes = new ReporteDesempeno[20];

    public MainView() {
        root = new VBox(10);
        crearDatosDeMuestra();
        inicializarVista();
    }

    public VBox getRoot() {
        return root;
    }

    private void crearDatosDeMuestra() {
        // Crear departamentos
        departamentos[0] = new Departamento("Sistemas");
        departamentos[1] = new Departamento("Recursos Humanos");
        departamentos[2] = new Departamento("Contabilidad");
        departamentos[3] = new Departamento("Marketing");
        departamentos[4] = new Departamento("Logística");

        // Empleados permanentes
        for (int i = 0; i < 10; i++) {
            permanentes[i] = new EmpleadoPermanente("P" + (i + 1), "Permanente" + i, "Apellido" + i, 3000 + i * 100, 2 + i);
            try {
                departamentos[i % 5].agregarEmpleado(permanentes[i]);
            } catch (EmpleadoInvalidoException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        // Empleados temporales
        for (int i = 0; i < 10; i++) {
            temporales[i] = new EmpleadoTemporal("T" + (i + 1), "Temporal" + i, "Apellido" + i, 6 + i, 15.5 + i);
            try {
                departamentos[(i + 1) % 5].agregarEmpleado(temporales[i]);
            } catch (EmpleadoInvalidoException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        // Reportes
        int r = 0;
        for (Empleado e : permanentes) {
            try {
                reportes[r++] = new ReporteDesempeno(e, "2025-Q1", nota(), nota(), nota());
            } catch (ReporteInvalidoException e1) {
                e1.printStackTrace();
            }
        }

        for (Empleado e : temporales) {
            try {
                reportes[r++] = new ReporteDesempeno(e, "2025-Q1", nota(), nota(), nota());
            } catch (ReporteInvalidoException e1) {
                e1.printStackTrace();
            }
        }
    }

    private void inicializarVista() {
        Label titulo = new Label("Sistema CompuWork");
        titulo.setFont(new Font(24));
        root.getChildren().add(titulo);

        for (Departamento depto : departamentos) {
            VBox contenidoDepto = new VBox();
            for (Empleado e : depto.getEmpleados()) {
                contenidoDepto.getChildren().add(new Label(e.toString()));
            }
            TitledPane panel = new TitledPane("Departamento: " + depto.getNombre(), contenidoDepto);
            root.getChildren().add(panel);
        }

        TextArea areaReportes = new TextArea();
        areaReportes.setEditable(false);
        for (ReporteDesempeno r : reportes) {
            if (r != null) areaReportes.appendText(r.generarResumen() + "\n\n");
        }

        ScrollPane scroll = new ScrollPane(areaReportes);
        scroll.setPrefHeight(200);
        TitledPane reportesPane = new TitledPane("Reportes de Desempeño", scroll);
        root.getChildren().add(reportesPane);
    }

    private double nota() {
        return Math.round((6 + Math.random() * 4) * 10.0) / 10.0;
    }
}
