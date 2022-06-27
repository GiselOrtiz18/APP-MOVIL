package com.example.g1c2movil.retrofit.model;

import java.util.Date;

public class SolicitudAlumno {

    private Long idSolicitudAlumno;

    private Date fechaEmision;

    private String estado;

    private String documentoSoliEstudiante;

    private Convocatoria convocatoria;

    private Alumno alumno;

    private int horasPPP;

    public SolicitudAlumno() {
    }

    public String getDocumentoSoliEstudiante() {
        return documentoSoliEstudiante;
    }

    public void setDocumentoSoliEstudiante(String documentoSoliEstudiante) {
        this.documentoSoliEstudiante = documentoSoliEstudiante;
    }

    public String getEstado() {
        return estado;
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }


    public Long getIdSolicitudAlumno() {
        return idSolicitudAlumno;
    }

    public void setIdSolicitudAlumno(Long idSolicitudAlumno) {
        this.idSolicitudAlumno = idSolicitudAlumno;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Convocatoria getConvocatoria() {
        return convocatoria;
    }

    public void setConvocatoria(Convocatoria convocatoria) {
        this.convocatoria = convocatoria;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public int getHorasPPP() {
        return horasPPP;
    }

    public void setHorasPPP(int horasPPP) {
        this.horasPPP = horasPPP;
    }
}
