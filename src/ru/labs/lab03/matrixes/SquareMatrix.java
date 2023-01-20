package ru.labs.lab03.matrixes;

//import ru.labs.lab03.Matrix;

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
}
