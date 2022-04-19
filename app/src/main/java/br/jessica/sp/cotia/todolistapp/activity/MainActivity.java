package br.jessica.sp.cotia.todolistapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import br.jessica.sp.cotia.todolistapp.R;
import br.jessica.sp.cotia.todolistapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // instancia o binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        // define como contet view a view raiz(root) do binding
        setContentView(binding.getRoot());
    }
}