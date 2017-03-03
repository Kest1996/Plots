package main;

public class MatrixXM {

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

    private double AxB11(){
        return A.M11() * B.M11() - A.Mi11() * B.Mi11() - A.M12() * B.M21() + A.Mi12() * B.Mi21();
    }
    private double AxB12(){
        return A.M11() * B.M12() - A.Mi11() * B.Mi12() + A.M12() * B.M22() - A.Mi12() * B.Mi22();
    }
    private double AxB21(){
        return A.M22() * B.M21() - A.Mi22() * B.Mi21() + A.M21() * B.M11() - A.Mi21() * B.Mi11();
    }
    private double AxB22(){
        return A.M22() * B.M22() - A.Mi22() * B.Mi22() - A.M21() * B.M12() + A.Mi21() * B.Mi12();
    }
    private double AxBi11(){
        return A.M11() * B.Mi11() + A.Mi11() * B.M11() - A.M12() * B.Mi21() - A.Mi12() * B.M21();
    }
    private double AxBi12(){
        return A.M11() * B.Mi12() + A.Mi11() * B.M12() + A.M12() * B.Mi22() + A.Mi12() * B.M22();
    }
    private double AxBi21(){
        return A.M22() * B.Mi21() + A.Mi22() * B.M21() + A.M21() * B.Mi11() + A.Mi21() * B.M11();
    }
    private double AxBi22(){
        return A.M22() * B.Mi22() + A.Mi22() * B.M22() - A.M21() * B.Mi12() - A.Mi21() * B.M12();
    }

    public double R(){
        double V = n0 * AxB11() + AxBi21() - nl*(n0*AxBi12()+AxB22()) + kl*(n0*AxB12()-AxBi22());
        double Z = n0 * AxBi11() - AxB21() + nl*(n0*AxB12()-AxBi22()) + kl*(n0*AxBi12()+AxB22());
        double X = n0 * AxB11() - AxBi21() - nl*(n0*AxBi12()-AxB22()) + kl*(n0*AxB12()+AxBi22());
        double Y = n0 * AxBi11() + AxB21() + nl*(n0*AxB12()+AxBi22()) + kl*(n0*AxBi12()-AxB22());

        return (V*V+Z*Z)/(X*X+Y*Y);
    }
}
