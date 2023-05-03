package ru.labs.lab08.dop;

import java.util.Arrays;

public class Combinations {
    private int n;
    private int k;
    private int[][] combinations;
    private int numThreads;

    public Combinations(int n, int k, int numThreads) {
        this.n = n;
        this.k = k;
        this.numThreads = numThreads;

        int combinationsCount = binomial(n, k);
        this.combinations = new int[combinationsCount][k];
    }

    public int[][] generateCombinations() throws InterruptedException {
        int combinationsPerThread = combinations.length / numThreads;
        int remainingCombinations = combinations.length % numThreads;

        Thread[] threads = new Thread[numThreads];
        CombinationWorker[] workers = new CombinationWorker[numThreads];


        // Создаем и запускаем потоки для каждого блока комбинаций
        for (int i = 0; i < numThreads; i++) {
            int start = i * combinationsPerThread + Math.min(i, remainingCombinations);
            int end = start + combinationsPerThread + (i + 1 <= remainingCombinations ? 1 : 0);

            int[][] subArray = Arrays.copyOfRange(combinations, start, end);
            workers[i] = new CombinationWorker(subArray);
            threads[i] = new Thread(workers[i]);
            threads[i].start();
        }


        // Ждем завершения всех потоков
        for (Thread thread : threads) {
            thread.join();
        }

        return combinations;
    }

    private class CombinationWorker implements Runnable {

        private final int[][] subArray;

        private CombinationWorker(int[][] subArray) {
            this.subArray = subArray;
        }

        @Override
        public void run() {
            int[] combination = new int[k];

            int startIndex = indexForCombination(combination);
            int endIndex = startIndex + subArray.length;

            // Генерация всех комбинаций
            for (int i = startIndex, j = 0; i < endIndex; i++, j++) {
                // Запись полученной комбинации в массив результатов
                int[] result = combinationAtIndex(i);
                System.arraycopy(result, 0, subArray[j], 0, k);
            }
        }
    }

    private int indexForCombination(int[] combination) {
        int index = 0;
        int j = 1;

        for (int i = 0; i < k; i++) {
            index += binomial(n - combination[i], k - j);
            j++;
        }

        return binomial(n, k) - index;
    }

    private int[] combinationAtIndex(int index) {
        int[] combination = new int[k];

        for (int i = 0; i < k; i++) {
            combination[i] = i;
        }

        int t = k - 1;
        while (t >= 0 && combination[t] == n - k + t) {
            t--;
        }
        if (t < 0) {
            return combination;
        }

        combination[t]++;
        for (int i = t + 1; i < k; i++) {
            combination[i] = combination[i - 1] + 1;
        }

        for (int i = 1; i < index; i++) {
            t = k - 1;
            while (t >= 0 && combination[t] == n - k + t) {
                t--;
            }
            if (t < 0) {
                return combination;
            }
            combination[t]++;
            for (int j = t + 1; j < k; j++) {
                combination[j] = combination[j - 1] + 1;
            }
        }

        return combination;
    }

    private static int binomial(final int n, final int k) {
        if (k < 0 || k > n) {
            return 0;
        }
        if (k > n - k) {
            return binomial(n, n - k);
        }
        int ans = 1;
        for (int i = 1, j = n; i <= k; i++, j--) {
            ans = ans * j / i;
        }
        return ans;
    }
}
