package com.example.programinglanguages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recycle;
    private ArrayList<ProgramingLanguages> programingLanguagesList;
    private ProgramingLanguagesAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        programingLanguagesList=Data.getInstance().getProgramingLanguagesList();
        recycle=findViewById(R.id.recycle);
        adapter= new ProgramingLanguagesAdapter(this,programingLanguagesList);
        inicializarDatos();
        recycle.setAdapter(adapter);
        recycle.setLayoutManager(new LinearLayoutManager(this));
    }
    public void inicializarDatos(){
        Data.inicializarDatos();
        programingLanguagesList.clear();
        programingLanguagesList.addAll(Data.getInstance().getProgramingLanguagesList());
        adapter.notifyDataSetChanged();
    }
}