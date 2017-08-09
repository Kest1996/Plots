package main;

import java.util.ArrayList;

public class RecMatrix implements Matrix {

    final int SIZE = 2;
    double[][][] matrix = new double[SIZE][SIZE][SIZE];
    ArrayList<Double> al;
    ArrayList<Integer> d;
    int lambda;

    public RecMatrix(ArrayList<Double> al, ArrayList<Integer> d, int lambda){
        this.al = al;
        this.d = d;
        this.lambda = lambda;
    }

    public double CalcMatrix(){
        AlGaAs alGaAs;
        E e = new E();
        MatrixXM matrixXM = new MatrixXM(1, 1, 0);
        matrixXM.MatrixXM(e.matrix(), e.matrix());
        for (int i = 0; i < al.size(); i++) {
            alGaAs = new AlGaAs(al.get(i), d.get(i), lambda);
            matrixXM.MatrixXM(matrixXM.matrix(), alGaAs.matrix());
        }
        return matrixXM.matrixR();

    }

    @Override
    public double[][][] matrix() {
        return matrix;
    }
}
