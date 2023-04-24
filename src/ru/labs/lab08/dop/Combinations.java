package ru.labs.lab08.dop;

public class Combinations {

    private int n;
    private int k;
    private int[][] combinations;
    private int numThreads;

    public Combinations(int n, int k, int numThreads) {
        this.n = n;
        this.k = k;
        this.combinations = new int[binomial(n, k)][k];
        this.numThreads = numThreads;
    }

    public int[][] generateCombinations() throws InterruptedException {
        Thread[] threads = new Thread[numThreads];
        CombinationWorker[] workers = new CombinationWorker[numThreads];

        // Выделяем задачи многопоточное выполнение
        int blockSize = combinations.length / numThreads;
        for (int i = 0; i < numThreads; i++) {
            int start = i * blockSize;
            int end = (i == numThreads - 1) ? combinations.length : i * blockSize + blockSize;
            workers[i] = new CombinationWorker(start, end);
            threads[i] = new Thread(workers[i]);
            threads[i].start();
        }

        // Ждем выполнение всех задач
        for (Thread thread : threads) {
            thread.join();
        }

        return combinations;
    }

    private class CombinationWorker implements Runnable {

        private final int startIndex;
        private final int endIndex;

        private CombinationWorker(int startIndex, int endIndex) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        @Override
        public void run() {
            int[] combination = new int[k];
            int index = 0;

            // Инициализация первой комбинации
            for (int i = 0; i < k; i++) {
                combination[i] = i;
            }

            // Генерация всех комбинаций для этого диапазона индексов
            while (combination[k - 1] < n && index < endIndex - startIndex) {
                // Запись полученной комбинации в массив результатов
                System.arraycopy(combination, 0, combinations[startIndex + index], 0, k);
                index++;

                // Находим новую комбинацию
                int t = k - 1;
                while (t != 0 && combination[t] == n - k + t) {
                    t--;
                }
                combination[t]++;
                for (int i = t + 1; i < k; i++) {
                    combination[i] = combination[i - 1] + 1;
                }
            }
        }
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

