package com.example.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class game_board extends AppCompatActivity {
    int currentPlayer = 0;
    Player[] players = new Player[2];
    TextView turnLabel = null;
    TTTButton[] tttButton = new TTTButton[9];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_board);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                //title= null;
            } else {
                players[0] = new Player(extras.getString("Player 1 Name"), extras.getInt("Player 1 Symbol",0));
                players[1] = new Player(extras.getString("Player 2 Name"), extras.getInt("Player 2 Symbol",0));

            }
        } else {
        //    title = (String) savedInstanceState.getSerializable("Title");
        }

        //TODO Implement game board logic
        //TODO create custom button to track symbol and location
        //TODO use GameBoard.java for reference
        turnLabel = findViewById(R.id.turnLabel);
        turnLabel.setText();

    }
}
