package main;

public class E implements Matrix {


    @Override
    public double[][][] matrix() {
        double[][][] E = new double[2][2][2];
        E[0][0][0] = 1;E[0][1][0] = 0;E[1][0][0] = 0;E[1][1][0] = 1;
        E[0][0][1] = 0;E[0][1][1] = 0;E[1][0][1] = 0;E[1][1][1] = 0;

        return E;
    }
}
