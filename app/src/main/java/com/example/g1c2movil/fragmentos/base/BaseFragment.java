package com.example.g1c2movil.fragmentos.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;

//funciones comunes entre fargmentos
public abstract class BaseFragment<VB extends ViewBinding> extends Fragment {

    // recibe la view enviada desde el fragment para ser procesado por esta clase
    private VB _binding = null;

    // Retorna los elementos existentes en la view del fragment
    // con ello ya no es necesario inicializar los elementos
    protected VB getBinding() {
        return _binding;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        _binding = getViewBinding(inflater, container);
        return getBinding().getRoot();
    }

    // infla la view del fragment
    protected abstract VB getViewBinding(LayoutInflater inflater, ViewGroup container);

    //muestra un toast corto
    public void toast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    //retorna el contexto de la aplicacin
    public Context applicationContext() {
        return requireActivity().getApplicationContext();
    }

    //Cunado se destruye el fragmento, limpia la view
    @Override
    public void onDestroy() {
        super.onDestroy();
        _binding = null;
    }
}
