package com.example.g1c2movil.retrofit.model;

import java.util.Date;

public class Convenio {

    private Long idConvenio;

    private Date fechaEmision;

    private int duracion;

    private String documento;

    private PersonalEmpresa gerente;

    private ResponsablePPP responsablePPP;

    public Convenio() {
    }

    public Long getIdConvenio() {
        return idConvenio;
    }

    public void setIdConvenio(Long idConvenio) {
        this.idConvenio = idConvenio;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public PersonalEmpresa getGerente() {
        return gerente;
    }

    public void setGerente(PersonalEmpresa gerente) {
        this.gerente = gerente;
    }

    public ResponsablePPP getResponsablePPP() {
        return responsablePPP;
    }

    public void setResponsablePPP(ResponsablePPP responsablePPP) {
        this.responsablePPP = responsablePPP;
    }

}
