package br.jessica.sp.cotia.todolistapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.List;

import br.jessica.sp.cotia.todolistapp.R;
import br.jessica.sp.cotia.todolistapp.model.Tarefa;

public class TarefaAdapter extends RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder>{

    // lista de tarefas
    private List<Tarefa> tarefas;
    // variavel para o Context
    private Context context;

    // construtor para receber os valores
    public TarefaAdapter(List<Tarefa> Lista, Context contexto){
        this.tarefas = Lista;
        this.context = contexto;
    }

    @NonNull
    @Override
    public TarefaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // infla o leyout do adpter
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_tarefa, parent, false);
        // retorna um novo ViewHolder com a view
        return new TarefaViewHolder(view);
    }

    @Override
    // retorna todos os items da lista
    public void onBindViewHolder(@NonNull TarefaViewHolder holder, int position) {
        // obtém a tarefa pela position
        Tarefa t = tarefas.get(position);
        holder.tituloTv.setText(t.getTitulo());
        // se estiver concluida
        if (t.isConcluida()){
            holder.statusTv.setText("Concluída");
            holder.statusTv.setBackgroundColor(context.getResources().getColor(R.color.verde));
        }else{
            holder.statusTv.setText("Aberta");
            holder.statusTv.setBackgroundColor(context.getResources().getColor(R.color.amarelo));
        }
        // formata a data de long para String
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        holder.dataTv.setText(formatador.format(t.getDataPrevista()));
    }

    @Override
    // retorna 1 view
    // retorna a quantidade a serem exibidos na lista
    public int getItemCount() {
        if(tarefas != null){
            return tarefas.size();
        }
        return 0;
    }

    //classe ViewHolder para mapear os componentes do xml
    class TarefaViewHolder extends RecyclerView.ViewHolder{
        // variáveis para acessar os componentes do xml
        TextView tituloTv, dataTv, statusTv;

        public TarefaViewHolder(View view){
            // hama o construtor da superclasse
            super(view);
            // passar para as variaveis, os componentes do XML
            tituloTv = view.findViewById(R.id.titulo_tv);
            dataTv = view.findViewById(R.id.data_tv);
            statusTv = view.findViewById(R.id.status_tv);
        }
    }
}
