package com.example.g1c2movil.fragmentos.principal;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.g1c2movil.adaptador.ConvocatoriaAdaptador;
import com.example.g1c2movil.databinding.FragmentConsultaConvBinding;
import com.example.g1c2movil.fragmentos.base.BaseFragment;
import com.example.g1c2movil.model.ConvocatoriaSimple;
import com.example.g1c2movil.retrofit.Api;
import com.example.g1c2movil.retrofit.model.Actividades;
import com.example.g1c2movil.retrofit.model.Convocatoria;
import com.example.g1c2movil.retrofit.model.Persona;
import com.example.g1c2movil.retrofit.model.RespuestaGenerica;
import com.example.g1c2movil.retrofit.model.SolicitudEmpresa;
import com.example.g1c2movil.retrofit.service.UsuarioService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Consulta_Conv extends BaseFragment<FragmentConsultaConvBinding> {

    //interface del servicio retrofit
    private UsuarioService servicioApi;

    private ConvocatoriaAdaptador adapter;

    private RecyclerView rvConvocatorias;
    private ProgressBar pbConvocatorias;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Hacemos la conexion a la api
        servicioApi = Api.getUsuarioService();

        pbConvocatorias = getBinding().pbConvocatorias;
        rvConvocatorias = getBinding().rvConvocatorias;
        rvConvocatorias.setHasFixedSize(true);

        pbConvocatorias.setVisibility(View.VISIBLE);

     obtenerConvocatorias();
    }


    private void obtenerConvocatorias() {
        Call<RespuestaGenerica<Convocatoria>> convocatoriaCall = servicioApi.getConvocatorias();
        convocatoriaCall.enqueue(new Callback<RespuestaGenerica<Convocatoria>>() {

            @Override
            public void onResponse(Call<RespuestaGenerica<Convocatoria>> call, Response<RespuestaGenerica<Convocatoria>> response) {

                RespuestaGenerica<Convocatoria> responseFromAPI = response.body();

                toast(responseFromAPI.getMensaje());

                if (!responseFromAPI.getData().isEmpty()) {
                    adapter = new ConvocatoriaAdaptador(responseFromAPI.getData());
                    rvConvocatorias.setAdapter(adapter);
                } else {
                    toast("Sin convocatorias, por favor vuelve a intentar más tarde.");
                }
                pbConvocatorias.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<RespuestaGenerica<Convocatoria>> call, Throwable t) {
                toast("Error: " + t.getMessage());
                pbConvocatorias.setVisibility(View.GONE);
            }
        });
    }


    @Override
    protected FragmentConsultaConvBinding getViewBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentConsultaConvBinding.inflate(inflater, container, false);
    }


}