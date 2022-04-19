package br.jessica.sp.cotia.todolistapp.fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import java.util.Calendar;

import br.jessica.sp.cotia.todolistapp.databinding.FragmentCadTarefaBinding;

public class FragmentCadTarefa extends Fragment {
    private FragmentCadTarefaBinding binding;
    // variavel para datepicker
    DatePickerDialog datePicker;
    // variaveis para o dia mes e ano
    int year, month, day;
    // variavel para a data atual
    Calendar dataAtual;
    // variavel para a data formatada
    String dataEscolhida = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // instancia o binding
        binding = FragmentCadTarefaBinding.inflate(inflater, container, false);

        // instancia a data atual
        dataAtual = Calendar.getInstance();

        // descobre o dia, mes e ano atuais
        year = dataAtual.get(Calendar.YEAR);
        month = dataAtual.get(Calendar.MONTH);
        day = dataAtual.get(Calendar.DAY_OF_MONTH);

        // instanciar o datePicker
        datePicker = new DatePickerDialog(getContext(), (view, ano, mes, dia) -> {
            // cai aqui toda vex que clica mp ok do datepicker
        },year, month, day);

        // listener do botao de data
        binding.botaoData.setOnClickListener(V -> {
            // abre o datepicker
            datePicker.show();
        });

        // retorna a view raiz do binding
        return binding.getRoot();
    }
}