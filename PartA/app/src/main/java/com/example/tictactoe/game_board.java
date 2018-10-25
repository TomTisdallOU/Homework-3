package com.example.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

        View.OnClickListener myMouse =  new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TTTButton myButton = findViewById(v.getId());
                int i = myButton.getButtonPosition();
                players[currentPlayer].MarkCell(i);
                if (players[currentPlayer].winner()) {
                    turnLabel.setText("Winner Winner Chicken Dinner!!!!!!!");

                }

                //TODO if current = 0 set to 1 else 0  -- try figuring out the remainder to track  # moves
                if (currentPlayer == 1) {
                    currentPlayer = 0;
                } else {
                    currentPlayer = 1;
                }
            }
        };

        //TODO Implement game board logic
        //TODO create custom button to track symbol and location
        //TODO use GameBoard.java for reference
        turnLabel = findViewById(R.id.turnLabel);
        turnLabel.setText(players[0].getName() + " your turn!");

        tttButton[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
