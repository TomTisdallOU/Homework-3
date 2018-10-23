package edu.oakland.nbayagich.odometer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

    TextView priceValueText = null;
    Button plusButton = null;
    Button minusButton = null;
    Button oneCentButton = null;
    Button fiveCentButton = null;
    Button twentyFiveCentButton = null;
    Button dollarButton = null;
    Button fiveDollarButton = null;


    public void setPriceValue(int price) {
        this.priceValue = price;
    }

    private double priceValue = 0;

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

        priceValueText = container.findViewById(R.id.priceTextValue);
        String priceValueMinusSymbol = getOdoValue().substring(1, getOdoValue().length() - 1);
        final double priceValue = Double.parseDouble(priceValueMinusSymbol);
        priceValueText.setText(getOdoValue());
        plusButton = container.findViewById(R.id.plusButton);
        minusButton = container.findViewById(R.id.minusButton);
        oneCentButton = container.findViewById(R.id.oneCentButton);
        fiveCentButton = container.findViewById(R.id.fiveCentButton);
        twentyFiveCentButton = container.findViewById(R.id.twentyFiveCentButton);
        dollarButton = container.findViewById(R.id.dollarButton);
        fiveDollarButton = container.findViewById(R.id.fiveDollarButton);


        plusButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable roundedRectFillDrawable = ContextCompat.getDrawable(v.getContext(), R.drawable.rounded_rect_fill);

                if(oneCentButton.getBackground() == roundedRectFillDrawable)
                {
                    double oneCent = 0.01;
                    double result = priceValue + oneCent;
                    priceValueText.setText("$" + String.format("%.2f", result));

                }
                else if(fiveCentButton.getBackground() == roundedRectFillDrawable)
                {

                    double fiveCents = 0.05;
                    double result = priceValue + fiveCents;
                    priceValueText.setText("$" + String.format("%.2f", result));

                }
                else if(twentyFiveCentButton.getBackground() == roundedRectFillDrawable)
                {

                    double twentyFiveCents = 0.25;
                    double result = priceValue + twentyFiveCents;
                    priceValueText.setText("$" + String.format("%.2f", result));

                }
                else if(dollarButton.getBackground() == roundedRectFillDrawable)
                {
                    double dollar = 1.00;
                    double result = priceValue + dollar;
                    priceValueText.setText("$" + String.format("%.2f", result));

                }
                else if(fiveDollarButton.getBackground() == roundedRectFillDrawable)
                {
                    double fiveDollar = 5.00;
                    double result = priceValue + fiveDollar;
                    priceValueText.setText("$" + String.format("%.2f", result));
                }
            }
        });

        minusButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable roundedRectFillDrawable = ContextCompat.getDrawable(v.getContext(), R.drawable.rounded_rect_fill);

                if(oneCentButton.getBackground() == roundedRectFillDrawable)
                {
                    double oneCent = 0.01;
                    double result = priceValue - oneCent;
                    priceValueText.setText("$" + String.format("%.2f", result));

                }
                else if(fiveCentButton.getBackground() == roundedRectFillDrawable)
                {

                    double fiveCents = 0.05;
                    double result = priceValue - fiveCents;
                    priceValueText.setText("$" + String.format("%.2f", result));
                }
                else if(twentyFiveCentButton.getBackground() == roundedRectFillDrawable)
                {

                    double twentyFiveCents = 0.25;
                    double result = priceValue - twentyFiveCents;
                    priceValueText.setText("$" + String.format("%.2f", result));

                }
                else if(dollarButton.getBackground() == roundedRectFillDrawable)
                {
                    double dollar = 1.00;
                    double result = priceValue - dollar;
                    priceValueText.setText("$" + String.format("%.2f", result));

                }
                else if(fiveDollarButton.getBackground() == roundedRectFillDrawable)
                {
                    double fiveDollar = 5.00;
                    double result = priceValue - fiveDollar;
                    priceValueText.setText("$" + String.format("%.2f", result));
                }
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

        Drawable circleDrawable = ContextCompat.getDrawable(getContext(), R.drawable.circle);
        if(circleDrawable instanceof ShapeDrawable)
        {
            ShapeDrawable drawableShape = (ShapeDrawable) circleDrawable;
            drawableShape.getPaint().setColor(odoColor);
        }
        else if(circleDrawable instanceof GradientDrawable)
        {
            GradientDrawable gd = (GradientDrawable) circleDrawable;
            gd.setColor(odoColor);
        }

        circleDrawable.setBounds(0, 0, odoHeight, odoHeight);

        a.recycle();

    }


}
