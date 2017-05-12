/**
 * Matrix.java
 *
 * @author dogan can karatas
 * @version 1.0
 */

// [ [ m00, m01, m02],
//   [ m10, m11, m12],
//   [ m20, m21, m22] ] formatında olmalı, bu 1D matrix oluyor.
// bundan 2 tane daha yaratıp hepsini aynı anda döndürürsen 3D matris olur

package OpenCIL.Numerical;

public class Matrix {
    private int m1;
    private int n1;
    double[][] data1d; // n = 1 (1D) double matrix

    /**
     * private int m2,n2;
     * double[][] data2d; // n = 2 (2D) double matrix
     * ...
     *
     * private int m3,n3;
     * double[][] data3d; // n = 3 (3D) double matrix
     * float[][] data3f;  // n = 3 (3D) float matrix
     * ...
     *
     * private int m4,n4;
     * double[][] data4d; // n = 4 (4D) double matrix
     * float[][] data4f;  // n = 4 (4D) float matrix
     * int[][] data4i;    // n = 4 (4D) int matrix
     * ...
     */

    public enum Type{
        /*
        B1, B2, B3, B4,     // 8 bit (byte)
        S1, S2, S3, S4,     // 16 bit (short)
        I1, I2, I3, I4,     // 32 bit (int)
        F1, F2, F3, F4,     // 32 bit (float)
        L1, L2, L3, L4,     // 64 bit (long int) **/
        D1, D2, D3, D4      // 64 bit (double/long float)
    };

    //public Matrix();

    public Matrix(int rows, int cols,Type t) {
        if(t == Type.D1){
            this.m1 = rows;
            this.n1 = cols;
            this.data1d = new double[m1][n1];
        }
    }

    public void setData(int row,int col,double data) {
        this.data1d[row][col] = data;
    }
    public double getData(int row,int col) {
        return data1d[row][col];
    }
}