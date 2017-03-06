package main;

public class AlGaAs implements Matrix {
    final static int SIZE = 2;

    private double lamx;
    private double x;
    private double d;

    public AlGaAs (double x, double d, double lamx) {
        this.x = x;
        this.d = d;
        this.lamx = lamx;
    }

    private double ch(double x) {
        return (Math.exp(x)+Math.exp(-x))/2;
    }

    private double sh(double x) {
        return (Math.exp(x)-Math.exp(-x))/2;
    }

    private double n(){
        double E0 = 3.65 + 0.871 * x + 0.179 * x * x;
        double Ed = 36.1 - 2.45 * x;
        double E = 1239.85/lamx;
        return Math.sqrt((E0 * Ed) / (E0 * E0 - E * E) + 1);
    }

    private double k(){
        return 0;
    }

    private double fi(double d, double k){
        return (2*Math.PI*k*d)/lamx;
    }

    @Override
    public double[][][] matrix() {
        double[][][] m = new double[SIZE][SIZE][SIZE];
            m[0][0][0] = Math.cos(fi(d, n())) * ch(fi(d, k()));
            m[0][1][0] = (n() * Math.sin(fi(d, n())) * ch(fi(d, k())) + k() * Math.cos(fi(d, n())) * sh(fi(d, k()))) / (n() * n() + k() * k());
            m[1][0][0] = n() * Math.sin(fi(d, n())) * ch(fi(d, k())) - k() * Math.cos(fi(d, n())) * sh(fi(d, k()));
            m[1][1][0] = Math.cos(fi(d, n())) * ch(fi(d, k()));
            m[0][0][1] = Math.sin(fi(d, n())) * sh(fi(d, k()));
            m[0][1][1] = (k() * Math.sin(fi(d, n())) * ch(fi(d, k())) - n() * Math.cos(fi(d, n())) * sh(fi(d, k()))) / (n() * n() + k() * k());
            m[1][0][1] = -k() * Math.sin(fi(d, n())) * ch(fi(d, k())) - n() * Math.cos(fi(d, n())) * sh(fi(d, k()));
            m[1][1][1] = Math.sin(fi(d, n())) * sh(fi(d, k()));
        return m;
    }
}