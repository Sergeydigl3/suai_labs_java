package ru.labs.lab05;

import ru.labs.lab05.matrixes.SparseMatrix;
import ru.labs.lab05.matrixes.SparseMatrixHash;

public class DopMain {
    public static void main(String[] args){
        // Сравнить две реализации SparseMatrix с помощью System.currentTimeMillis() и вывести на экран время работы каждой из них.

        SparseMatrix mSparse = new SparseMatrix(200, 200);
        SparseMatrixHash mSparseHash = new SparseMatrixHash(200, 200);

        // fill with random
        for (int i = 0; i < 200; i++) {
            for (int j = 0; j < 200; j++) {
                mSparse.setElement(i, j, (int) (Math.random() * 200));
                mSparseHash.setElement(i, j, (int) (Math.random() * 200));
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
