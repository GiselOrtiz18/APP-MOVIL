package com.example.g1c2movil.retrofit.model;

import java.util.List;

public class RespuestaAuth {

    private String token;
    private String bearer;
    private String username;
    private List<Authority> authorities;

    public RespuestaAuth(String token, String bearer, String username, List<Authority> authorities) {
        this.token = token;
        this.bearer = bearer;
        this.username = username;
        this.authorities = authorities;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBearer() {
        return bearer;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }
}