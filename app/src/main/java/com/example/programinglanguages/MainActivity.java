package com.example.programinglanguages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collections;

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

        /*int columnas = getResources().getInteger(R.integer.grid_column_count);
        //dependiendo del número de columnas deshabilito el deslizamiento (swipeDirs)
        int swipeDirs;
        if(columnas > 1){
            swipeDirs = 0;
        }else{
            swipeDirs = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        }
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT |
                ItemTouchHelper.DOWN | ItemTouchHelper.UP, swipeDirs) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();
                Collections.swap(programingLanguagesList, from, to);
                adapter.notifyItemMoved(from, to);
                return true;
            }

            @Override
            public void onSwiped( RecyclerView.ViewHolder viewHolder, int direction) {
                programingLanguagesList.remove(viewHolder.getAdapterPosition());
                adapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });

        helper.attachToRecyclerView(recycle);*/
    }
    public void inicializarDatos(){
        Data.inicializarDatos();
        programingLanguagesList.clear();
        programingLanguagesList.addAll(Data.getInstance().getProgramingLanguagesList());
        adapter.notifyDataSetChanged();
    }
}