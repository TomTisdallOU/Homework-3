package edu.oakland.nbayagich.priceodometer;

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

public class PriceOdometer extends ConstraintLayout {
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


    public void setPriceValue(Float price) {
        this.priceValue = price;
    }

    private Float priceValue = 0.00f;

    public PriceOdometer(Context context) {
        super(context);
        init(null, 0);

    }

    public PriceOdometer(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);

        //Inflate the view
        LayoutInflater inflater = LayoutInflater.from(context);
        ConstraintLayout container = (ConstraintLayout) inflater.inflate(R.layout.price_odometer, this);

        priceValueText = container.findViewById(R.id.priceTextValue);
        String priceValueMinusSymbol = getOdoValue().substring(1, getOdoValue().length());
        priceValue = Float.parseFloat(priceValueMinusSymbol);
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

                if(oneCentButton.isSelected())
                {
                    Float oneCent = 0.01f;
                    priceValue = priceValue + oneCent;
                    priceValueText.setText("$" + String.format("%.2f", priceValue));

                }
                else if(fiveCentButton.isSelected())
                {

                    Float fiveCents = 0.05f;
                    priceValue = priceValue + fiveCents;
                    priceValueText.setText("$" + String.format("%.2f", priceValue));

                }
                else if(twentyFiveCentButton.isSelected())
                {

                    Float twentyFiveCents = 0.25f;
                    priceValue = priceValue + twentyFiveCents;
                    priceValueText.setText("$" + String.format("%.2f", priceValue));

                }
                else if(dollarButton.isSelected())
                {
                    Float dollar = 1.00f;
                    priceValue = priceValue + dollar;
                    priceValueText.setText("$" + String.format("%.2f", priceValue));

                }
                else if(fiveDollarButton.isSelected())
                {
                    Float fiveDollars = 5.00f;
                    priceValue = priceValue + fiveDollars;
                    priceValueText.setText("$" + String.format("%.2f", priceValue));
                }
            }
        });

        minusButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if(oneCentButton.isSelected())
                {
                    Float oneCent = 0.01f;
                    priceValue = priceValue - oneCent;
                    priceValueText.setText("$" + String.format("%.2f", priceValue));

                }
                else if(fiveCentButton.isSelected())
                {
                    Float fiveCents = 0.05f;
                    priceValue = priceValue - fiveCents;
                    priceValueText.setText("$" + String.format("%.2f", priceValue));
                }
                else if(twentyFiveCentButton.isSelected())
                {
                    Float twentyFiveCents = 0.25f;
                    priceValue = priceValue - twentyFiveCents;
                    priceValueText.setText("$" + String.format("%.2f", priceValue));

                }
                else if(dollarButton.isSelected())
                {
                    Float dollar = 1.00f;
                    priceValue = priceValue - dollar;
                    priceValueText.setText("$" + String.format("%.2f", priceValue));

                }
                else if(fiveDollarButton.isSelected())
                {
                    Float fiveDollars = 5.00f;
                    priceValue = priceValue - fiveDollars;
                    priceValueText.setText("$" + String.format("%.2f", priceValue));
                }
            }
        });


        oneCentButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                fiveCentButton.setSelected(false);
                twentyFiveCentButton.setSelected(false);
                dollarButton.setSelected(false);
                fiveDollarButton.setSelected(false);
                v.setSelected(true);
            }
        });

        fiveCentButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                oneCentButton.setSelected(false);
                twentyFiveCentButton.setSelected(false);
                dollarButton.setSelected(false);
                fiveDollarButton.setSelected(false);
                v.setSelected(true);
            }
        });

        twentyFiveCentButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                oneCentButton.setSelected(false);
                fiveCentButton.setSelected(false);
                dollarButton.setSelected(false);
                fiveDollarButton.setSelected(false);
                v.setSelected(true);
            }
        });

        dollarButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                oneCentButton.setSelected(false);
                twentyFiveCentButton.setSelected(false);
                fiveCentButton.setSelected(false);
                fiveDollarButton.setSelected(false);
                v.setSelected(true);
            }
        });

        fiveDollarButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                oneCentButton.setSelected(false);
                twentyFiveCentButton.setSelected(false);
                dollarButton.setSelected(false);
                fiveCentButton.setSelected(false);
                v.setSelected(true);
            }
        });
    }

    public PriceOdometer(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        // Load attributes
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.PriceOdometer, defStyle, 0);

        odoValue = a.getString(R.styleable.PriceOdometer_odoValue);
        odoColor = a.getColor(R.styleable.PriceOdometer_odoColor,Color.BLUE);
        odoHeight = a.getInt(R.styleable.PriceOdometer_odoHeight, (int)64);

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
