package ru.labs.lab05.matrixes;

//import ru.labs.lab03.Matrix;

public class SquareMatrix extends UsualMatrix {
    public SquareMatrix(int size) {
        super(size, size);
        for (int i = 0; i < size; i++) {
            matrix[i][i] = 1;
        }
    }

    public SquareMatrix(UsualMatrix matrix) {
        super(matrix);
        if (matrix.getRows() != matrix.getColumns()) {
            throw new MatrixException("Matrix is not square");
        }
    }

    public SquareMatrix(SquareMatrix matrix) {
        super(matrix);
    }

    public SquareMatrix sum(final SquareMatrix matrix) {
        return (SquareMatrix) super.sum(matrix);
    }

    public SquareMatrix product(final SquareMatrix matrix) {
        return (SquareMatrix) super.product(matrix);
    }
}
