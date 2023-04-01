package ru.labs.lab02;

import ru.labs.lab02.Fraction;
public class FractionMatrix {

    private Fraction[][] matrix;
    private int rows;
    private int columns;

    public FractionMatrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        matrix = new Fraction[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = new Fraction();
            }
        }
    }

    public FractionMatrix(FractionMatrix matrix) {
        this.rows = matrix.rows;
        this.columns = matrix.columns;
        this.matrix = new Fraction[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.matrix[i][j] = new Fraction(matrix.matrix[i][j].getNumerator(), matrix.matrix[i][j].getDenominator());
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Fraction getElement(final int row, final int column) {
        return matrix[row][column];
    }

    public void setElement(final int row, final int column, final Fraction value) {
        matrix[row][column] = value;
    }

    public void setElement(final int row, final int column, final int numerator, final int denominator) {
        matrix[row][column].setNumerator(numerator);
        matrix[row][column].setDenominator(denominator);
    }

    public FractionMatrix sum(FractionMatrix matrix) {
        FractionMatrix result = new FractionMatrix(this.rows, this.columns);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                result.setElement(i, j, this.matrix[i][j].add(matrix.getElement(i, j)));
            }
        }
        return result;
    }

    public FractionMatrix sub(FractionMatrix matrix) {
        FractionMatrix result = new FractionMatrix(this.rows, this.columns);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                result.setElement(i, j, this.matrix[i][j].sub(matrix.getElement(i, j)));
            }
        }
        return result;
    }

    public FractionMatrix product(FractionMatrix matrix) {
        FractionMatrix result = new FractionMatrix(this.rows, matrix.getColumns());
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                Fraction sum = new Fraction();
                for (int k = 0; k < this.columns; k++) {
                    sum = sum.add(this.matrix[i][k].mul(matrix.getElement(k, j)));
                }
                result.setElement(i, j, sum);
            }
        }
        return result;
    }

    public FractionMatrix div(FractionMatrix matrix) {
        FractionMatrix result = new FractionMatrix(this.rows, matrix.getColumns());
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                Fraction sum = new Fraction();
                for (int k = 0; k < this.columns; k++) {
                    sum = sum.add(this.matrix[i][k].div(matrix.getElement(k, j)));
                }
                result.setElement(i, j, sum);
            }
        }
        return result;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.append(matrix[i][j].toString());
                result.append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }
}
