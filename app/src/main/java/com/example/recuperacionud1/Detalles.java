package com.example.recuperacionud1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.recuperacionud1.ui.main.DetallesFragment;

public class Detalles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, DetallesFragment.newInstance())
                    .commitNow();
        }
    }
}