package com.example.programinglanguages;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ProgramingLanguagesAdapter extends RecyclerView.Adapter<ProgramingLanguagesAdapter.ProgramingLanguagesHolder> {
    private final ArrayList<ProgramingLanguages> programingLanguagesList;
    private LayoutInflater inflater;
    private Context context;

    public ProgramingLanguagesAdapter(Context context,ArrayList<ProgramingLanguages> programingLanguagesList){
        inflater= LayoutInflater.from(context);
        this.programingLanguagesList=programingLanguagesList;
        this.context=context;
    }

    @Override
    public ProgramingLanguagesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item=inflater.inflate(R.layout.list_item,parent,false);
        return new ProgramingLanguagesHolder(item);
    }

    @Override
    public void onBindViewHolder(ProgramingLanguagesHolder holder, int position) {
        ProgramingLanguages currentItem=programingLanguagesList.get(position);
        int idImage = context.getResources().getIdentifier(currentItem.getImageResource(), "drawable", context.getPackageName());
        Glide.with(context).load(idImage).into(holder.image);
       holder.textTitle.setText(currentItem.getTitle());
    }

    @Override
    public int getItemCount() {
        return programingLanguagesList.size();
    }


    class ProgramingLanguagesHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView image;
        TextView textTitle;
        public ProgramingLanguagesHolder(View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.image_programing);
            textTitle=itemView.findViewById(R.id.title_language);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context, "Item pulsado", Toast.LENGTH_SHORT).show();
            //int position = getLayoutPosition();
            //ProgramingLanguages programingLanguage = programingLanguagesList.get(position);
            //Intent intent = new Intent(context, .class);
            //intent.putExtra("item", programingLanguage);
            //context.startActivity(intent);
        }
    }
}
