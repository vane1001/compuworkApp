package com.example;

import com.example.entidades.*;

public class DataStore {
    public static EmpleadoPermanente[] empleadosPermanentes = new EmpleadoPermanente[10];
    public static EmpleadoTemporal[] empleadosTemporales = new EmpleadoTemporal[10];
    public static Departamento[] departamentos = new Departamento[5];

    public static int indexPermanente = 0;
    public static int indexTemporal = 0;
    public static int indexDepartamento = 0;

    public static void agregarEmpleadoPermanente(EmpleadoPermanente emp) {
        if (indexPermanente < empleadosPermanentes.length) {
            empleadosPermanentes[indexPermanente++] = emp;
        }
    }

    public static void agregarEmpleadoTemporal(EmpleadoTemporal emp) {
        if (indexTemporal < empleadosTemporales.length) {
            empleadosTemporales[indexTemporal++] = emp;
        }
    }

    public static void agregarDepartamento(Departamento dep) {
        if (indexDepartamento < departamentos.length) {
            departamentos[indexDepartamento++] = dep;
        }
    }
}
