package com.example.programinglanguages;

        import android.content.Intent;
        import android.os.Bundle;

        import com.google.android.material.appbar.CollapsingToolbarLayout;
        import com.google.android.material.floatingactionbutton.FloatingActionButton;
        import com.google.android.material.snackbar.Snackbar;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.appcompat.widget.Toolbar;

        import android.os.Handler;
        import android.os.Looper;
        import android.view.View;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.io.IOException;
        import java.util.concurrent.ExecutorService;
        import java.util.concurrent.Executors;

public class ProgramingLanguagesActivity extends AppCompatActivity {
    ImageView imageProgramingLanguage;
    TextView infoProgramingLanguage;
    ExecutorService ejecutor;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programing_languages);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        Intent intent=getIntent();
        ProgramingLanguages programingLanguages=(ProgramingLanguages) intent.getSerializableExtra("item");
        imageProgramingLanguage=findViewById(R.id.image_programingLanguage);
        int idImage = getResources().getIdentifier(programingLanguages.getImageResource(), "drawable", getPackageName());
        imageProgramingLanguage.setImageResource(idImage);
        toolBarLayout.setTitle(getString(programingLanguages.getTitle()));
        infoProgramingLanguage=findViewById(R.id.info_programinglanguage);
        infoProgramingLanguage.setText(getString(programingLanguages.getInfo()));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                final Sendinblue sendinblue=new Sendinblue();
                ejecutor.execute(new Runnable() {
                    @Override
                    public void run() {
                        //trabajo en segundo plano
                        try {
                            sendinblue.sendMessage();
                        } catch (IOException e) {
                            Toast.makeText(ProgramingLanguagesActivity.this,"error al enviar mensaje",Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                        }
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(ProgramingLanguagesActivity.this,"Mensaje enviado",Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });

            }
        });

        ejecutor = Executors.newSingleThreadExecutor();
        handler = new Handler(Looper.getMainLooper());
    }
}