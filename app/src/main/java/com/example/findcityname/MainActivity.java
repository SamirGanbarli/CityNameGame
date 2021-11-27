package com.example.findcityname;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtIntro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtIntro = (TextView) findViewById(R.id.txtIntro);
    }


    public void StartGame(View view) {
        Intent newIntent = new Intent(this, GamePlay.class);
        startActivity(newIntent);
    }

    public void ExitGame(View view) {
        finish();
        System.exit(0);
    }
}