package br.jessica.sp.cotia.todolistapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.jessica.sp.cotia.todolistapp.R;
import br.jessica.sp.cotia.todolistapp.databinding.FragmentDetalheBinding;

public class FragmentDetalhe extends Fragment {
    private FragmentDetalheBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // instancia o binding
        binding = FragmentDetalheBinding.inflate(inflater, container, false);
        // retorna a view raiz do binding
        return binding.getRoot();
    }
}