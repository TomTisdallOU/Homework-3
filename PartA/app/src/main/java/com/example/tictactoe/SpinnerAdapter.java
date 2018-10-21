package com.example.tictactoe;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

public class SpinnerAdapter extends ArrayAdapter {
    public SpinnerAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }
}
