package ru.labs.lab03;
// OneRowMatrix.java
import ru.labs.lab03.matrixes.OneRowMatrix;
public class DopMain {
    public static void main(String[] args) {
        // Tests for OneRowMatrix for exceptions
        OneRowMatrix matrix = new OneRowMatrix(2);
        matrix.setElement(0, 0, 1);
        matrix.setElement(0, 1, 1);
//        matrix.setElement(0, 2, 1);
//        matrix.setElement(0, 3, 0);
        OneRowMatrix matrix3 = new OneRowMatrix(3);
        System.out.println("Matrix: ");
        System.out.println(matrix);
        System.out.println("Matrix3: ");
        System.out.println(matrix3);
        OneRowMatrix matrix2 = new OneRowMatrix(2);
        matrix2.setElement(0, 0, 1);
        OneRowMatrix matrix4 = new OneRowMatrix(matrix2);
        System.out.println("Matrix4: ");
        System.out.println(matrix4);

        System.out.println("Matrix4: ");

        System.out.println("Product matrix Exception");
        try {
            matrix3 = matrix3.product(matrix);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
