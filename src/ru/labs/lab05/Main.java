package ru.labs.lab05;

import ru.labs.lab05.matrixes.SparseMatrix;
import ru.labs.lab05.matrixes.UsualMatrix;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Напишите программу, создающую 2 случайные матрицы размером 1000x1000 с 1000 ненулевых элементов в каждой двумя способами --- с помощью обычных и разреженных матриц. Проверьте, что сложение и умножение для разных видов матриц дает одинаковые результаты.
        int matrixSizeX = 100;
        int matrixSizeY = 100;


        UsualMatrix mUsual = new UsualMatrix(matrixSizeX, matrixSizeY);
        SparseMatrix mSparse = new SparseMatrix(matrixSizeX, matrixSizeY);
//
        Random r = new Random();
        r.setSeed(0);
        System.out.println("Fill start");
        for (int i = 0; i < matrixSizeX; i++) {
            for (int j = 0; j < matrixSizeY; j++) {
                int value = r.nextInt(100);
                mUsual.setElement(i, j, value);
                mSparse.setElement(i, j, value);
            }
//            System.out.println("Row " + i + " done");
        }
        System.out.println("Fill end");
        System.out.println("Check same: " + mUsual.equals(mSparse)+"\n");

//
        System.out.print("Product usual on usual...");
        UsualMatrix mUsualProduct = mUsual.product(mUsual);
        System.out.println("Done");

        System.out.print("Product sparse on sparse...");
        SparseMatrix mSparseProduct = mSparse.product(mSparse);
        System.out.println("Done");

        System.out.println("Check same results: " + mUsualProduct.equals(mSparseProduct)+"\n");

        System.out.print("Sum usual on usual...");
        UsualMatrix mUsualSum = mUsual.sum(mUsual);
        System.out.println("Done");

        System.out.println("Sum sparse on sparse...");
        SparseMatrix mSparseSum = mSparse.sum(mSparse);
        System.out.print("Done");

        System.out.println("Check same results: " + mUsualSum.equals(mSparseSum)+"\n");
//
//        System.out.println("Sum:");
//        System.out.println("Usual: " + mUsualSum.getElement(0, 0));
//        System.out.println("Sparse: " + mSparseSum.getElement(0, 0));
//
//        System.out.println("Product:");
//        System.out.println("Usual: " + mUsualProduct.getElement(0, 0));
//        System.out.println("Sparse: " + mSparseProduct.getElement(0, 0));


    }
}
//