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
//    @BindView(R.id.functionGraph) GraphView mFunctionGraph;
//    @BindView(R.id.functionGraph) LineChart mGraph;

    private double a;
    private double b;
    private double c;
    private double x1;
    private double x2;
    private double p;
    private double k;
//    private double x;
//    private double y;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        a = intent.getDoubleExtra("a", 1);
        b = intent.getDoubleExtra("b", 0);
        c = intent.getDoubleExtra("c", 0);

        calculate();

//        x = -500;
//
//        LineGraphSeries<DataPoint> series = new LineGraphSeries<>();
//        for (int i = 0; i < 1000; i++) {
//            x += 0.05;
//            y = a * Math.pow(x, 2) + b * x + c;
//            series.appendData(new DataPoint(x, y), true, 500);
//        }
//        mFunctionGraph.addSeries(series);
    }

    private void calculate() {
        double disc = (Math.pow(b, 2) - 4 * a * c);

        // Calculate x1 and x2
        if (disc > 0) {
            x1 = (-b + Math.sqrt(disc)) / (2*a);
            x2 = (-b - Math.sqrt(disc)) / (2*a);
        } else if (disc == 0) {
            x1 = (-b) / (2 * a);
            x2 = x1;
        } else {
            x1 = 738195.3905203;
            x2 = -0983423.220023552;
        }

        // Calculate p and k
        p = -b / (2*a);
        k = (4*a*c - Math.pow(b, 2)) / (4*a);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(x1);
        System.out.println(x2);
        System.out.println(p);
        System.out.println(k);

        format();
    }

    private void format() {

        double pp = Math.abs(p);
        double x1p = Math.abs(x1);
        double x2p = Math.abs(x2);

        // Format the decimal values
        DecimalFormat df = new DecimalFormat("###.###");
        String adf;
        if (a == 1) {
            adf = "";
        } else if (a == -1) {
            adf = "-";
        } else {
            adf = df.format(a);
        }
        String bdf = df.format(b);
        String cdf = df.format(c);
        String kdf = df.format(k);
        String pdf = df.format(pp);
        String x1df = df.format(x1p);
        String x2df = df.format(x2p);

        // Format standard form
        String af;
        if (a == 0) {
            af = "";
            adf = "";
        } else if (a == 1) {
            af = "x²";
        } else if (a == -1) {
            af = "-x²";
        } else if (a > 0) {
            af = adf + "x²";
        } else {
            af = "-" + adf + "x²";
        }

        String bf;
        if (b == 0) {
            bf = "";
        } else if (b == 1) {
            bf = "+x";
        } else if (b == -1) {
            bf = "-x";
        } else if (b > 0) {
            bf = "+" + bdf + "x";
        } else {
            bf = bdf + "x";
        }

        String cf;
        if (c == 0) {
            cf = "";
        } else if (c > 0) {
            cf = "+" + cdf;
        } else {
            cf = cdf;
        }

        String standardFunction = "f(x)=" + af + bf + cf;
        System.out.println(standardFunction);
        mStandardLabel.setText(standardFunction);

        // Format intercept form

        String interceptFunction = "f(x)=" + adf;
        String x1f;
        String x2f;
        if (x1 == 738195.3905203 && x2 == -0983423.220023552) {
            interceptFunction = "לא נחתך עם ציר האיקס";
        } else {
            if (x1 == 0 ^ x2 == 0) {
                x1f = "x(x";
                if (x1 > 0) {
                    x2f = "-" + x1df + ")";
                } else {
                    x2f = "+" + x1df + ")";
                }
                if (x2 > 0) {
                    x2f = "-" + x2df + ")";
                } else {
                    x2f = "+" + x2df + ")";
                }
            } else if (x1 == x2) {
                if (x1 > 0) {
                    x1f = "(x-" + x1df;
                } else {
                    x1f = "(x+" + x1df;
                }
                x2f = ")²";
            } else {
                x1f = "(x";
                x2f = ")(x";
                if (x1 > 0) {
                    x1f += "-" + x1df;
                } else {
                    x1f += "+" + x1df;
                }
                if (x2 > 0) {
                    x2f += "-" + x2df;
                } else {
                    x2f += "+" + x2df;
                }
                x2f += ")";
            }
            interceptFunction += x1f + x2f;
        }
        System.out.println(interceptFunction);
        mInterceptLabel.setText(interceptFunction);

        // Format vertex form

        String vertexFunction = "f(x)=" + adf;
        String pf;
        String kf;
        if (p == 0) {
            pf = "x²";
        } else if (p > 0) {
            pf = "(x-" + pdf + ")²";
        } else {
            pf = "(x+" + pdf + ")²";
        }
        if (k == 0) {
            kf = "";
        } else if (k > 0) {
            kf = "+" + kdf;
        } else {
            kf = kdf;
        }
        vertexFunction += pf + kf;
        System.out.println(vertexFunction);
        mVertexLabel.setText(vertexFunction);
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
