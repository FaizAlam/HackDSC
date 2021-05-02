package com.example.hackdsc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class dashboard extends AppCompatActivity implements View.OnClickListener {

    public CardView card1, card2, card3, card4, card5, card6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashboard);

        card1 = (CardView) findViewById(R.id.cv1);
        card2 = (CardView) findViewById(R.id.cv2);
        card3 = (CardView) findViewById(R.id.cv3);
        card4 = (CardView) findViewById(R.id.cv4);
        card5 = (CardView) findViewById(R.id.cv5);
        card6 = (CardView) findViewById(R.id.cv6);

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
        card5.setOnClickListener(this);
        card6.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {

            case R.id.cv1 :
                i = new Intent(this, mentorship.class);
                startActivity(i);
                break;

            case R.id.cv2 :
                i = new Intent(this, scholarship.class);
                startActivity(i);
                break;

            case R.id.cv3 :
                i = new Intent(this, communities.class);
                startActivity(i);
                break;

            case R.id.cv4 :
                i = new Intent(this, workshops.class);
                startActivity(i);
                break;

            case R.id.cv5 :
                i = new Intent(this, events.class);
                startActivity(i);
                break;

            case R.id.cv6 :
                i = new Intent(this, opportunities.class);
                startActivity(i);
                break;

        }

    }
}