package com.example.entidades;

public class EmpleadoPermanente extends Empleado {
    private double salarioMensual;
    private int añosAntiguedad;

    public EmpleadoPermanente(String id, String nombre, String apellido, double salarioMensual, int añosAntiguedad) {
        super(id, nombre, apellido);
        this.salarioMensual = salarioMensual;
        this.añosAntiguedad = añosAntiguedad;
    }

    @Override
    public String getTipoEmpleado() {
        return "Empleado Permanente";
    }

    public double getSalarioMensual() {
        return salarioMensual;
    }

    public int getAñosAntiguedad() {
        return añosAntiguedad;
    }
}
