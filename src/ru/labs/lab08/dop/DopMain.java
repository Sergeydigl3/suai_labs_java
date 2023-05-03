package ru.labs.lab08.dop;

import java.util.Arrays;

// Реализуйте многопоточную генерацию комбинаций A_без_повторений(n,k). Подберите n и k число потоков, чтобы выиграть у однопоточной версии.
public class DopMain {
    public static void main(String[] args) {
        int n = 6;
        int k = 5;
        int numThreads = 1;

        Combinations combinations = new Combinations(n, k, numThreads);
        try {
            int[][] result = combinations.generateCombinations();
            for (int[] ints : result) {
                System.out.println(Arrays.toString(ints));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
