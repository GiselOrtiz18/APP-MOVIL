package com.example.g1c2movil.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.example.g1c2movil.retrofit.model.Authority;
import com.example.g1c2movil.retrofit.model.RespuestaAuth;

import java.util.ArrayList;
import java.util.List;

//Clase que guarda la sesion en SharedPrefences
public class SesionPrefs {

    private static SesionPrefs INSTANCE;

    // Nombre  claves preferences
    public static final String PREFS_NAME = "PREFS_AUTH";
    public static final String PREF_AUTH_USERNAME = "PREF_USERNAME";
    public static final String PREF_AUTH_ROL = "PREF_ROL";
    public static final String PREF_AUTH_TOKEN = "PREF_AUTH_TOKEN";

    //instancia de SharedPreferences
    private SharedPreferences _prefs;

    //Etiqueta para saber si el usuario inicio sesion
    private boolean _isLogged = false;
    private String _username = "";

    public static SesionPrefs get(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new SesionPrefs(context);
        }
        return INSTANCE;
    }

    private SesionPrefs() {

    }

    private SesionPrefs(Context context) {
        _prefs = context.getApplicationContext()
                .getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        _isLogged = !TextUtils.isEmpty(_prefs.getString(PREF_AUTH_TOKEN, null));
        _username = _prefs.getString(PREF_AUTH_USERNAME, null);
    }

    public boolean isLogged() {
        return _isLogged;
    }

    public String getUsername() {
        return _username;
    }

    public void saveAuth(RespuestaAuth respuestaAuth) {
        if (respuestaAuth != null) {
            List<Authority> authority = new ArrayList<Authority>(respuestaAuth.getAuthorities());
            SharedPreferences.Editor editor = _prefs.edit();
            editor.putString(PREF_AUTH_USERNAME, respuestaAuth.getUsername());
            if (!authority.isEmpty())
                editor.putString(PREF_AUTH_ROL, authority.get(0).getAuthority().name());
            editor.putString(PREF_AUTH_TOKEN, respuestaAuth.getToken());
            editor.apply();

            _isLogged = true;
        }
    }

    public void logOut() {
        _isLogged = false;
        SharedPreferences.Editor editor = _prefs.edit();
        editor.putString(PREF_AUTH_USERNAME, null);
        editor.putString(PREF_AUTH_ROL, null);
        editor.putString(PREF_AUTH_TOKEN, null);
        editor.apply();
    }
}
