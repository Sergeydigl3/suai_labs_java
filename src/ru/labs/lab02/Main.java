package ru.labs.lab02;

public class Main {
    public static void main(String[] args) {
        // Multiple matrix 10 times
        Matrix matrix = new Matrix(2, 2);
        matrix.setElement(0, 0, 1);
        matrix.setElement(0, 1, 1);
        matrix.setElement(1, 0, 1);
        matrix.setElement(1, 1, 0);

        // copy matrix
        Matrix matrixCopy = new Matrix(matrix);

        System.out.println("Matrix3: ");
        System.out.println(matrix);
        for (int i = 0; i < 9; i++) {
            matrix.product(matrixCopy);
            System.out.println(matrix);
        }
    }
}
