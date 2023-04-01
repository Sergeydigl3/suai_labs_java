package ru.labs.lab05.matrixes;

import java.util.Random;

public abstract class Matrix implements IMatrix {

    protected abstract Matrix createMatrix(int rows, int columns);

    public Matrix sum(final Matrix matrix) {
        if (this.getRows() != matrix.getRows() || this.getColumns() != matrix.getColumns()) {
            throw new MatrixException("Matrix sizes are not equal");
        }

        Matrix result = createMatrix(this.getRows(), this.getColumns());

        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                result.setElement(i, j, this.getElement(i, j) + matrix.getElement(i, j));
            }
        }

        return result;
    }

    public Matrix product(final Matrix matrix) {
        if (this.getColumns() != matrix.getRows() || this.getRows() != matrix.getColumns()) {
            throw new MatrixException("Matrix sizes are not equal");
        }

        Matrix result = createMatrix(this.getRows(), matrix.getColumns());

        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                int sum = 0;
                for (int k = 0; k < this.getColumns(); k++) {
                    sum += this.getElement(i, k) * matrix.getElement(k, j);
                }
                result.setElement(i, j, sum);
            }
//            System.out.println("Row " + i + " is done");
        }

        return result;
    }

    public void fillRandom(int seed,int bound) {
        Random r = new Random();
        r.setSeed(seed);
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                this.setElement(i, j, r.nextInt(bound));
            }
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                result.append(this.getElement(i, j)).append(" ");
            }
            result.append("\n");
        }

        return result.toString();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Matrix)) {
            return false;
        }

        Matrix matrix = (Matrix) obj;

        if (this.getRows() != matrix.getRows() || this.getColumns() != matrix.getColumns()) {
            return false;
        }

        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                if (this.getElement(i, j) != matrix.getElement(i, j)) {
                    return false;
                }
            }
        }

        return true;
    }
}
