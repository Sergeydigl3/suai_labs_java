package ru.labs.lab10;

import ru.labs.lab10.synchroStacks.SynchroStack;

public class TestSynchroStack {
    public static void main(String[] args) {
        SynchroStack stack = new SynchroStack();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                stack.push(i);
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                stack.pop();
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(stack);
    }
}
