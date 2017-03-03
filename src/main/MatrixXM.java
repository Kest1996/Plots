package main;

public class MatrixXM {

        private Matrix A;
        private Matrix B;

        public MatrixXM(Matrix A, Matrix B){
            this.A = A;
            this.B = B;
        }

        double[][][] AxB(){

            double[][][] axb = new double[2][2][2];
                axb[0][0][0] = A.M11() * B.M11() - A.Mi11() * B.Mi11() - A.M12() * B.M21() + A.Mi12() * B.Mi21();
                axb[0][1][0] = A.M11() * B.M12() - A.Mi11() * B.Mi12() + A.M12() * B.M22() - A.Mi12() * B.Mi22();
                axb[1][0][0] = A.M22() * B.M21() - A.Mi22() * B.Mi21() + A.M21() * B.M11() - A.Mi21() * B.Mi11();
                axb[1][1][0] = A.M22() * B.M22() - A.Mi22() * B.Mi22() - A.M21() * B.M12() + A.Mi21() * B.Mi12();
                axb[0][0][1] = A.M11() * B.Mi11() + A.Mi11() * B.M11() - A.M12() * B.Mi21() - A.Mi12() * B.M21();
                axb[0][1][1] = A.M11() * B.Mi12() + A.Mi11() * B.M12() + A.M12() * B.Mi22() + A.Mi12() * B.M22();
                axb[1][0][1] = A.M22() * B.Mi21() + A.Mi22() * B.M21() + A.M21() * B.Mi11() + A.Mi21() * B.M11();
                axb[1][1][1] = A.M22() * B.Mi22() + A.Mi22() * B.M22() - A.M21() * B.Mi12() - A.Mi21() * B.M12();
            return axb;

        }
}
