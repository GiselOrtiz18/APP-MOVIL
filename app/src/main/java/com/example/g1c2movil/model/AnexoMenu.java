package com.example.g1c2movil.model;

public class AnexoMenu {

    private String titulo;
    private String file;

    public AnexoMenu(String titulo, String file) {
        this.titulo = titulo;
        this.file = file;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
