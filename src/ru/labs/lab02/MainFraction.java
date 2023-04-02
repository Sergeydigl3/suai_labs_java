package ru.labs.lab02;

public class MainFraction {
    public static void main(String[] args) {
FractionMatrix matrix1 = new FractionMatrix(3, 3);
matrix1.setElement(0, 0, new Fraction(1, 2));
matrix1.setElement(0, 1, new Fraction(1, 4));
matrix1.setElement(0, 2, new Fraction(1, 6));
matrix1.setElement(1, 0, new Fraction(1, 3));
matrix1.setElement(1, 1, new Fraction(1, 5));
matrix1.setElement(1, 2, new Fraction(1, 7));
matrix1.setElement(2, 0, new Fraction(1, 8));
matrix1.setElement(2, 1, new Fraction(1, 10));
matrix1.setElement(2, 2, new Fraction(1, 12));

System.out.println("Matrix1: ");
System.out.println(matrix1.toString());

FractionMatrix matrix2 = new FractionMatrix(3, 3);
matrix2.setElement(0, 0, new Fraction(2, 3));
matrix2.setElement(0, 1, new Fraction(1, 3));
matrix2.setElement(0, 2, new Fraction(1, 3));
matrix2.setElement(1, 0, new Fraction(1, 2));
matrix2.setElement(1, 1, new Fraction(2, 5));
matrix2.setElement(1, 2, new Fraction(1, 2));
matrix2.setElement(2, 0, new Fraction(3, 4));
matrix2.setElement(2, 1, new Fraction(4, 5));
matrix2.setElement(2, 2, new Fraction(3, 7));

System.out.println("Matrix2: ");
System.out.println(matrix2.toString());



FractionMatrix result1 = matrix1.sum(matrix2);
System.out.println("Sum of matrix1 and matrix2");
System.out.println(result1.toString());

FractionMatrix result2 = matrix1.product(matrix2);
System.out.println("Product of matrix1 and matrix2");
System.out.println(result2.toString());


    }
}
