package com.example.g1c2movil.retrofit.model;

public class Docente {

    private Long idDocente;

    private String titulo;

    private String area;

    private String abrevTitulo;

    private Persona persona;

    private Carrera carrera;

    public Docente() {
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


    public Long getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(Long idDocente) {
        this.idDocente = idDocente;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAbrevTitulo() {
        return abrevTitulo;
    }

    public void setAbrevTitulo(String abrevTitulo) {
        this.abrevTitulo = abrevTitulo;
    }
}
