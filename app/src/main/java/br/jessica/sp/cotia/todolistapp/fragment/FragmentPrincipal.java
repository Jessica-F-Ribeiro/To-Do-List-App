package br.jessica.sp.cotia.todolistapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.jessica.sp.cotia.todolistapp.R;
import br.jessica.sp.cotia.todolistapp.adapter.TarefaAdapter;
import br.jessica.sp.cotia.todolistapp.database.AppDatabase;
import br.jessica.sp.cotia.todolistapp.databinding.FragmentPrincipalBinding;
import br.jessica.sp.cotia.todolistapp.model.Tarefa;

public class FragmentPrincipal extends Fragment {
    private FragmentPrincipalBinding binding;
    // variavel para a database
    private AppDatabase database;
    // variavel para o adapter;
    private TarefaAdapter adapter;
    // variavel para a lista
    private List<Tarefa> tarefas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // instancia o binding
        binding = FragmentPrincipalBinding.inflate(inflater, container, false);
        // clique no botao de adicionar tarefa
        binding.bntAddTarefa.setOnClickListener(v ->
                NavHostFragment.
                        findNavController(FragmentPrincipal.this).
                        navigate(R.id.action_fragmentPrincipal_to_fragmentCadTarefa));

        // retorna a view raiz do binding
        return binding.getRoot();
    }
}