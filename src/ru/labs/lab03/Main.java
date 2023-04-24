package ru.labs.lab03;

import ru.labs.lab03.matrixes.SquareMatrix;
import ru.labs.lab03.matrixes.Matrix;

public class Main {
    public static void main(String[] args) {
        // Tests for SquareMatrix for exceptions
SquareMatrix matrix1 = new SquareMatrix(2);
matrix1.setElement(0, 1, 2);
matrix1.setElement(1, 0, 3);
System.out.println("Matrix1: ");
System.out.println(matrix1);

SquareMatrix matrix2 = new SquareMatrix(2);

matrix2.setElement(0, 1, 6);
matrix2.setElement(1, 0, 7);

System.out.println("Matrix2: ");
System.out.println(matrix2);


SquareMatrix result = matrix1.product(matrix2);
System.out.println("Product of matrix1 and matrix2");
System.out.println(result.toString());

SquareMatrix sum = matrix1.sum(matrix2);
System.out.println("Sum of matrix1 and matrix2");
System.out.println(sum.toString());

Matrix matrix3 = new Matrix(2, 3);
System.out.println("Attempt create SquareMatrix based on NonSquareMatrix");
try {
    SquareMatrix matrix4 = new SquareMatrix(matrix3);
    System.out.println(result);
} catch (RuntimeException e) {
    System.out.println(e.getMessage());
}
    }
}
