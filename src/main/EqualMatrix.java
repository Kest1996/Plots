package main;

import java.util.ArrayList;

public class EqualMatrix {

    ArrayList<Double> alList;
    ArrayList<Integer> dList;
    AlGaAs alGaAs;
    MatrixCalc matrixCalc = new MatrixCalc(1, 3, 0);
    int lamx;
    E e = new E();

    public EqualMatrix(ArrayList<Double> alList, ArrayList<Integer> dList){
        this.alList = alList;
        this.dList = dList;
    }

    public void equalMatrix(){

        for (int i = 1; i < alList.size(); i++) {
            alGaAs = new AlGaAs(alList.get(i), dList.get(i), lamx);
//            matrixCalc.MatrixXM()
        }
    }

}
