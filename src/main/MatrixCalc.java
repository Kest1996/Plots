package main;

public class MatrixCalc implements Matrix {

    final static int SIZE = 2;

    double[][][] m = new double[SIZE][SIZE][SIZE];

    public double[][][] AxB(double[][][] A, double[][][] B){
        m[0][0][0] = A[0][0][0] * B[0][0][0] - A[0][0][1] * B[0][0][1] - A[0][1][0] * B[1][0][0] + A[0][1][1] * B[1][0][1];
        m[0][1][0] = A[0][0][0] * B[0][1][0] - A[0][0][1] * B[0][1][1] + A[0][1][0] * B[1][1][0] - A[0][1][1] * B[1][1][1];
        m[1][0][0] = A[1][1][0] * B[1][0][0] - A[1][1][1] * B[1][0][1] + A[1][0][0] * B[0][0][0] - A[1][0][1] * B[0][0][1];
        m[1][1][0] = A[1][1][0] * B[1][1][0] - A[1][1][1] * B[1][1][1] - A[1][0][0] * B[0][1][0] + A[1][0][1] * B[0][1][1];
        m[0][0][1] = A[0][0][0] * B[0][0][1] + A[0][0][1] * B[0][0][0] - A[0][1][0] * B[1][0][1] - A[0][1][1] * B[1][0][0];
        m[0][1][1] = A[0][0][0] * B[0][1][1] + A[0][0][1] * B[0][1][0] + A[0][1][0] * B[1][1][1] + A[0][1][1] * B[1][1][0];
        m[1][0][1] = A[1][1][0] * B[1][0][1] + A[1][1][1] * B[1][0][0] + A[1][0][0] * B[0][0][1] + A[1][0][1] * B[0][0][0];
        m[1][1][1] = A[1][1][0] * B[1][1][1] + A[1][1][1] * B[1][1][0] - A[1][0][0] * B[0][1][1] - A[1][0][1] * B[0][1][0];
        return m;
    }

    @Override
    public double[][][] matrix() {
        return m;
    }
}
