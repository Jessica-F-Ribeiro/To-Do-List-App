package br.jessica.sp.cotia.todolistapp.fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

import br.jessica.sp.cotia.todolistapp.database.AppDatabase;
import br.jessica.sp.cotia.todolistapp.databinding.FragmentCadTarefaBinding;
import br.jessica.sp.cotia.todolistapp.model.Tarefa;

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
    // variavel para acessar a database
    AppDatabase database;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // instanciar a database
        database = AppDatabase.getDatabase(getActivity());

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
            // cai aqui toda vez que clica no ok do datepicker
            // passa para as variaveis globais
            year = ano;
            month = mes;
            day = dia;

            // formatar a string da dataEscolhida
            dataEscolhida = String.format("%02d/%02d/%04d", day, month + 1, year); // sem o +1 ele pega o mes anterior, ao inves de do atual
            // jogar a String no botão
            binding.botaoData.setText(dataEscolhida);
        },year, month, day);

        // listener do botao de data
        binding.botaoData.setOnClickListener(V -> {
            // abre o datepicker
            datePicker.show();
        });

        // listener do botao salvar
        binding.salvar.setOnClickListener(v -> {
            // validar os campos
            if (binding.edTitulo.getText().toString().isEmpty()){
                binding.edTitulo.setError("Informe o Título");
                binding.edTitulo.requestFocus();
            }else if (binding.descricao.getText().toString().isEmpty()){
                binding.descricao.setError("Informe a Descrição");
            }else if (dataEscolhida.isEmpty()){
                Toast.makeText(getContext(), "Informe a Data", Toast.LENGTH_SHORT).show();
            }else {
                // criar um objeto tarefa
                Tarefa tarefa = new Tarefa();
                // popular a tarefa
                tarefa.setTitulo(binding.edTitulo.getText().toString());
                tarefa.setDescricao(binding.descricao.getText().toString());
                // criar um calendar e popula com a data que foi selecionada
                Calendar dataRealizacao = Calendar.getInstance();
                dataRealizacao.set(year, month, day);
                // passar para a tarefa os milessegundos da data
                tarefa.setDataPrevista(dataRealizacao.getTimeInMillis());
                // criar outro calendar para a dataAtual
                Calendar dataAtual = Calendar.getInstance();
                tarefa.setDataCriacao(dataAtual.getTimeInMillis());
                // salvar a tarefa no BD
                database.getTarefaDao().insert(tarefa);
            }
        });
        // retorna a view raiz do binding
        return binding.getRoot();
    }
}