package com.example.g1c2movil.retrofit.model;

import java.util.Date;

public class Convocatoria {
    private Long idConvocatoria;

    private String nombreConvocatoria;

    private Date fechaEmision;

    private Date fechaMaxima;

    private boolean estado;

    //Anexo 2
    private String docConvocatoria;

    private SolicitudEmpresa solicitudEmpresa;

    public Convocatoria() {
    }


    public Long getIdConvocatoria() {
        return idConvocatoria;
    }

    public void setIdConvocatoria(Long idConvocatoria) {
        this.idConvocatoria = idConvocatoria;
    }

    public String getNombreConvocatoria() {
        return nombreConvocatoria;
    }

    public void setNombreConvocatoria(String nombreConvocatoria) {
        this.nombreConvocatoria = nombreConvocatoria;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaMaxima() {
        return fechaMaxima;
    }

    public void setFechaMaxima(Date fechaMaxima) {
        this.fechaMaxima = fechaMaxima;
    }

    public String getDocConvocatoria() {
        return docConvocatoria;
    }

    public void setDocConvocatoria(String docConvocatoria) {
        this.docConvocatoria = docConvocatoria;
    }

    public SolicitudEmpresa getSolicitudEmpresa() {
        return solicitudEmpresa;
    }

    public void setSolicitudEmpresa(SolicitudEmpresa solicitudEmpresa) {
        this.solicitudEmpresa = solicitudEmpresa;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
