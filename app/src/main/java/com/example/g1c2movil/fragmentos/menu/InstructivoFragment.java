package com.example.g1c2movil.fragmentos.menu;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.g1c2movil.adaptador.InstructivoAdaptador;
import com.example.g1c2movil.adaptador.InstructivosAdaptador;
import com.example.g1c2movil.databinding.FragmentInstructivoBinding;
import com.example.g1c2movil.fragmentos.base.BaseFragment;
import com.example.g1c2movil.retrofit.Api;
import com.example.g1c2movil.retrofit.model.ActaDeReunion;
import com.example.g1c2movil.retrofit.model.RespuestaGenerica;
import com.example.g1c2movil.retrofit.service.UsuarioService;
import com.example.g1c2movil.utils.FileHelper;
import com.example.g1c2movil.utils.SesionPrefs;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InstructivoFragment extends BaseFragment<FragmentInstructivoBinding> {

    private UsuarioService servicioApi;

    private InstructivoAdaptador adapter;
    private RecyclerView rvInstructivo;
    private ProgressBar pbInstructivo;

    List<ActaDeReunion> actaDeReunionList;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pbInstructivo = getBinding().pbInstructivo;
        rvInstructivo = getBinding().rvInstructivo;
        rvInstructivo.setHasFixedSize(true);

        //Hacemos la conexion a la api
        servicioApi = Api.getUsuarioService();

        pbInstructivo.setVisibility(View.VISIBLE);

        obtenerConvocatorias();

        adapter.setClickListener(new InstructivoAdaptador.onItemClickListener() {
            @Override
            public void onItemClick(View view, String file) {
                getFile(file);
            }
        });
    }


    private void obtenerConvocatorias() {

        String user = SesionPrefs.get(requireActivity()).getUsername();

        Call<RespuestaGenerica<ActaDeReunion>> convocatoriaCall = servicioApi.getActasReunion();
        convocatoriaCall.enqueue(new Callback<RespuestaGenerica<ActaDeReunion>>() {

            @Override
            public void onResponse(Call<RespuestaGenerica<ActaDeReunion>> call, Response<RespuestaGenerica<ActaDeReunion>> response) {

                RespuestaGenerica<ActaDeReunion> responseFromAPI = response.body();

                if (!responseFromAPI.getData().isEmpty()) {

                    actaDeReunionList = new ArrayList<>();

                    for (ActaDeReunion actaDeReunion : responseFromAPI.getData()) {
                        Log.d("", actaDeReunion.getDocActaReunion());
                        if (user.equals(actaDeReunion.getAlumno().getPersona().getCedula())) {
                            actaDeReunionList.add(actaDeReunion);
                        }
                    }
                    if (!actaDeReunionList.isEmpty()) {
                        adapter = new InstructivoAdaptador(actaDeReunionList);
                        rvInstructivo.setAdapter(adapter);

                    } else {
                        toast("Sin documentos, por favor intente más tarde.");
                    }
                }
                pbInstructivo.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<RespuestaGenerica<ActaDeReunion>> call, Throwable t) {
                toast("Error: " + t.getMessage());
                pbInstructivo.setVisibility(View.GONE);
            }
        });
    }

    private void getFile(String filename) {
        Call<ResponseBody> convocatoriaCall = servicioApi.getFile(filename);
        convocatoriaCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                if (response.isSuccessful()) {
                    toast("Conectando al servidor..");

                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Uri uri = FileHelper.saveFile(response.body(), filename, applicationContext());
                                openPDF(uri.toString());
                            } catch (Exception e) {
                                Log.d("FileDownload", e.getMessage());
                            }
                        }
                    });
                    thread.start();

                } else {
                    toast("El documento no fue encontrado.");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                toast("Error: 2 ->" + t.getMessage());
            }
        });
    }

    private void openPDF(String uri) {

        Intent target = new Intent(Intent.ACTION_VIEW);
        target.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        target.setDataAndType(Uri.parse(uri), "application/pdf");
        target.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

        Intent intent = Intent.createChooser(target, "Open File");
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            // Instruct the user to install a PDF reader here, or something
        }
    }

    @Override
    protected FragmentInstructivoBinding getViewBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentInstructivoBinding.inflate(inflater, container, false);
    }

}