package com.example.g1c2movil.retrofit.model;

public class PersonalEmpresa {
    private Long idPersonal;

    private String cargo;


    private String abrev_titulo;

    private Empresa empresa;

    private Persona persona;


    public PersonalEmpresa() {

    }

    public Long getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(Long idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }


    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getAbrev_titulo() {
        return abrev_titulo;
    }

    public void setAbrev_titulo(String abrev_titulo) {
        this.abrev_titulo = abrev_titulo;
    }
}
