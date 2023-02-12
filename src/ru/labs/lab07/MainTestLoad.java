package ru.labs.lab07;

import java.io.IOException;

public class MainTestLoad {
    public static void main(String[] args) {
        // Test for Settings
        Settings settings = new Settings();

        try {
            settings.loadFromTextFile("src/ru/labs/lab07/settings.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(settings.get("key1"));

    }
}
