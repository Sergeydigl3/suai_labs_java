package ru.labs.lab08;

import ru.labs.lab08.matrixes.*;
import ru.labs.lab08.matrixes.UsualMatrix;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int rows = 1500, cols = 1500;
        UsualMatrix matrix1 = new UsualMatrix(rows, cols);
        UsualMatrix matrix2 = new UsualMatrix(cols, rows);
        UsualMatrix resultMatrixRegular;
        UsualMatrix resultMatrixParallel;

        // Fill the matrices with random values
        matrix1.fillRandom(0,100);
        matrix2.fillRandom(0,100);

        int threadsCount = 20;
        ParallelMatrixProduct parallelMatrixProduct = new ParallelMatrixProduct();

        // Calculate regular matrix multiplication
        long startTimeRegular = System.currentTimeMillis();
        resultMatrixRegular = matrix1.product(matrix2);
        long endTimeRegular = System.currentTimeMillis();
        long timeTakenRegular = endTimeRegular - startTimeRegular;
        System.out.println("Time taken for regular multiplication: " + timeTakenRegular + " milliseconds");

        // Calculate parallel matrix multiplication
        long startTimeParallel = System.currentTimeMillis();
        resultMatrixParallel = parallelMatrixProduct.multiply(matrix1, matrix2);
        long endTimeParallel = System.currentTimeMillis();
        long timeTakenParallel = endTimeParallel - startTimeParallel;
        System.out.println("Time taken for parallel multiplication: " + timeTakenParallel + " milliseconds");
    }
}
