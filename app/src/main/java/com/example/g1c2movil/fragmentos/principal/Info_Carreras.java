package com.example.g1c2movil.fragmentos.principal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.g1c2movil.databinding.FragmentInfoCarrerasBinding;
import com.example.g1c2movil.fragmentos.base.BaseFragment;
import com.example.g1c2movil.retrofit.Api;
import com.example.g1c2movil.retrofit.model.Carrera;
import com.example.g1c2movil.retrofit.model.RespuestaGenerica;
import com.example.g1c2movil.retrofit.service.UsuarioService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Info_Carreras extends BaseFragment<FragmentInfoCarrerasBinding> {

    private UsuarioService servicioApi;

    Spinner spCarrera;
    TextView abreviatura, nombre, modalidad, duracion;

    private List<Carrera> carreraList;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        spCarrera = getBinding().spCarrera;
        abreviatura = getBinding().textView16;
        nombre = getBinding().textView15;
        modalidad = getBinding().textView17;
        duracion = getBinding().textView18;

        //Hacemos la conexion a la api
        servicioApi = Api.getUsuarioService();

        carreraList = new ArrayList<>();

        obtenerCarreras();

        spCarrera.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (carreraList != null && !carreraList.isEmpty()) {
                    Carrera item = carreraList.get(position);

                    abreviatura.setText("Abreviatura: " + item.getAbreviatura());
                    nombre.setText("Nombre Carrera: " + item.getNombre());
                    modalidad.setText("Modalidad: " + item.getModalidad());
                    duracion.setText("Duración: " + item.getDuracion());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void obtenerCarreras() {
        Call<RespuestaGenerica<Carrera>> convocatoriaCall = servicioApi.getCarreras();
        convocatoriaCall.enqueue(new Callback<RespuestaGenerica<Carrera>>() {

            @Override
            public void onResponse(Call<RespuestaGenerica<Carrera>> call, Response<RespuestaGenerica<Carrera>> response) {
                if (!response.body().getData().isEmpty()) {

                    carreraList = response.body().getData();

                    //lista de elementos del spinner
                    List<String> nombreCarreras = new ArrayList<>();

                    for (Carrera carrera : carreraList) {
                        nombreCarreras.add(carrera.getNombre());
                    }

                    spCarrera.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, nombreCarreras));
                }
            }

            @Override
            public void onFailure(Call<RespuestaGenerica<Carrera>> call, Throwable t) {
                toast(t.getMessage());
            }
        });
    }

    @Override
    protected FragmentInfoCarrerasBinding getViewBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentInfoCarrerasBinding.inflate(inflater, container, false);
    }

}