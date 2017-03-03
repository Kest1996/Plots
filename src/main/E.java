package main;

public class E implements Matrix {
    @Override
    public double M11() {
        return 1;
    }

    @Override
    public double M12() {
        return 0;
    }

    @Override
    public double M21() {
        return 0;
    }

    @Override
    public double M22() {
        return 1;
    }

    @Override
    public double Mi11() {
        return 0;
    }

    @Override
    public double Mi12() {
        return 0;
    }

    @Override
    public double Mi21() {
        return 0;
    }

    @Override
    public double Mi22() {
        return 0;
    }
}
