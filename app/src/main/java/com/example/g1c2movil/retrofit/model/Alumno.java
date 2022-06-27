package com.example.g1c2movil.retrofit.model;

public class Alumno {

    private Long idAlumno;

    private String ciclo;

    private String paralelo;

    private double promedio;

    private Persona persona;

    private Carrera carrera;


    public Alumno() {
    }


    public Carrera getCarrera() {
        return carrera;
    }


    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }


    public Persona getPersona() {
        return persona;
    }


    public void setPersona(Persona persona) {
        this.persona = persona;
    }


    public Long getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Long idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getParalelo() {
        return paralelo;
    }

    public void setParalelo(String paralelo) {
        this.paralelo = paralelo;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }
}
