package ru.labs.lab05;

import ru.labs.lab05.matrixes.SparseMatrix;
import ru.labs.lab05.matrixes.SparseMatrixHash;

public class DopMain {
    public static void main(String[] args){
        // Сравнить две реализации SparseMatrix с помощью System.currentTimeMillis() и вывести на экран время работы каждой из них.

        SparseMatrix mSparse = new SparseMatrix(100, 100);
        SparseMatrixHash mSparseHash = new SparseMatrixHash(100, 100);

        // fill with random
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                mSparse.setElement(i, j, (int) (Math.random() * 100));
                mSparseHash.setElement(i, j, (int) (Math.random() * 100));
            }
        }

        long start = System.currentTimeMillis();
        mSparse.product(mSparse);
        long end = System.currentTimeMillis();
        System.out.println("SparseMatrix time: " + (end - start));

        start = System.currentTimeMillis();
        mSparseHash.product(mSparseHash);
        end = System.currentTimeMillis();

        System.out.println("SparseMatrixHash time: " + (end - start));
    }
}
