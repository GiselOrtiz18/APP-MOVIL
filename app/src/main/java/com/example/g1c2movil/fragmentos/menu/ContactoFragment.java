package com.example.g1c2movil.fragmentos.menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.g1c2movil.databinding.FragmentContactoBinding;
import com.example.g1c2movil.fragmentos.base.BaseFragment;

public class ContactoFragment extends BaseFragment<FragmentContactoBinding> {

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected FragmentContactoBinding getViewBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentContactoBinding.inflate(inflater, container, false);
    }
}
