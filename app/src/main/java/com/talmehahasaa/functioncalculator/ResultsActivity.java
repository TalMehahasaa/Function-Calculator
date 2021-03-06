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

//    LineGraphSeries<DataPoint> series;
//    double x, y, k, p;

    @BindView(R.id.function) TextView mStandardLabel;
    @BindView(R.id.interceptFunction) TextView mInterceptLabel;
    @BindView(R.id.vertexFunction) TextView mVertexLabel;
//    @BindView(R.id.functionGraph) GraphView mGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        double a = intent.getDoubleExtra("a", 1);
        double b = intent.getDoubleExtra("b", 0);
        double c = intent.getDoubleExtra("c", 0);

        Function function = new Function(a, b, c);
        function.calculate();
        function.format();

//        series = new LineGraphSeries<>();
//        k = function.getK();
//        p = function.getP();
//        for (x = k - 100; x <= k + 100; x+=0.1) {
//            y = a*(x-p)*(x-p)+k;
//            series.appendData(new DataPoint(x, y), true, (int) (k + 200)*10);
//        }
//        mGraph.addSeries(series);

        mStandardLabel.setText(function.getStandardFunction());
        mInterceptLabel.setText(function.getInterceptFunction());
        mVertexLabel.setText(function.getVertexFunction());
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
