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

package OpenCI.Numerical;
   
public class Matrix {
    public enum Type{
        /*
        B1, B2, B3, B4,     // 8 bit (byte)
        S1, S2, S3, S4,     // 16 bit (short)
        I1, I2, I3, I4,     // 32 bit (int)
        F1, F2, F3, F4,     // 32 bit (float)
        L1, L2, L3, L4,     // 64 bit (long int) **/
        D1, D2, D3, D4      // 64 bit (double/long float)
    };
    private int m;
    private int n;
    private double[][] data1d; // n = 1 (1D) double matrix
    private double[][] data2d;
    private double[][] data3d;
    private double[][] data4d;
    private float[][] data1f;
    private float[][] data2f;
    private float[][] data3f;
    private float[][] data4f;
    private long[][] data1l;
    private long[][] data2l;
    private long[][] data3l;
    private long[][] data4l;
    private short[][] data1s;
    private short[][] data2s;
    private short[][] data3s;
    private short[][] data4s;
    private int[][] data1i;
    private int[][] data2i;
    private int[][] data3i;
    private int[][] data4i;
    private byte[][] data1b;
    private byte[][] data2b;
    private byte[][] data3b;
    private byte[][] data4b;
    private Type type;

    public Matrix() { // defaults to null

    }

    public Matrix(int rows, int cols,Type t) {
        switch(t){
            case D1: // 1 channel double matrix
                this.m = rows;
                this.n = cols;
                this.type = Type.D1;
                this.data1d = new double[m][n];
                break;
            case D2: // 2 channel double matrix
                this.m = rows;
                this.n = cols;
                this.type = Type.D2;                
                this.data1d = new double[m][n];
                this.data2d = new double[m][n];
                break;
            case D3: // 3 channel double matrix
                this.m = rows;
                this.n = cols;
                this.type = Type.D3;
                this.data1d = new double[m][n];
                this.data2d = new double[m][n];
                this.data3d = new double[m][n];
                break;
            case D4: // 4 channel double matrix
                this.m = rows;
                this.n = cols;
                this.type = Type.D4;
                this.data1d = new double[m][n];
                this.data2d = new double[m][n];
                this.data3d = new double[m][n];
                this.data4d = new double[m][n];
                break;
            default:
                break;
        }
    }
	
	public static Matrix zeros(int size,Type t) { // Mat m = Matrix.zeros(3,Matrix.Type.D1);
		Matrix m = new Matrix(size,size,t);
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				m[j][i] = 0;
			}
		}
		return m;
	}
    
    // fix these 
    public void setCell(int row, int col, double data) {
        // 1D, Double 
        this.data1d[row][col] = data;
    }
    
    public void cloneTo(Matrix mat) {
        switch(this.type) {
            case D1:
                mat.setRow(this.getRow());
                mat.setCol(this.getCol());
                mat.setType(this.getType());
                mat.data1d = this.data1d;
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
    
    public void setCell(int row,int col,int dimension,double data) { 
        // nD, Double
        switch(dimension) { 
            case 2:
                this.data2d[row][col] = data;
                break;
            case 3: 
                this.data3d[row][col] = data;
                break;
            case 4: 
                this.data4d[row][col] = data;
                break;
        }
    }
    public double getCell(int row,int col) {
        return data1d[row][col];
    }

    // zeros, ones, clone, transpose, inverse, getrow, getcol, dotproduct, crossproduct  ...
}