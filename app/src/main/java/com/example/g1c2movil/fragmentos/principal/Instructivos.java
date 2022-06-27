package com.example.g1c2movil.fragmentos.principal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.g1c2movil.adaptador.InstructivosAdaptador;
import com.example.g1c2movil.databinding.FragmentInstructivosBinding;
import com.example.g1c2movil.fragmentos.base.BaseFragment;
import com.example.g1c2movil.model.AnexoMenu;
import com.example.g1c2movil.retrofit.Api;
import com.example.g1c2movil.retrofit.service.UsuarioService;
import com.example.g1c2movil.utils.FileHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Instructivos extends BaseFragment<FragmentInstructivosBinding> {

    List<AnexoMenu> anexosList;

    private UsuarioService servicioApi;

    private InstructivosAdaptador adapter;
    private RecyclerView rvInstructivos;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvInstructivos = getBinding().rvInstructivos;
        rvInstructivos.setHasFixedSize(true);

        //Hacemos la conexion a la api
        servicioApi = Api.getUsuarioService();

        agregarLista();

        adapter = new InstructivosAdaptador(anexosList);
        rvInstructivos.setAdapter(adapter);

        adapter.setClickListener(new InstructivosAdaptador.onItemClickListener() {
            @Override
            public void onItemClick(View view, String file) {
                getFile(file);
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
                    toast("Error en la conexion, intente más tarde.");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                toast("Error: 2 ->" + t.getMessage());
            }
        });
    }


    private void agregarLista() {
        anexosList = new ArrayList<AnexoMenu>();

        anexosList.add(new AnexoMenu("Anexo 1", "ANEXO 1.pdf"));
        anexosList.add(new AnexoMenu("Anexo 2", "ANEXO 2.pdf"));
        anexosList.add(new AnexoMenu("Anexo 3", "ANEXO 3.pdf"));
        anexosList.add(new AnexoMenu("Anexo 3.1", "ANEXO 3.1.pdf"));
        anexosList.add(new AnexoMenu("Anexo 4", "ANEXO 4.pdf"));
        anexosList.add(new AnexoMenu("Anexo 5", "ANEXO 5.pdf"));
        anexosList.add(new AnexoMenu("Anexo 6", "ANEXO 6.pdf"));
        anexosList.add(new AnexoMenu("Anexo 7", "ANEXO 7.pdf"));
        anexosList.add(new AnexoMenu("Anexo 8", "ANEXO 8.pdf"));
        anexosList.add(new AnexoMenu("Anexo 8.1", "ANEXO 8.1.pdf"));
        anexosList.add(new AnexoMenu("Anexo 9", "ANEXO 9.pdf"));
        anexosList.add(new AnexoMenu("Anexo 10", "ANEXO 10.pdf"));
        anexosList.add(new AnexoMenu("Anexo 11", "ANEXO 11.pdf"));
        anexosList.add(new AnexoMenu("Anexo 12", "ANEXO 12.pdf"));
        anexosList.add(new AnexoMenu("Anexo 13", "ANEXO 13.pdf"));
        anexosList.add(new AnexoMenu("Anexo 14", "ANEXO 14.pdf"));
        anexosList.add(new AnexoMenu("Anexo 15", "ANEXO 15.pdf"));
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
    protected FragmentInstructivosBinding getViewBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentInstructivosBinding.inflate(inflater, container, false);
    }
}