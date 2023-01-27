package ru.labs.lab05.matrixes;

public class UsualMatrix extends Matrix {
    protected int[][] matrix;
    protected int rows;
    protected int columns;

    public UsualMatrix(int rows, int columns) {
        if (rows <= 0 || columns <= 0) {
            throw new MatrixException("Matrix size is incorrect");
        }

        this.rows = rows;
        this.columns = columns;
        this.matrix = new int[rows][columns];
    }

    public UsualMatrix(UsualMatrix matrix) {
        this.matrix = matrix.getMatrix();
        this.rows = matrix.getRows();
        this.columns = matrix.getColumns();
    }

    protected Matrix createMatrix(int rows, int columns) {
        return new UsualMatrix(rows, columns);
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int getElement(int row, int column) {
        return matrix[row][column];
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setElement(final int row, final int column, int value) {
        matrix[row][column] = value;
    }

    public UsualMatrix sum(final UsualMatrix matrix) {
        return (UsualMatrix) super.sum(matrix);
    }

    public UsualMatrix product(final UsualMatrix matrix) {
        return (UsualMatrix) super.product(matrix);
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
}
