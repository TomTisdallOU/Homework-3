package com.example.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class game_board extends AppCompatActivity {
    int currentPlayer = 0;
    Player[] players;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_board);



    }
}
