package main;

public class Reflektor {
    private double n0, nl;
    private double kl;

    public Reflektor(double n0, double nl, double kl){
        this.n0 = n0;
        this.nl = nl;
        this.kl = kl;
    }

    public double R(double[][][] m){

        double V = n0 * m[0][0][0] + m[1][0][1] - nl * (n0 * m[0][1][1] + m[1][1][0]) + kl * (n0 * m[0][1][0] - m[1][1][1]);
        double Z = n0 * m[0][0][1] - m[1][0][0] + nl * (n0 * m[0][1][0] - m[1][1][1]) + kl * (n0 * m[0][1][1] + m[1][1][0]);
        double X = n0 * m[0][0][0] - m[1][0][1] - nl * (n0 * m[0][1][1] - m[1][1][0]) + kl * (n0 * m[0][1][0] + m[1][1][1]);
        double Y = n0 * m[0][0][1] + m[1][0][0] + nl * (n0 * m[0][1][0] + m[1][1][1]) + kl * (n0 * m[0][1][1] - m[1][1][0]);

        return (V * V + Z * Z) / (X * X + Y * Y);
    }
}
