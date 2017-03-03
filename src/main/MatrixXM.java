package main;

public class MatrixXM implements Matrix {

    private Matrix A;
    private Matrix B;
    private double n0, nl;
    private double kl;

    public MatrixXM(Matrix A, Matrix B, double n0, double nl, double kl){
        this.A = A;
        this.B = B;
        this.n0 = n0;
        this.nl = nl;
        this.kl = kl;
    }

    @Override
    public double M11() {
        return A.M11() * B.M11() - A.Mi11() * B.Mi11() - A.M12() * B.M21() + A.Mi12() * B.Mi21();
    }

    @Override
    public double M12() {
        return A.M11() * B.M12() - A.Mi11() * B.Mi12() + A.M12() * B.M22() - A.Mi12() * B.Mi22();
    }

    @Override
    public double M21() {
        return A.M22() * B.M21() - A.Mi22() * B.Mi21() + A.M21() * B.M11() - A.Mi21() * B.Mi11();
    }

    @Override
    public double M22() {
        return A.M22() * B.M22() - A.Mi22() * B.Mi22() - A.M21() * B.M12() + A.Mi21() * B.Mi12();
    }

    @Override
    public double Mi11() {
        return A.M11() * B.Mi11() + A.Mi11() * B.M11() - A.M12() * B.Mi21() - A.Mi12() * B.M21();
    }

    @Override
    public double Mi12() {
        return A.M11() * B.Mi12() + A.Mi11() * B.M12() + A.M12() * B.Mi22() + A.Mi12() * B.M22();
    }

    @Override
    public double Mi21() {
        return A.M22() * B.Mi21() + A.Mi22() * B.M21() + A.M21() * B.Mi11() + A.Mi21() * B.M11();
    }

    @Override
    public double Mi22() {
        return A.M22() * B.Mi22() + A.Mi22() * B.M22() - A.M21() * B.Mi12() - A.Mi21() * B.M12();
    }

    public double R(){
        double V = n0 * M11() + Mi21() - nl*(n0*Mi12()+M22()) + kl*(n0*M12()-Mi22());
        double Z = n0 * Mi11() - M21() + nl*(n0*M12()-Mi22()) + kl*(n0*Mi12()+M22());
        double X = n0 * M11() - Mi21() - nl*(n0*Mi12()-M22()) + kl*(n0*M12()+Mi22());
        double Y = n0 * Mi11() + M21() + nl*(n0*M12()+Mi22()) + kl*(n0*Mi12()-M22());

        return (V*V+Z*Z)/(X*X+Y*Y);
    }
}
