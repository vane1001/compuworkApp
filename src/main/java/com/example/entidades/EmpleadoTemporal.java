package com.example.entidades;

public class EmpleadoTemporal extends Empleado {
    private int mesesContrato;
    private double pagoPorHora;

    public EmpleadoTemporal(String id, String nombre, String apellido, int mesesContrato, double pagoPorHora) {
        super(id, nombre, apellido);
        this.mesesContrato = mesesContrato;
        this.pagoPorHora = pagoPorHora;
    }

    @Override
    public String getTipoEmpleado() {
        return "Empleado Temporal";
    }

    public int getMesesContrato() {
        return mesesContrato;
    }

    public double getPagoPorHora() {
        return pagoPorHora;
    }
}

