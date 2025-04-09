package com.example.entidades;

import java.util.ArrayList;
import java.util.List;

import com.example.Excepciones.EmpleadoInvalidoException;

public class Departamento {
    private String nombre;
    private List<Empleado> empleados;

    public Departamento(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void agregarEmpleado(Empleado empleado) throws EmpleadoInvalidoException {
        if (empleado == null) {
            throw new EmpleadoInvalidoException("El empleado no puede ser null.");
        }

        if (empleados.contains(empleado)) {
            throw new EmpleadoInvalidoException("El empleado ya está asignado a este departamento.");
        }
        
        if (!empleados.contains(empleado)) {
            empleados.add(empleado);
            empleado.asignarDepartamento(this);
        }
    }

    public void eliminarEmpleado(Empleado empleado) {
        if (empleados.contains(empleado)) {
            empleados.remove(empleado);
        }
    }
}

