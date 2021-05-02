package com.example.hackdsc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;

public class mentorship extends AppCompatActivity {

    RecyclerView popularRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_mentorship);

        popularRecycler = findViewById(R.id.most_popular_recycler);

        popularRecycler();
    }

    private void popularRecycler() {

        popularRecycler.setHasFixedSize(true);
        popularRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));
    }
}