package com.example.g1c2movil.retrofit.model;

import java.util.Date;

public class SolicitudEmpresa {

    private Long idSolicitudEmpresa;

    private Date fechaEmision;

    private Date fechaInicio;

    private Integer numeroAlumnos;

    //Anexo 1
    private String pdfSolicitud;

    // Anexos 3.1 y 4
    private String respuesta;

    private boolean estado;

    private PersonalEmpresa empleado;

    private ResponsablePPP responsablePPP;

    private Carrera carrera;

    public SolicitudEmpresa() {
    }

    public Long getIdSolicitudEmpresa() {
        return idSolicitudEmpresa;
    }

    public void setIdSolicitudEmpresa(Long idSolicitudEmpresa) {
        this.idSolicitudEmpresa = idSolicitudEmpresa;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Integer getNumeroAlumnos() {
        return numeroAlumnos;
    }

    public void setNumeroAlumnos(Integer numeroAlumnos) {
        this.numeroAlumnos = numeroAlumnos;
    }

    public String getPdfSolicitud() {
        return pdfSolicitud;
    }

    public void setPdfSolicitud(String pdfSolicitud) {
        this.pdfSolicitud = pdfSolicitud;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }


    public PersonalEmpresa getEmpleado() {
        return empleado;
    }

    public void setEmpleado(PersonalEmpresa empleado) {
        this.empleado = empleado;
    }

    public ResponsablePPP getResponsablePPP() {
        return responsablePPP;
    }

    public void setResponsablePPP(ResponsablePPP responsablePPP) {
        this.responsablePPP = responsablePPP;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
}
