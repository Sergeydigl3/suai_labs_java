package ru.labs.lab05;

import ru.labs.lab05.matrixes.SparseMatrix;
import ru.labs.lab05.matrixes.UsualMatrix;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Напишите программу, создающую 2 случайные матрицы размером 1000x1000 с 1000 ненулевых элементов в каждой двумя способами --- с помощью обычных и разреженных матриц. Проверьте, что сложение и умножение для разных видов матриц дает одинаковые результаты.
        int matrixSizeX = 15;
        int matrixSizeY = 15;
//        SparseMatrix mSparse = new SparseMatrix(matrixSizeX, matrixSizeY);
//        mSparse.setElement(0, 0, 1);
//        mSparse.setElement(1, 1, 4);
//        mSparse.setElement(2, 2, 2);
//
//        mSparse.getElement(0, 0);
////        mSparse.getElement(1, 1);
//        mSparse.getElement(2, 2);
//        System.out.println(mSparse.getElement(0, 0));
//
//        System.out.println(mSparse.getElement(0, 0));
//        System.out.println(mSparse.getElement(1, 1));
//        System.out.println(mSparse.getElement(2, 2));

//        mSparse.setElement(1, 0, 3);

//        System.out.println(mSparse.toString());
        UsualMatrix mUsual = new UsualMatrix(matrixSizeX, matrixSizeY);
        SparseMatrix mSparse = new SparseMatrix(matrixSizeX, matrixSizeY);

        Random r = new Random();
        r.setSeed(0);
        for (int i = 0; i < matrixSizeX; i++) {
            for (int j = 0; j < matrixSizeY; j++) {
                mUsual.setElement(i, j, r.nextInt(100));
                mSparse.setElement(i, j, r.nextInt(100));
            }
//            System.out.println("Row " + i + " done");
        }

        mSparse.getElement(12, 12);
        mSparse.getElement(12, 14);

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
