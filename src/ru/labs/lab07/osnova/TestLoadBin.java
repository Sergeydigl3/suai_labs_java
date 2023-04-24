package ru.labs.lab07.osnova;

import ru.labs.lab07.osnova.Settings;

import java.io.IOException;

public class TestLoadBin {
    public static void main(String[] args) {
        // Test for Settings
        Settings settings = new Settings();

        try {
            settings.loadFromBinaryFile("src/ru/labs/lab07/settings.bin");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(settings.get("key1"));

    }
}
