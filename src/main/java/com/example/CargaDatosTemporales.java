package com.example;

import com.example.Excepciones.EmpleadoInvalidoException;
import com.example.Excepciones.ReporteInvalidoException;
import com.example.entidades.*;


public class CargaDatosTemporales {

    public static void cargar() throws EmpleadoInvalidoException, ReporteInvalidoException {
        // Crear departamentos
        String[] nombresDept = {"Recursos Humanos", "Tecnología", "Marketing", "Ventas", "Finanzas"};
        for (String nombre : nombresDept) {
            Departamento d = new Departamento(nombre);
            DataStore.agregarDepartamento(d);
        }

        // Crear empleados permanentes
        for (int i = 0; i < 10; i++) {
            EmpleadoPermanente ep = new EmpleadoPermanente(
                "P" + (i + 1), 
                "NombreP" + (i + 1), 
                "ApellidoP" + (i + 1), 
                2500 + i * 100, 
                i % 5
            );
            Departamento dep = DataStore.departamentos[i % 5];
            dep.agregarEmpleado(ep);
            DataStore.agregarEmpleadoPermanente(ep);
        }

        // Crear empleados temporales
        for (int i = 0; i < 10; i++) {
            EmpleadoTemporal et = new EmpleadoTemporal(
                "T" + (i + 1), 
                "NombreT" + (i + 1), 
                "ApellidoT" + (i + 1), 
                3 + (i % 6), 
                15.5 + (i * 0.5)
            );
            Departamento dep = DataStore.departamentos[i % 5];
            dep.agregarEmpleado(et);
            DataStore.agregarEmpleadoTemporal(et);
        }

        // Crear reportes de desempeño
        for (EmpleadoPermanente ep : DataStore.empleadosPermanentes) {
            if (ep != null) {
                ReporteDesempeno rp = new ReporteDesempeno(
                    ep, 
                    "2025-Q1", 
                    Math.random() * 5, 
                    Math.random() * 5, 
                    Math.random() * 5
                );
                System.out.println(rp.generarResumen());
            }
        }

        for (EmpleadoTemporal et : DataStore.empleadosTemporales) {
            if (et != null) {
                ReporteDesempeno rp = new ReporteDesempeno(
                    et, 
                    "2025-Q1", 
                    Math.random() * 5, 
                    Math.random() * 5, 
                    Math.random() * 5
                );
                System.out.println(rp.generarResumen());
            }
        }

        System.out.println("Carga de datos temporales completada.");
    }
}
