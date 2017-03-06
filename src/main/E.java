package main;

public class E implements Matrix {
    final static int SIZE = 2;

    @Override
    public double[][][] matrix() {
        double[][][] m = new double[SIZE][SIZE][SIZE];
            m[0][0][0] = 1;
            m[0][1][0] = 0;
            m[1][0][0] = 0;
            m[1][1][0] = 1;
            m[0][0][1] = 0;
            m[0][1][1] = 0;
            m[1][0][1] = 0;
            m[1][1][1] = 0;
        return m;
    }
}
