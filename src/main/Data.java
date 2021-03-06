package main;


import javafx.scene.chart.XYChart;

import java.util.ArrayList;

public class Data {

    public static final int MIN_LAMBDA = 650;
    public static final int MAX_LAMBDA = 1200;

    private final ArrayList<Double> alList = new ArrayList<>();
    private final ArrayList<Integer> dList = new ArrayList<>();
    private final ArrayList<Double> gaList = new ArrayList<>();
    private final ArrayList<AlGaAs> alGaAsList = new ArrayList<>();

    public final XYChart.Series series = new XYChart.Series();
    private static Data data;
    RecMatrix recMatrix;
    int p = 0;
    double d = 0;

    public static synchronized Data getInstance() {
        if (data == null) {
            data = new Data();
        }
        return data;
    }

    private Data() {
        for (int lambda = MIN_LAMBDA; lambda < MAX_LAMBDA; lambda++) {
            XYChart.Data<Integer, Integer> point = new XYChart.Data<>(lambda, 0);
            series.getData().add(lambda - MIN_LAMBDA, point);
        }
        series.setName("Y = R(λ)");
    }

    public void setKoefs(int position, double al, double ga, int d) {
        if (position >= alList.size()) {
            alList.add(al);
            dList.add(d);
            gaList.add(ga);
        } else {
            alList.set(position, al);
            dList.set(position, d);
            gaList.set(position, ga);
        }
        updateSeries();
    }

    private void updateSeries() {
        for (int lambda = MIN_LAMBDA; lambda < MAX_LAMBDA; lambda++) {
            XYChart.Data<Integer, Double> point = new XYChart.Data<>(lambda, getR(lambda));
            series.getData().set(lambda - MIN_LAMBDA, point);
        }
    }

    public double getR(int Lambda) {
        for (int i = 0; i < alList.size(); i++) {
            alGaAsList.add(new AlGaAs(alList.get(i), dList.get(i), Lambda));
        }

        E e = new E();

        MatrixX matrixX = new MatrixX();

        Reflektor reflektor = new Reflektor(1, alGaAsList.get(alGaAsList.size()-1).n(), 0);

        MatrixCalc matrixCalc = new MatrixCalc();

        matrixX.setM(matrixCalc.AxB(e.matrix(), e.matrix()));

        for (int i = 0; i < alGaAsList.size(); i++) {
            matrixX.setM(matrixCalc.AxB(matrixX.matrix(), alGaAsList.get(i).matrix()));
        }

        alGaAsList.clear();

        return reflektor.R(matrixX.matrix());
    }
}
