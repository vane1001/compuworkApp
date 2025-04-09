package com.example.entidades;

public abstract class Empleado {
    protected String id;
    protected String nombre;
    protected String apellido;
    protected Departamento departamento;

    public Empleado(String id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public abstract String getTipoEmpleado();

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void asignarDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    
    @Override
    public String toString() {
        return getTipoEmpleado() + ": " + nombre + " " + apellido + " (ID: " + id + ")";
    }
}