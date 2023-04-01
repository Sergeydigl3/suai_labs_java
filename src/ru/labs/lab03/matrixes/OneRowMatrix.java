package ru.labs.lab03.matrixes;

// same as matrix but every call will be for one existence row
public class OneRowMatrix{
    private int[] matrix;
    private int rows;
    private int columns;

    public OneRowMatrix(int columns) {
        this.rows = 1;
        this.columns = columns;
        matrix = new int[columns];
    }

    public OneRowMatrix(int[] matrix) {
        this.matrix = matrix;
        this.rows = 1;
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
        if (row != 0) {
            throw new IllegalArgumentException("Row must be 0");
        }
        if (column >= this.columns) {
            throw new IllegalArgumentException("Column must be less than " + this.columns);
        }
        return matrix[column];
    }

    public void setElement(int row, int column, int value) {
        if (row != 0) {
            throw new IllegalArgumentException("Row must be 0");
        }
        if (column >= this.columns) {
            throw new IllegalArgumentException("Column must be less than " + this.columns);
        }
        matrix[column] = value;
    }

    public OneRowMatrix sum(OneRowMatrix matrix) {
        OneRowMatrix result = new OneRowMatrix(this.columns);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                result.setElement(i, j, this.matrix[j] + matrix.getElement(i, j));
            }
        }
        return result;
    }

    public OneRowMatrix product(OneRowMatrix matrix) {
        OneRowMatrix result = new OneRowMatrix(matrix.getColumns());
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
        for (int j = 0; j < this.columns; j++) {
            result.append(this.matrix[j]).append(" ");
        }
        return result.toString();
    }
}
