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

// yada matrix array da yapılabilir,,, Matrix[] m = new Matrix[4]; // 4D matrix...
// m[1].setType(Matrix.Type.D);
// m -> Object [Array] of Type Matrix
// m[2] = Matrix.zeros(3,3);

// Matrix[] m = new Matrix[3];
// Capture cap = new Capture(0);
// cap.getFrame(m); 
// mesela?

package OpenCI.Numerical;
   
public class Matrix {
    public enum Type{
        /*
        B1, B2, B3, B4,     // 8 bit (byte)
        S1, S2, S3, S4,     // 16 bit (short)
        I1, I2, I3, I4,     // 32 bit (int)
        F1, F2, F3, F4,     // 32 bit (float)
        L1, L2, L3, L4,     // 64 bit (long int) **/
        Double      // 64 bit (double/long float)
    };
    private int m;
    private int n;
    private double[][] data_d; // n = 1 (1D) double matrix
    private float[][] data_f;
    private long[][] data_l;
    private short[][] data_s;
    private int[][] data_i;
    private byte[][] data_b;
    private Type type;

    public Matrix() { // defaults to null

    }
    
    public Matrix(int rows, int cols,Type t) {
        switch(t){
            case Double: // 1 channel double matrix
                this.m = rows;
                this.n = cols;
                this.type = Type.Double;
                this.data_d = new double[m][n];
                break;
            default:
                break;
        }
    }
    
    public static Matrix zeros(int rows, int cols,Type t) { // Mat m = Matrix.zeros(3,3,Matrix.Type.Double);
        Matrix m = new Matrix(rows,cols,t);
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                m.setCell(i,j,0);
            }
        }
        return m;
    }
    
    // fix these 
    
    public void cloneTo(Matrix mat) {
        switch(this.type) {
            case Double:
                mat.setRow(this.getRow());
                mat.setCol(this.getCol());
                mat.setType(this.getType());
                mat.data_d = this.data_d;
                break;
        }
    }
    
    public void print() {
        switch(this.type){
            case Double:
                System.out.print("[");
                for(int i = 0; i < this.m; i++) {
                    if(i == 0) System.out.print("["); else System.out.print(" [");
                    for(int j = 0; j < this.n; j++) {
                        System.out.printf(" %7.3f",this.data_d[i][j]);
                        if (j == (this.n - 1) && i != (this.m - 1)) 
                            System.out.println(" ]"); 
                        else if(j == (this.n - 1) && i == (this.m - 1)) 
                            System.out.println(" ]]");
                        else continue;
                    }
                }
                break;
        }
    }
    
        public void println() {
        switch(this.type){
            case Double:
                System.out.print("[");
                for(int i = 0; i < this.m; i++) {
                    if(i == 0) System.out.print("["); else System.out.print(" [");
                    for(int j = 0; j < this.n; j++) {
                        System.out.printf(" %7.3f",this.data_d[i][j]);
                        if (j == (this.n - 1) && i != (this.m - 1)) 
                            System.out.println(" ]"); 
                        else if(j == (this.n - 1) && i == (this.m - 1)) 
                            System.out.println(" ]]\n");
                        else continue;
                    }
                }
                break;
        }
    }

    public int getRow() {
        return this.m;
    }
    
    public int getCol() {
        return this.n;
    }
    
    public void setRow(int row) {
        this.m = row;
    }
    
    public void setCol(int col) {
        this.n = col;
    }
    
    public void setType(Type t) {
        this.type = t;
    }
    
    public Type getType() {
        return this.type;
    }
    
    public void setCell(int row, int col, double data) { 
        // nD, Double
        switch(this.type) { 
            case Double:
                this.data_d[row][col] = data;
                break;
        }
    }
    
    public double getCell(int row,int col) {
        switch(this.type) {
            case Double:
                return this.data_d[row][col];
            default:
                return 0;
        }
    }

    // zeros, ones, clone, transpose, inverse, getrow, getcol, dotproduct, crossproduct  ...
}