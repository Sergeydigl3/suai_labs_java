package ru.labs.lab01;

public class Main {
    public static void main(String[] args) {
        CustomInt customInt = new CustomInt(0);
        System.out.println(customInt);
        customInt.increment();
        System.out.println(customInt);
        customInt.decrement();
        System.out.println(customInt);
        customInt.add(5);
        System.out.println(customInt);
        customInt.subtract(3);
        System.out.println(customInt);
    }
}