package com.talmehahasaa.functioncalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.aEditText) EditText mEditTextA;
    @BindView(R.id.bEditText) EditText mEditTextB;
    @BindView(R.id.cEditText) EditText mEditTextC;
    @BindView(R.id.calculateButton) Button mCalculateButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mCalculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(mEditTextA.getText().toString());
                double b = Double.parseDouble(mEditTextB.getText().toString());
                double c = Double.parseDouble(mEditTextC.getText().toString());
                nextActivity(a, b, c);
            }
        });

    }
    private void nextActivity(double a, double b, double c) {
        Intent intent = new Intent(this, ResultsActivity.class);
        intent.putExtra("a", a);
        intent.putExtra("b", b);
        intent.putExtra("c", c);
        startActivity(intent);
    }
}
