package com.example.g1c2movil.retrofit.model;

import java.util.Date;

public class ActaDeReunion {


    private Long idActaReunion;

    private Date fechaEmision;

    private Date fechaInicioPPP;

    private Date fechaFinPPP;

    private String horario;

    //Anexo 7
    private String docActaReunion;

    //Anexo 8
    private String respuestaEstudiante;

    //Anexo 8.1
    private String notificacionTA;

    private Alumno alumno;

    public ActaDeReunion() {
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Long getIdActaReunion() {
        return idActaReunion;
    }

    public void setIdActaReunion(Long idActaReunion) {
        this.idActaReunion = idActaReunion;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaInicioPPP() {
        return fechaInicioPPP;
    }

    public void setFechaInicioPPP(Date fechaInicioPPP) {
        this.fechaInicioPPP = fechaInicioPPP;
    }

    public Date getFechaFinPPP() {
        return fechaFinPPP;
    }

    public void setFechaFinPPP(Date fechaFinPPP) {
        this.fechaFinPPP = fechaFinPPP;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getDocActaReunion() {
        return docActaReunion;
    }

    public void setDocActaReunion(String docActaReunion) {
        this.docActaReunion = docActaReunion;
    }

    public String getRespuestaEstudiante() {
        return respuestaEstudiante;
    }

    public void setRespuestaEstudiante(String respuestaEstudiante) {
        this.respuestaEstudiante = respuestaEstudiante;
    }

    public String getNotificacionTA() {
        return notificacionTA;
    }

    public void setNotificacionTA(String notificacionTA) {
        this.notificacionTA = notificacionTA;
    }

}
