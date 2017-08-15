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
        Byte,       // 8 bit (byte)
        Short,      // 16 bit (short)
        Int,        // 32 bit (int)
        Float,      // 32 bit (float)
        Long,       // 64 bit (long int)
        Double      // 64 bit (double/long float)
    };
    private int m;
    private int n;
    private double[][] data_d; // double matrix
    private float[][] data_f;
    private long[][] data_l;
    private short[][] data_s;
    private int[][] data_i;
    private byte[][] data_b;
    private Type type;

    public Matrix() { // defaults to null

    }
    
    public Matrix(int rows, int cols, Type t) {
        this.m = rows;
        this.n = cols;
        this.type = t;
        switch(t){
            case Double: // 1 channel double matrix
                this.data_d = new double[m][n];
                break;
            case Float:
                this.data_f = new float[m][n];
                break;
            case Long:
                this.data_l = new long[m][n];
                break;
            case Int:
                this.data_i = new int[m][n];
                break;
            case Short:
                this.data_s = new short[m][n];
                break;
            case Byte:
                this.data_b = new byte[m][n];
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
        mat.setRow(this.getRow());
        mat.setCol(this.getCol());
        mat.setType(this.getType());
        switch(this.type) {
            case Double:
                mat.data_d = this.data_d;
                break;
            case Float:
                mat.data_f = this.data_f;
                break;
            case Long:
                mat.data_l = this.data_l;
                break;
            case Int:
                mat.data_i = this.data_i;
                break;
            case Short:
                mat.data_s = this.data_s;
                break;
            case Byte:
                mat.data_b = this.data_b;
                break;
            default:
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
            case Float:
                System.out.print("[");
                for(int i = 0; i < this.m; i++) {
                    if(i == 0) System.out.print("["); else System.out.print(" [");
                    for(int j = 0; j < this.n; j++) {
                        System.out.printf(" %7.3f",this.data_f[i][j]);
                        if (j == (this.n - 1) && i != (this.m - 1)) 
                            System.out.println(" ]"); 
                        else if(j == (this.n - 1) && i == (this.m - 1)) 
                            System.out.println(" ]]");
                        else continue;
                    }
                }
                break;
            case Long:
                System.out.print("[");
                for(int i = 0; i < this.m; i++) {
                    if(i == 0) System.out.print("["); else System.out.print(" [");
                    for(int j = 0; j < this.n; j++) {
                        System.out.printf(" %7d",this.data_l[i][j]);
                        if (j == (this.n - 1) && i != (this.m - 1)) 
                            System.out.println(" ]"); 
                        else if(j == (this.n - 1) && i == (this.m - 1)) 
                            System.out.println(" ]]");
                        else continue;
                    }
                }
                break;
            case Int:
                System.out.print("[");
                for(int i = 0; i < this.m; i++) {
                    if(i == 0) System.out.print("["); else System.out.print(" [");
                    for(int j = 0; j < this.n; j++) {
                        System.out.printf(" %7d",this.data_i[i][j]);
                        if (j == (this.n - 1) && i != (this.m - 1)) 
                            System.out.println(" ]"); 
                        else if(j == (this.n - 1) && i == (this.m - 1)) 
                            System.out.println(" ]]");
                        else continue;
                    }
                }
                break;
            case Short:
                System.out.print("[");
                for(int i = 0; i < this.m; i++) {
                    if(i == 0) System.out.print("["); else System.out.print(" [");
                    for(int j = 0; j < this.n; j++) {
                        System.out.printf(" %7d",this.data_s[i][j]);
                        if (j == (this.n - 1) && i != (this.m - 1)) 
                            System.out.println(" ]"); 
                        else if(j == (this.n - 1) && i == (this.m - 1)) 
                            System.out.println(" ]]");
                        else continue;
                    }
                }
                break;
            case Byte:
                System.out.print("[");
                for(int i = 0; i < this.m; i++) {
                    if(i == 0) System.out.print("["); else System.out.print(" [");
                    for(int j = 0; j < this.n; j++) {
                        System.out.printf(" %7d",this.data_b[i][j]);
                        if (j == (this.n - 1) && i != (this.m - 1)) 
                            System.out.println(" ]"); 
                        else if(j == (this.n - 1) && i == (this.m - 1)) 
                            System.out.println(" ]]");
                        else continue;
                    }
                }
                break;
            default: 
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
            case Float:
                System.out.print("[");
                for(int i = 0; i < this.m; i++) {
                    if(i == 0) System.out.print("["); else System.out.print(" [");
                    for(int j = 0; j < this.n; j++) {
                        System.out.printf(" %7.3f",this.data_f[i][j]);
                        if (j == (this.n - 1) && i != (this.m - 1)) 
                            System.out.println(" ]"); 
                        else if(j == (this.n - 1) && i == (this.m - 1)) 
                            System.out.println(" ]]\n");
                        else continue;
                    }
                }
                break;
            case Long:
                System.out.print("[");
                for(int i = 0; i < this.m; i++) {
                    if(i == 0) System.out.print("["); else System.out.print(" [");
                    for(int j = 0; j < this.n; j++) {
                        System.out.printf(" %7d",this.data_l[i][j]);
                        if (j == (this.n - 1) && i != (this.m - 1)) 
                            System.out.println(" ]"); 
                        else if(j == (this.n - 1) && i == (this.m - 1)) 
                            System.out.println(" ]]\n");
                        else continue;
                    }
                }
                break;
            case Int:
                System.out.print("[");
                for(int i = 0; i < this.m; i++) {
                    if(i == 0) System.out.print("["); else System.out.print(" [");
                    for(int j = 0; j < this.n; j++) {
                        System.out.printf(" %7d",this.data_i[i][j]);
                        if (j == (this.n - 1) && i != (this.m - 1)) 
                            System.out.println(" ]"); 
                        else if(j == (this.n - 1) && i == (this.m - 1)) 
                            System.out.println(" ]]\n");
                        else continue;
                    }
                }
                break;
            case Short:
                System.out.print("[");
                for(int i = 0; i < this.m; i++) {
                    if(i == 0) System.out.print("["); else System.out.print(" [");
                    for(int j = 0; j < this.n; j++) {
                        System.out.printf(" %7d",this.data_s[i][j]);
                        if (j == (this.n - 1) && i != (this.m - 1)) 
                            System.out.println(" ]"); 
                        else if(j == (this.n - 1) && i == (this.m - 1)) 
                            System.out.println(" ]]\n");
                        else continue;
                    }
                }
                break;
            case Byte:
                System.out.print("[");
                for(int i = 0; i < this.m; i++) {
                    if(i == 0) System.out.print("["); else System.out.print(" [");
                    for(int j = 0; j < this.n; j++) {
                        System.out.printf(" %7d",this.data_b[i][j]);
                        if (j == (this.n - 1) && i != (this.m - 1)) 
                            System.out.println(" ]"); 
                        else if(j == (this.n - 1) && i == (this.m - 1)) 
                            System.out.println(" ]]\n");
                        else continue;
                    }
                }
                break;
            default: 
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
        this.data_d[row][col] = data;
    }
    
    public void setCell(int row, int col, float data) { 
        this.data_f[row][col] = data;
    }
    
    public void setCell(int row, int col, long data) { 
        this.data_l[row][col] = data;
    }
    
    public void setCell(int row, int col, int data) { 
        this.data_i[row][col] = data;
    }
    
    public void setCell(int row, int col, short data) { 
        this.data_s[row][col] = data;
    }

    public void setCell(int row, int col, byte data) { 
        this.data_b[row][col] = data;
    }
    
    public double getCell(int row,int col) {
        switch(this.type) {
            case Double:
                return this.data_d[row][col];
            case Float:
                return this.data_f[row][col];
            case Long:
                return this.data_l[row][col];
            case Int:
                return this.data_i[row][col];
            case Short:
                return this.data_s[row][col];
            case Byte:
                return this.data_b[row][col];
            default:
                return 0;
        }
    }

    // zeros, ones, clone, transpose, inverse, getrow, getcol, dotproduct, crossproduct  ...
}