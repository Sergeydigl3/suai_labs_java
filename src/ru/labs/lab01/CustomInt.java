package ru.labs.lab01;

public class CustomInt {
    private int value;

    public CustomInt(int value) {
        this.value = value;
    }

    public CustomInt(){
        this.value = 0;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void increment() {
        value++;
    }

    public void decrement() {
        value--;
    }

    public void add(int value) {
        this.value += value;
    }

    public void subtract(int value) {
        this.value -= value;
    }

    public String toString() {
        String temp = String.valueOf(this.value);
        return temp;
    }
}
