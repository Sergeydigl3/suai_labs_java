package ru.labs.lab05;

import ru.labs.lab05.matrixes.SparseMatrix;
import ru.labs.lab05.matrixes.UsualMatrix;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Напишите программу, создающую 2 случайные матрицы размером 1000x1000 с 1000 ненулевых элементов в каждой двумя способами --- с помощью обычных и разреженных матриц. Проверьте, что сложение и умножение для разных видов матриц дает одинаковые результаты.
        int matrixSizeX = 5;
        int matrixSizeY = 5;


        UsualMatrix mUsual = new UsualMatrix(matrixSizeX, matrixSizeY);
        SparseMatrix mSparse = new SparseMatrix(matrixSizeX, matrixSizeY);
//
        Random r = new Random();
        r.setSeed(0);
        for (int i = 0; i < matrixSizeX; i++) {
            for (int j = 0; j < matrixSizeY; j++) {
                int value = r.nextInt(100);
                mUsual.setElement(i, j, value);
                mSparse.setElement(i, j, value);
            }
//            System.out.println("Row " + i + " done");
        }
//      Check same
        System.out.println("Check same");
        for (int i = 0; i < matrixSizeX; i++) {
            for (int j = 0; j < matrixSizeY; j++) {
                if (mUsual.getElement(i, j) != mSparse.getElement(i, j)) {
                    System.out.println("Not same at " + i + " " + j);
                }
            }
        }
//        mSparse.getElement(12, 12);
//        mSparse.getElement(12, 14);

        // print SparseMatrix
//        System.out.println(mSparse.toString());
//
//
//        System.out.println("Sum calc\nUsual start");
//        UsualMatrix mUsualSum = mUsual.sum(mUsual);
//        System.out.println("Usual end; Sparse start");
//        SparseMatrix mSparseSum = mSparse.sum(mSparse);
//        System.out.println("Sparse end");
//
//        System.out.println("Product calc\nUsual start");
//        UsualMatrix mUsualProduct = mUsual.product(mUsual);
//        System.out.println("Usual end; Sparse start");
//        SparseMatrix mSparseProduct = mSparse.product(mSparse);
//        System.out.println("Sparse end");
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
