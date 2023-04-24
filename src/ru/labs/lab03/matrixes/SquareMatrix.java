package ru.labs.lab03.matrixes;


public class SquareMatrix extends Matrix {
    public SquareMatrix(int size) {
        super(size, size);
        for (int i = 0; i < size; i++) {
            matrix[i][i] = 1;
        }
    }

    public SquareMatrix(Matrix matrix) {
        super(matrix);
        if (matrix.getRows() != matrix.getColumns()) {
            throw new MatrixException("Matrix is not square");
        }
    }

    public SquareMatrix sum(Matrix matrix) {
        if (this.rows != matrix.getRows() || this.columns != matrix.getColumns()) {
            throw new MatrixException("Matrix sizes are not equal. Matrix A rows count must be equal to matrix B rows count");
        }

        SquareMatrix result = new SquareMatrix(this.rows);

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                result.setElement(i, j, this.matrix[i][j] + matrix.getElement(i, j));
            }
        }

        return result;
    }

    public SquareMatrix product(Matrix matrix) {
        if (this.columns != matrix.getRows() || this.rows != matrix.getColumns()) {
            throw new MatrixException("Matrix sizes are not equal. Matrix A columns count must be equal to matrix B rows count");
        }

        SquareMatrix result = new SquareMatrix(this.rows);

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                int sum = 0;
                for (int k = 0; k < this.columns; k++) {
                    sum += this.matrix[i][k] * matrix.getElement(k, j);
                }
                result.setElement(i, j, sum);
            }
        }

        return result;
    }
}
