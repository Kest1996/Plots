package main;

/**
 * Created by Lvbnhbq on 03.03.2017.
 */
public class AlGaAs implements Matrix {

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
    public double M11() {
        return Math.cos(fi(d, n())) * ch(fi(d, k()));
    }

    @Override
    public double M12() {
        return (n() * Math.sin(fi(d, n())) * ch(fi(d, k())) + k() * Math.cos(fi(d, n())) * sh(fi(d, k()))) / (n() * n() + k() * k());
    }

    @Override
    public double M21() {
        return n() * Math.sin(fi(d, n())) * ch(fi(d, k())) - k() * Math.cos(fi(d, n())) * sh(fi(d, k()));
    }

    @Override
    public double M22() {
        return Math.cos(fi(d, n())) * ch(fi(d, k()));
    }

    @Override
    public double Mi11() {
        return Math.sin(fi(d, n())) * sh(fi(d, k()));
    }

    @Override
    public double Mi12() {
        return (k() * Math.sin(fi(d, n())) * ch(fi(d, k())) - n() * Math.cos(fi(d, n())) * sh(fi(d, k()))) / (n() * n() + k() * k());
    }

    @Override
    public double Mi21() {
        return -k() * Math.sin(fi(d, n())) * ch(fi(d, k())) - n() * Math.cos(fi(d, n())) * sh(fi(d, k()));
    }

    @Override
    public double Mi22() {
        return Math.sin(fi(d, n())) * sh(fi(d, k()));
    }
}
