package main;

public class MatrixX {

    final static int SIZE = 2;
    double[][][] m = new double[SIZE][SIZE][SIZE];

    public void setM(double[][][] A){
        m[0][0][0] = A[0][0][0];
        m[0][1][0] = A[0][1][0];
        m[1][0][0] = A[1][0][0];
        m[1][1][0] = A[1][1][0];

        m[0][0][1] = A[0][0][1];
        m[0][1][1] = A[0][1][1];
        m[1][0][1] = A[1][0][1];
        m[1][1][1] = A[1][1][1];
    }

    public double[][][] matrix(){
        return m;
    }
}
