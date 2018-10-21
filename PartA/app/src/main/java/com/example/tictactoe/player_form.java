package com.example.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class player_form extends AppCompatActivity {
    TextView playerNumber = null;
    EditText nameText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_form);
        playerNumber = findViewById(R.id.playerNumber);
        nameText = findViewById(R.id.nameText);

        String title = null;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                title= null;
            } else {
                title= extras.getString("Title");
            }
        } else {
            title = (String) savedInstanceState.getSerializable("Title");
        }

        playerNumber.setText(title);
        nameText.setText(title);







    }

    @Override
    protected void onNewIntent(Intent intent){
        String title = null;

        if(intent.hasExtra("Title")) {
            title = intent.getStringExtra("Title");
        }
        playerNumber.setText(title);
    }
}



