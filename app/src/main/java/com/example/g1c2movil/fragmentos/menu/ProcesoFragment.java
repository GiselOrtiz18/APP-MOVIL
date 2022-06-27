package com.example.g1c2movil.fragmentos.menu;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.g1c2movil.adaptador.ProcesosAdaptador;
import com.example.g1c2movil.databinding.FragmentProcesoBinding;
import com.example.g1c2movil.fragmentos.base.BaseFragment;
import com.example.g1c2movil.retrofit.Api;
import com.example.g1c2movil.retrofit.model.RespuestaGenerica;
import com.example.g1c2movil.retrofit.model.SolicitudAlumno;
import com.example.g1c2movil.retrofit.service.UsuarioService;
import com.example.g1c2movil.utils.SesionPrefs;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ProcesoFragment extends BaseFragment<FragmentProcesoBinding> {

    private List<SolicitudAlumno> listaCompleta;
    private List<SolicitudAlumno> listaAceptados;
    private List<SolicitudAlumno> listaNegados;
    private List<SolicitudAlumno> listaPendientes;

    private String username;

    private UsuarioService servicioApi;

    private ProcesosAdaptador adapter;
    private RecyclerView rvProcesos;
    private ProgressBar pbProcesos;
    private TabLayout tabLayout;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tabLayout = getBinding().tabLayout;
        pbProcesos = getBinding().pbProcesos;
        rvProcesos = getBinding().rvProcesos;
        rvProcesos.setHasFixedSize(true);

        username = SesionPrefs.get(requireActivity()).getUsername();

        //Hacemos la conexion a la api
        servicioApi = Api.getUsuarioService();

        listaAceptados = new ArrayList<>();
        listaPendientes = new ArrayList<>();
        listaNegados = new ArrayList<>();

        pbProcesos.setVisibility(View.VISIBLE);

        adapter = new ProcesosAdaptador();
        rvProcesos.setAdapter(adapter);

        obtenerProcesos();


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                String idString = tab.getText().toString();

                switch (idString) {
                    case "PENDIENTE":
                        adapter.differ.submitList(listaPendientes);
                        break;
                    case "ACEPTADA":
                        adapter.differ.submitList(listaAceptados);
                        break;
                    case "DENEGADA":
                        adapter.differ.submitList(listaNegados);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void obtenerProcesos() {
        Call<RespuestaGenerica<SolicitudAlumno>> convocatoriaCall = servicioApi.getSolicitudesAlumnos();
        convocatoriaCall.enqueue(new Callback<RespuestaGenerica<SolicitudAlumno>>() {

            @Override
            public void onResponse(Call<RespuestaGenerica<SolicitudAlumno>> call, Response<RespuestaGenerica<SolicitudAlumno>> response) {

                RespuestaGenerica<SolicitudAlumno> responseFromAPI = response.body();

                if (!responseFromAPI.getData().isEmpty()) {
                    listaCompleta = responseFromAPI.getData();

                    for (SolicitudAlumno solicitudAlumno : listaCompleta) {

                        if (solicitudAlumno.getAlumno().getPersona().getCedula().equals(username)) {
                            switch (solicitudAlumno.getEstado().toUpperCase()) {

                                case "PENDIENTE":
                                    listaPendientes.add(solicitudAlumno);
                                    break;
                                case "ACEPTADA":
                                    listaAceptados.add(solicitudAlumno);
                                    break;
                                case "DENEGADA":
                                    listaNegados.add(solicitudAlumno);
                                    break;
                            }
                        }
                    }

                }

                pbProcesos.setVisibility(View.GONE);
                adapter.differ.submitList(listaPendientes);
            }

            @Override
            public void onFailure(Call<RespuestaGenerica<SolicitudAlumno>> call, Throwable t) {
                toast("Error: " + t.getMessage());
                pbProcesos.setVisibility(View.GONE);
            }
        });
    }

    @Override
    protected FragmentProcesoBinding getViewBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentProcesoBinding.inflate(inflater, container, false);
    }
}