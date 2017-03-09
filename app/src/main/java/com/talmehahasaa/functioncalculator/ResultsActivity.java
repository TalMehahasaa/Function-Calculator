package com.talmehahasaa.functioncalculator;

import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResultsActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.function) TextView mStandardLabel;
    @BindView(R.id.interceptFunction) TextView mInterceptLabel;
    @BindView(R.id.vertexFunction) TextView mVertexLabel;

    private double a;
    private double b;
    private double c;
    private Function mFunction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        a = intent.getDoubleExtra("a", 1);
        b = intent.getDoubleExtra("b", 0);
        c = intent.getDoubleExtra("c", 0);

        mFunction = new Function(a, b, c);
        mFunction.calculate();
        mFunction.format();
        mStandardLabel.setText(mFunction.getStandardFunction());
        mInterceptLabel.setText(mFunction.getInterceptFunction());
        mVertexLabel.setText(mFunction.getVertexFunction());
    }

    /*
    f(x) = ax²+bx+c
    f(x) = a(x-x1)(x-x2)
    f(x) = a(x-p)²+k

     xf = final formatting
     xdf = decimal formatting (###.#)
     xp = positive
     */
}
