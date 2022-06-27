package com.example.g1c2movil.fragmentos.menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.g1c2movil.adaptador.Convocatorias2Adaptador;
import com.example.g1c2movil.databinding.FragmentConvocatoriaBinding;
import com.example.g1c2movil.fragmentos.base.BaseFragment;
import com.example.g1c2movil.retrofit.Api;
import com.example.g1c2movil.retrofit.model.Convocatoria;
import com.example.g1c2movil.retrofit.model.RespuestaGenerica;
import com.example.g1c2movil.retrofit.service.UsuarioService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConvocatoriaFragment extends BaseFragment<FragmentConvocatoriaBinding> {

    private UsuarioService servicioApi;

    private Convocatorias2Adaptador adapter;
    private RecyclerView rvConvocatorias;
    private ProgressBar pbConvocatorias;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pbConvocatorias = getBinding().pbConvocatoria2;
        rvConvocatorias = getBinding().rvConvocatoria2;
        rvConvocatorias.setHasFixedSize(true);

        //Hacemos la conexion a la api
        servicioApi = Api.getUsuarioService();

        pbConvocatorias.setVisibility(View.VISIBLE);

        obtenerConvocatorias();
    }

    private void obtenerConvocatorias() {
        Call<RespuestaGenerica<Convocatoria>> convocatoriaCall = servicioApi.getConvocatorias();
        convocatoriaCall.enqueue(new Callback<RespuestaGenerica<Convocatoria>>() {

            @Override
            public void onResponse(Call<RespuestaGenerica<Convocatoria>> call, Response<RespuestaGenerica<Convocatoria>> response) {

                RespuestaGenerica<Convocatoria> responseFromAPI = response.body();

                if (!responseFromAPI.getData().isEmpty()) {

                    adapter = new Convocatorias2Adaptador(responseFromAPI.getData());
                    rvConvocatorias.setAdapter(adapter);
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
    protected FragmentConvocatoriaBinding getViewBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentConvocatoriaBinding.inflate(inflater, container, false);
    }

}