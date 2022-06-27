package com.example.g1c2movil.retrofit.model;

public class Authority {

    private RolAuthority authority;

    public Authority(RolAuthority authority) {
        this.authority = authority;
    }

    public RolAuthority getAuthority() {
        return authority;
    }

    public void setAuthority(RolAuthority authority) {
        this.authority = authority;
    }

    public enum RolAuthority {
        ROLE_ADMIN,
        ROLE_ESTUDIANTE,
        ROLE_DOCENTE,
        ROLE_TUTORACADEMICO,
        ROLE_TUTOREMPRESARIAL,
        ROLE_RESPONSABLEPPP,
        ROLE_EMPLEADO
    }
}


