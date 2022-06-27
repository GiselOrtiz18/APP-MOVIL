package com.example.g1c2movil.retrofit;

import com.example.g1c2movil.retrofit.service.UsuarioService;

public class Api {

    public static final String URL = "https://backendg1c2.herokuapp.com:443";

    public static UsuarioService getUsuarioService() {
        return RetrofitCliente.getCliente(URL).create(UsuarioService.class);
    }

}
