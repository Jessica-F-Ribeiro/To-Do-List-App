package br.jessica.sp.cotia.todolistapp.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import br.jessica.sp.cotia.todolistapp.model.Tarefa;

@Database(entities = {Tarefa.class}, version =  1)
// classe que junta a database e DAO
public abstract class AppDatabase extends RoomDatabase {
    // atributu para acessar a databse
    private static AppDatabase database;
    // atributo para tarefaDao
    public  abstract TarefaDao getTarefaDao();

    // metodo para acessar o atributo que acessa a database
    public  static AppDatabase getDatabase(Context context){
        // verifica se foi instanciada
        if (database == null){
            // instancia a database
            database = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "todolist").build();
        }
        // retorna a database
        return database;
    }
}
