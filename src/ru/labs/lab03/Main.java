package ru.labs.lab03;

import ru.labs.lab03.matrixes.SquareMatrix;
import ru.labs.lab03.matrixes.Matrix;

public class Main {
    public static void main(String[] args) {
        // Tests for SquareMatrix for exceptions
        SquareMatrix matrix = new SquareMatrix(2);
        matrix.setElement(0, 0, 1);
        matrix.setElement(0, 1, 1);
        matrix.setElement(1, 0, 1);
        matrix.setElement(1, 1, 0);


        System.out.println("MatrixSquare with some data: ");
        System.out.println(matrix);

        SquareMatrix matrix3 = new SquareMatrix(3);
        System.out.println("new Matrix3(Square): ");
        System.out.println(matrix3);

        Matrix matrix2 = new Matrix(2, 2);
        matrix2.setElement(0, 0, 1);
        System.out.println("Matrix2: ");
        System.out.println(matrix2);

        SquareMatrix matrix4 = new SquareMatrix(matrix2);
        System.out.println("Matrix4: ");
        System.out.println(matrix4);

        System.out.println("Attempt product matrix3 on matrix: ");
        try {
            matrix3 = matrix3.product(matrix);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
