package com.example.g1c2movil.model;

public class ConvocatoriaSimple {
    private String nombre;
    private String responsable;
    private String carrera;
    private String idConvocatoria;
    private String empresa;
    private Boolean estado;
    private String actividad;

    public ConvocatoriaSimple(String nombre, String responsable, String carrera, String idConvocatoria, String empresa, Boolean estado, String actividad) {
        this.nombre = nombre;
        this.responsable = responsable;
        this.carrera = carrera;
        this.idConvocatoria = idConvocatoria;
        this.empresa = empresa;
        this.estado = estado;
        this.actividad = actividad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getIdConvocatoria() {
        return idConvocatoria;
    }

    public void setIdConvocatoria(String idConvocatoria) {
        this.idConvocatoria = idConvocatoria;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }
}
