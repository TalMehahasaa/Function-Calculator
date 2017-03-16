package com.talmehahasaa.functioncalculator;

import java.text.DecimalFormat;

class Function {

    private double a;
    private double b;
    private double c;
    private double x1;
    private double x2;
    private double p;
    private double k;
    private String mStandardFunction;
    private String mInterceptFunction;
    private String mVertexFunction;

    Function(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    void calculate() {
        double disc = (Math.pow(b, 2) - 4 * a * c);

        if (disc > 0) {
            x1 = (-b + Math.sqrt(disc)) / (2 * a);
            x2 = (-b - Math.sqrt(disc)) / (2 * a);
        } else if (disc == 0) {
            x1 = (-b) / (2 * a);
            x2 = x1;
        } else {
            x1 = 738195.3905203;
            x2 = -0983423.220023552;
        }

        p = -b / (2 * a);
        k = (4 * a * c - Math.pow(b, 2)) / (4 * a);

        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("c: " + c);
        System.out.println("x1: " + x1);
        System.out.println("x2: " + x2);
        System.out.println("p: " + p);
        System.out.println("k: " + k);
    }

    void format() {

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

        mStandardFunction = "f(x)=" + af + bf + cf;
        System.out.println(mStandardFunction);

        // Format intercept form

        mInterceptFunction = "f(x)=" + adf;
        String x1f;
        String x2f;
        if (x1 == 738195.3905203 && x2 == -0983423.220023552) {
            mInterceptFunction = "לא נחתך עם ציר האיקס";
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
            mInterceptFunction += x1f + x2f;
        }
        System.out.println(mInterceptFunction);

        // Format vertex form

        mVertexFunction = "f(x)=" + adf;
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
        mVertexFunction += pf + kf;
        System.out.println(mVertexFunction);
    }

    String getStandardFunction() {
        return mStandardFunction;
    }

    String getInterceptFunction() {
        return mInterceptFunction;
    }

    String getVertexFunction() {
        return mVertexFunction;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getX1() {
        return x1;
    }

    public double getX2() {
        return x2;
    }

    public double getP() {
        return p;
    }

    public double getK() {
        return k;
    }
}
