package com.example.tictactoe;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class game_board extends AppCompatActivity {
    int currentPlayer = 0;
    Player[] players = new Player[2];
    TextView turnLabel = null;
    TTTButton[] tttButton = new TTTButton[9];

    private static final int[] BUTTON_IDS = {
            R.id.TTTButton1,
            R.id.TTTButton2,
            R.id.TTTButton3,
            R.id.TTTButton4,
            R.id.TTTButton5,
            R.id.TTTButton6,
            R.id.TTTButton7,
            R.id.TTTButton8,
            R.id.TTTButton9,
    };



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

    TTTButton.OnClickListener myMouse =  new TTTButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                TTTButton myButton = findViewById(v.getId());
                int i = myButton.getButtonPosition();
                players[currentPlayer].MarkCell(i);
                tttButton[i].setButtonImage(players[currentPlayer].getSymbol());
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

        for (int i = 0; i < 9; i++) {

            tttButton[i] = (TTTButton) findViewById(BUTTON_IDS[i]);
            tttButton[i].setButtonPosition(i);
            tttButton[i].setOnClickListener(myMouse);
     /*       tttButton[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TTTButton myButton = findViewById(v.getId());
                    myButton.setBackgroundResource(players[0].getSymbol());
                }
            }); */


        //TODO register player with the button
                players[0].register(tttButton[i],i);
                players[1].register(tttButton[i],i);
        }

    }
}
