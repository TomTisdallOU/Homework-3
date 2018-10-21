package com.example.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button playerButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerButton = findViewById(R.id.playersButton);

        playerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), player_form.class );
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                v.getContext().startActivity(intent);
                //TODO send name and icon back

            }
        });


    }

}
