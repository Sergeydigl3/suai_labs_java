package ru.labs.lab03.matrixes;

public class Matrix {
    protected int[][] matrix;
    protected int rows;
    protected int columns;

    public Matrix(int rows, int columns) {
        if (rows <= 0 || columns <= 0) {
            throw new MatrixException("Matrix size is incorrect");
        }

        this.rows = rows;
        this.columns = columns;
        this.matrix = new int[rows][columns];
    }

    public Matrix(Matrix matrix) {
        this.matrix = matrix.getMatrix();
        this.rows = matrix.getRows();
        this.columns = matrix.getColumns();
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public int getElement(int row, int column) {
        return matrix[row][column];
    }

    public void setElement(int row, int column, int value) {
        matrix[row][column] = value;
    }

    public Matrix sum(Matrix matrix) {
        if (this.rows != matrix.getRows() || this.columns != matrix.getColumns()) {
            throw new MatrixException("Matrix sizes are not equal");
        }

        Matrix result = new Matrix(this.rows, this.columns);

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                result.setElement(i, j, this.matrix[i][j] + matrix.getElement(i, j));
            }
        }

        return result;
    }

    public Matrix product(Matrix matrix) {
        if (this.columns != matrix.getRows() || this.rows != matrix.getColumns()) {
            throw new MatrixException("Matrix sizes are not equal; m1.rows != m2.columns or m1.columns != m2.rows"  );
        }

        Matrix result = new Matrix(this.rows, matrix.getColumns());

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                int sum = 0;
                for (int k = 0; k < this.columns; k++) {
                    sum += this.matrix[i][k] * matrix.getElement(k, j);
                }
                result.setElement(i, j, sum);
            }
        }

        return result;
    }

    public String toString() {
        final StringBuilder result = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.append(matrix[i][j]).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (object == this) {
            return true;
        }

        if (!(object instanceof Matrix)) {
            return false;
        }

        Matrix matrix = (Matrix) object;

        if (this.rows != matrix.getRows() || this.columns != matrix.getColumns()) {
            return false;
        }

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                if (this.matrix[i][j] != matrix.getElement(i, j)) {
                    return false;
                }
            }
        }

        return true;
    }
}