package edu.oakland.nbayagich.odometer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.zip.Inflater;

/**
 * TODO: document your custom view class.
 */
public class Odometer extends ConstraintLayout {
    private String odoValue;            // TODO: use a default from R.string...
    private int odoColor = Color.RED;   // TODO: use a default from R.color...

    public String getOdoValue() {
        return odoValue;
    }

    public void setOdoValue(String odoValue) {
        this.odoValue = odoValue;
    }

    public int getOdoColor() {
        return odoColor;
    }

    public void setOdoColor(int odoColor) {
        this.odoColor = odoColor;
    }

    public int getOdoHeight() {
        return odoHeight;
    }

    public void setOdoHeight(int odoHeight) {
        this.odoHeight = odoHeight;
    }

    private int odoHeight = 0;          // TODO: use a default from R.dimen...

    TextView odoText = null;
    Button plusButton = null;
    Button minusButton = null;

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    private int odometer = 0;

    public Odometer(Context context) {
        super(context);
        init(null, 0);
    }

    public Odometer(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);

        //Inflate the view
        LayoutInflater inflater = LayoutInflater.from(context);
        ConstraintLayout container = (ConstraintLayout) inflater.inflate(R.layout.sample_odometer, this);

        odoText = container.findViewById(R.id.odomTextValue);
        odometer = Integer.parseInt((getOdoValue()));
        odoText.setText(getOdoValue());
        plusButton = container.findViewById(R.id.plusButton);
        minusButton = container.findViewById(R.id.minusButton);

        plusButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                odoText.setText(Integer.toString((++odometer)));
            }
        });

        minusButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                odoText.setText(Integer.toString((--odometer)));

            }
        });

    }

    public Odometer(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        // Load attributes
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.Odometer, defStyle, 0);

        odoValue = a.getString(R.styleable.Odometer_odoValue);
        odoColor = a.getColor(R.styleable.Odometer_odoColor,Color.BLUE);
        odoHeight = a.getInt(R.styleable.Odometer_odoHeight, (int)64);

        a.recycle();

    }


}
