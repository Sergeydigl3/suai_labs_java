package ru.labs.lab03.matrixes;

// same as matrix but every call will be for one existence row
public class OneRowMatrix {
    private int[] matrix;
    private int rows;
    private int columns;

    public OneRowMatrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        matrix = new int[columns];
    }

    public OneRowMatrix(int rows, int[] matrix) {
        this.matrix = matrix;
        this.rows = rows;
        this.columns = matrix.length;
    }

    public OneRowMatrix(OneRowMatrix matrix) {
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

    public int[] getMatrix() {
        return matrix;
    }

    public int getElement(int row, int column) {
        if (column >= this.columns) {
            throw new IllegalArgumentException("Column must be less than " + this.columns);
        }
        return matrix[column];
    }

    public void setElement(int row, int column, int value) {
        if (column >= this.columns || row >= this.rows) {
            throw new IllegalArgumentException("Column must be less than " + this.columns + " and row must be less than " + this.rows);
        }

        matrix[column] = value;
    }

    public OneRowMatrix sum(OneRowMatrix matrix) {
        OneRowMatrix result = new OneRowMatrix(this.rows, this.columns);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                result.setElement(i, j, this.matrix[j] + matrix.getElement(i, j));
            }
        }
        return result;
    }

    public OneRowMatrix product(OneRowMatrix matrix) {
        if (this.columns != matrix.getRows()) {
            throw new MatrixException("Matrix sizes are not equal for product. This matrix columns must be equal to matrix rows");
        }
        OneRowMatrix result = new OneRowMatrix(matrix.getRows(), matrix.getColumns());
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                int sum = 0;
                for (int k = 0; k < this.columns; k++) {
                    sum += this.matrix[k] * matrix.getElement(k, j);
                }
                result.setElement(i, j, sum);
            }
        }
        return result;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                result.append(this.matrix[j]).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }
}