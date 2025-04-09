package com.example.entidades;

import com.example.Excepciones.ReporteInvalidoException;

public class ReporteDesempeno {
    private Empleado empleado;
    private String periodo;
    private double eficiencia;
    private double puntualidad;
    private double trabajoEnEquipo;

    public ReporteDesempeno(Empleado empleado, String periodo, double eficiencia, double puntualidad, double trabajoEnEquipo) throws ReporteInvalidoException {
         if (empleado == null) {
            throw new ReporteInvalidoException("No se puede generar un reporte para un empleado nulo.");
        }

        if (eficiencia < 0 || eficiencia > 10 || puntualidad < 0 || puntualidad > 10 || trabajoEnEquipo < 0 || trabajoEnEquipo > 10) {
            throw new ReporteInvalidoException("Las métricas deben estar entre 0 y 10.");
        }

        this.empleado = empleado;
        this.periodo = periodo;
        this.eficiencia = eficiencia;
        this.puntualidad = puntualidad;
        this.trabajoEnEquipo = trabajoEnEquipo;
    }

    public double calcularPromedioDesempeno() {
        return (eficiencia + puntualidad + trabajoEnEquipo) / 3;
    }

    public String generarResumen() {
        return "Reporte de Desempeño - " + empleado + "\n" +
               "Periodo: " + periodo + "\n" +
               "Eficiencia: " + eficiencia + "\n" +
               "Puntualidad: " + puntualidad + "\n" +
               "Trabajo en equipo: " + trabajoEnEquipo + "\n" +
               "Promedio General: " + String.format("%.2f", calcularPromedioDesempeno());
    }
}

